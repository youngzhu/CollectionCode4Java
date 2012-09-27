package org.young.util;

import java.util.Collection;

import org.young.constant.ConstantString;

/**
 * 
 * @author by Young.ZHU
 * on 下午11:09:16 2012-9-21
 *
 * Package: org.young.util.CollectionUtil
 */
public class CollectionUtil {

	public static boolean isEmpty(Collection<?> collection) {
		
		return null == collection || 0 == collection.size();
	}
	
	public static String getString(Object[] objArr) {
		String str = ConstantString.STR_EMPTY;
		
		for (Object obj : objArr) {
			str += obj + ConstantString.STR_ENTER;
		}
		
		return str;
	}
	
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
