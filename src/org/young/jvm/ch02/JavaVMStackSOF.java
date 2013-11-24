package org.young.jvm.ch02;

/**
 * VM Args: -Xss128k
 * 
 * JDK7:
 * The stack size specified is too small, Specify at least 228k
 * 
 * @author by Young.ZHU
 * 	on 2013年11月10日
 *
 * ch02.JavaVMStackSOF
 */
public class JavaVMStackSOF {

	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack length:" + oom.stackLength);
			throw e;
		}

	}

}
