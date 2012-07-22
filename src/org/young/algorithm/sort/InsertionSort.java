package org.young.algorithm.sort;

/**
 * 插入排序（Insertion Sort）
 * 
 * @author by Young.ZHU
 * on 下午10:27:21 2012-7-22
 *
 * Package: org.young.algorithm.sort.InsertionSort
 */
public class InsertionSort {

	public static void sortByAsc(int[] arr) {
		for(int j = 1; j < arr.length; j ++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i --;
			}
			arr[i + 1] = key;
		}
	}
	
	public static void sortByDesc(int[] arr) {
		for(int j = 1; j < arr.length; j ++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] < key) {
				arr[i + 1] = arr[i];
				i --;
			}
			arr[i + 1] = key;
		}
	}
}
