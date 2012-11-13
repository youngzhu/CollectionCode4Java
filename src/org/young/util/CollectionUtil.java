package org.young.util;

import java.util.Collection;
import java.util.List;

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
	
	public static void printArray(Object[] arr) {
        boolean isFirst = true;

        for (Object obj : arr) {
            if (isFirst) {
                isFirst = false;
            } else {
                System.out.print(", ");
            }

            System.out.print(obj);
        }
    }
	
	public static void printList(List<? extends Object> list) {
        boolean isFirst = true;

        for (Object obj : list) {
            if (isFirst) {
                isFirst = false;
            } else {
                System.out.print(", ");
            }

            System.out.print(obj);
        }
    }
}
