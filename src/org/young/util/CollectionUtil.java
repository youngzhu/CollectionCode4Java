package org.young.util;

import java.util.Collection;

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
}
