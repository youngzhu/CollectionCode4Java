package org.young.util;

import java.math.BigDecimal;

/**
 * 双目操作符
 *
 * @author by youngz
 *      on 2016年8月20日
 *
 * Package&FileName: org.young.util.BinaryOperation
 */
public class BinaryOperation {

	private String operation; // 操作符
	private Number operandLeft; // 左操作数
	private Number operandRight; // 右操作数
	
	public BinaryOperation(String operation, Number operandLeft,
			Number operandRight) {
		this.operation = operation;
		this.operandLeft = operandLeft;
		this.operandRight = operandRight;
	}

	public Number evaluate() throws Exception {
		
		BigDecimal op1 = new BigDecimal(operandLeft.doubleValue());
		BigDecimal op2 = new BigDecimal(operandRight.doubleValue());
		
		switch (operation) {
		case "+":
			return op1.add(op2) ;
		case "-":
			return op2.subtract(op1);
		case "*":
			return op1.multiply(op2);
		case "/":
			return op2.divide(op1);
			
		default :
			throw new Exception("Unknown operation:" + operation);
		}
		
	}
	
}
