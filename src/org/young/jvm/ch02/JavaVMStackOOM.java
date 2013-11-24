package org.young.jvm.ch02;

/**
 * VM Args: -Xss2m
 * 
 * 注意：该类在执行时，可能会让系统有假死现象。
 * 
 * @author by Young.ZHU
 * 	on 2013年11月10日
 *
 * ch02.JavaVMStackOOM
 */
public class JavaVMStackOOM {
	
	private void dontStop() {
		while (true) {
			
		}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable(){
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {

		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
