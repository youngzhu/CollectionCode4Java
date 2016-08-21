package org.young.util;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 *
 * @author by youngz
 *      on 2016年8月6日
 *
 * Package&FileName: org.young.util.MathUtil
 */
public abstract class MathUtil {
	
	// 用来匹配数字的正则表达式
	private static final Pattern PATTERN_NUMBER = Pattern.compile("\\d+||(\\d+\\.\\d+)");

	public static Number doCalculate(String formula, Number... operands) throws Exception {
		// 将公式中的 $n 替换成数字
		// "$0 + $1"
		int i = 0;
		for (Number num : operands) {
			formula = formula.replace("$" + i, num.toString());
			
			i++;
		}
		
		
		String postfix = infixToPostfix(formula);
		
		System.out.println("formula===" + formula);
		System.out.println("postfix===" + postfix);
		
		return evaluate(postfix);
	}
	
	public static Number evaluate(String postfix) throws Exception {
		Stack<Number> opStack = new Stack<Number>();
		
		String[] opArr = postfix.split(" ");
		
		for (String op : opArr) {
			if (PATTERN_NUMBER.matcher(op).matches()) {
				// 数字
				opStack.push(new BigDecimal(op));
			} else {
				// 运算符
				if (-1 != "+-*/".indexOf(op)) {
					BinaryOperation bo = new BinaryOperation(op, opStack.pop(), opStack.pop());
					
					opStack.push(bo.evaluate());
				}
				
			}
		}
		
		return opStack.pop();
	}
	
	/**
	 * 将中缀表达式（infix expression）转换成后缀表达式（postfix expression）
	 * 
	 * 中缀表达式，即常见的公式书写方式：
	 * 		5 + ((1 + 2) * 4) − 3
	 * 后缀表达式：
	 * 		5 1 2 + 4 * + 3 −
	 * 
	 * 基本思路：
	 * （1） 遇到数字，直接输出。
	 * （2） 遇到操作符（op），
	 * 		a. 将栈中所有优先级高于或等于 op 的运算符出栈，并输出。
	 * 			从栈顶开始，依次弹出比当前处理的运算符优先级高或等于的运算符，左括号就停止。
	 * 		b. op 入栈
	 * （3） 遇到左括号直接入栈
	 * （4） 遇到右括号时，将靠近栈顶的第一个左括号（与右括号匹配的按个左括号）上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
	 * （5） 最后如果栈里还有操作符，则依次输出。
	 * 
	 * 
	 * @param infix － 中缀表达式
	 * @return
	 */
	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> operateStack = new Stack<Character>();
		
		if (null != infix
				&& infix.trim().length() > 0) {
			infix = infix.replaceAll(" ", ""); // 去掉所有空格
			
			int indexNum = 0; // 用于判断是否是连续的数字（大于10的数或者小数）
			
			for (int i = 0; i < infix.length(); i++) {
				char c = infix.charAt(i);
				
//				System.out.println("postfix: " + postfix);
//				System.out.println("operateStack: " + operateStack);
//				System.out.println("infix remain: " + infix.substring(i));
//				System.out.println("===========");
				
				switch (c) {
					case '(':
						// 左括号直接入栈
						operateStack.push(c);
						break;
					case ')' :
						// 遇到右括号，将左括号之前的操作符弹出，输出，并弹出左括号
						if (!operateStack.isEmpty()
								&& -1 != operateStack.search('(')) {
							char popChar = operateStack.pop();
							while ('(' != popChar) {
								postfix.append(' ').append(popChar);
								popChar = operateStack.pop();
							}
						}
						break;
					case '*' :
					case '/' :
						while (!operateStack.isEmpty()) {
							
							// 2 a 
							// 从栈顶开始，依次弹出比当前处理的运算符优先级高或等于的运算符，左括号就停止。
							char preOp = operateStack.pop(); // 当前栈顶操作符
							
							if ('*' == preOp
									|| '/' == preOp) {
								postfix.append(' ').append(preOp);
							} else {
								// 其余的重新入栈
								operateStack.push(preOp);
								break;
							}
						}
						
						// 2 b 入栈
						operateStack.push(c);
						break;
					case '+' :
					case '-' :
						while (!operateStack.isEmpty()) {
							// 2 a 
							//从栈顶开始，依次弹出比当前处理的运算符优先级高或等于的运算符，左括号就停止。
							
							char preOp = operateStack.pop(); // 当前栈顶操作符
							
							if ('(' == preOp) {
								// 左括号停止
								operateStack.push(preOp);
								break;
							} else {
								// 其余的出栈，输出
								postfix.append(' ').append(preOp);
							}
						}
						// 2 b 入栈
						operateStack.push(c);
						break;
					default: 
						// 数字，直接输出
//						System.out.println(i + "--" + indexNum + "---" + c);
//						System.out.println(postfix);
						
						if (1 == (i - indexNum)) {
							// 代表连续的数字
//							System.out.println("连续的数字: " + c);
						} else {
							// 否则加空格区分开来
							postfix.append(' ');
						}
						
						postfix.append(c);
						
//						System.out.println(postfix);
						
						indexNum = i;
				}
			}
			
			// 最后如果栈里还有操作符，则依次输出。
			while (! operateStack.isEmpty()) {
				postfix.append(' ').append(operateStack.pop());
			}
			
		}
		
		return postfix.toString().trim();
	}
}
