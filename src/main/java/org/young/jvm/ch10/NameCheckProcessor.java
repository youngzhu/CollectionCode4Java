package org.young.jvm.ch10;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * 注解处理器 NameCheckProcessor
 *
 * @author by Young.ZHU
 *      on 2014年8月9日
 *
 * Package&FileName: org.young.jvm.ch10.NameCheckProcessor
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class NameCheckProcessor extends AbstractProcessor {
	
	private NameChecker nameChecker;
	
	/**
	 * 初始化名称检查插件
	 */
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		
		nameChecker = new NameChecker(processingEnv);
	}

	/**
	 * 对输入的语法树的各个节点进行名称检查
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		
		if (! roundEnv.processingOver()) {
			for (Element element : roundEnv.getRootElements()) {
				nameChecker.checkNames(element);
			}
		}
		
		return false;
	}

}
