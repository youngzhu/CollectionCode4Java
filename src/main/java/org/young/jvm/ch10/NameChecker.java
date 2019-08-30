package org.young.jvm.ch10;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner7;
import javax.tools.Diagnostic.Kind;

import static javax.lang.model.element.ElementKind.*;
import static javax.lang.model.element.Modifier.*;

/**
 * 命名检查器 NameChecker
 * 
 * 程序名称规范的编译器插件
 * 如果程序名称不合规范，则输出一个编译器的 WARNING 信息
 *
 * @author by Young.ZHU
 *      on 2014年8月9日
 *
 * Package&FileName: org.young.jvm.ch10.NameChecker
 */
public class NameChecker {
	
	private final Messager messager;
	
	NameCheckScanner scanner = new NameCheckScanner();

	public NameChecker(ProcessingEnvironment processingEnv) {
		this.messager = processingEnv.getMessager();
	}

	/**
	 * 对程序命名进行检查，规则如下：
	 * 类或接口：符合驼峰命名法，首字母大写
	 * 方法：符合驼峰命名法，首字母小写
	 * 
	 * 实例变量：符合驼峰命名法，首字母小写
	 * 常量：全部大写
	 * 
	 * @param element
	 */
	public void checkNames(Element element) {
		scanner.scan(element);
	}
	
	/**
	 * 名称检查器实现类
	 *
	 * @author by Young.ZHU
	 *      on 2014年8月9日
	 *
	 * Package&FileName: org.young.jvm.ch10.NameCheckScanner
	 */
	private class NameCheckScanner extends ElementScanner7 {
	
		/**
		 * 检查Java类
		 */
		@Override
		public Object visitType(TypeElement e, Object p) {
			scan(e.getTypeParameters(), p);
			checkCamelCase(e, true);
			
			return super.visitType(e, p);
		}
		
		/**
		 * 检查方法名
		 */
		@Override
		public Object visitExecutable(ExecutableElement e, Object p) {
			if (METHOD == e.getKind()) {
				Name name = e.getSimpleName();
				
				if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
					messager.printMessage(Kind.WARNING,  "一个普通方法 " + name + "不应该与类名重复，避免与构造函数混淆", e);
				}
				
				checkCamelCase(e, false);
			}
			return super.visitExecutable(e, p);
		}
		
		/**
		 * 检查变量名
		 * 
		 * 如果变量是 枚举值 或者 常量，则按大写命名检查
		 * 否则，按驼峰式命名法检查
		 */
		@Override
		public Object visitVariable(VariableElement e, Object p) {
			
			if (ENUM_CONSTANT == e.getKind() || null != e.getConstantValue() 
					|| heuristicallyConstant(e)) {
				// 如果变量是 枚举值 或者 常量，则按大写命名检查
				checkAllCaps(e);
			} else {
				// 否则，按驼峰式命名法检查
				checkCamelCase(e, false);
			}
			return super.visitVariable(e, p);
		}

		/**
		 * 判断一个变量是否是常量
		 * 
		 * @param e
		 * @return
		 */
		private boolean heuristicallyConstant(VariableElement e) {
			if (INTERFACE == e.getEnclosingElement().getKind()) {
				return true;
			} else if (FIELD == e.getKind() && e.getModifiers().containsAll(EnumSet.of(PUBLIC, STATIC, FINAL))) {
				return true;
			} 
			
			return false;
		}

		/**
		 * 大写命名检查
		 * 
		 * 要求第一个字母必须是大写的英文字母，其余部分可以是下划线或者大写字母
		 * @param e
		 */
		private void checkAllCaps(VariableElement e) {

			String name = e.getSimpleName().toString();
			
			boolean conventional = true;
			
			int firstCodePoint = name.codePointAt(0);
			
			if (! Character.isUpperCase(firstCodePoint)) {
				conventional = false;
			} else {
				boolean previourUnderscore = false;
				
				int cp = firstCodePoint;
				
				for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
					cp = name.codePointAt(i);
					
					if ((int) '_' == cp) {
						if (previourUnderscore) {
							conventional = false;
							break;
						}
						
						previourUnderscore = true;
					} else {
						previourUnderscore = false;
						
						if (! Character.isUpperCase(cp ) &&  ! Character.isDigit(cp)) {
							conventional = false;
							
							break;
						}
					}
				}
			}
			
			if (!conventional) {
				messager.printMessage(Kind.WARNING, "常量 " + name + " 应该全部以大写字母或者下划线命名，并且以字母开头", e);
			}
			
		}

		/**
		 * 检查传入的 Element 是否符合驼峰式命名法
		 * 如果不符合，则输出警告信息
		 * 
		 * @param e
		 * @param b
		 */
		private void checkCamelCase(Element e, boolean b) {
			
			String name = e.getSimpleName().toString();
			
			boolean previousUpper = false;
			boolean conventional = true;
			
			int firstCodePoint = name.codePointAt(0);
			
			if (Character.isUpperCase(firstCodePoint)) {
				previousUpper = true;
				
				if (! b) {
					messager.printMessage(Kind.WARNING, "名称 " + name + " 应该以小写字母开头", e);
					
					return;
				}
			} else if (Character.isLowerCase(firstCodePoint)) {
				
				if (b) {
					messager.printMessage(Kind.WARNING, "名称 " + name + " 应该以大写字母开头", e);
					
					return;
				}
				
			} else {
				conventional = false;
			}
			
			if (conventional) {
				int cp = firstCodePoint;
				
				for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
					cp = name.codePointAt(i);
					
					if (Character.isUpperCase(cp)) {
						if (previousUpper) {
							conventional = false;
							break;
						}
						
						previousUpper = true;
						
					} else {
						previousUpper = false;
					}
				}
			}
			
			if (!conventional) {
				messager.printMessage(Kind.WARNING, "名称 " + name + " 应该符合驼峰命名法", e);
			}
			
		}
	}

}
