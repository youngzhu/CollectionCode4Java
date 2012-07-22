package org.young.util;

public class Utils {

	public static void printArray(int[] arr) {
		boolean isFirst = true;
		
		for (int i : arr) {
			if (isFirst) {
				isFirst = false;
			} else {
				System.out.print(", ");
			}
			System.out.print(i);
		}
	}
}
