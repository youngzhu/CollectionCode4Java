package org.young.util;

import java.util.Map;
import java.util.Properties;

/**
 * 系统相关的工具类
 *
 * @author by Young.ZHU
 *		on 2013-7-3
 *
 * Package&FileName: org.young.util.SystemUtil
 */
public class SystemUtil {

	public static void printProperties () {
		Properties prop = System.getProperties(); 
		
		for (Map.Entry<Object, Object> m : prop.entrySet()) {
			System.out.println(m.getKey() + "::::" + m.getValue());
		}
		
	}
}
