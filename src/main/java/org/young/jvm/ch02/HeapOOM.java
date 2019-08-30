package org.young.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author by Young.ZHU
 * 	on 2013年11月10日
 *
 * ch02.HeapOOM
 */
public class HeapOOM {
	static class OOMObject {
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while (true) {
			list.add(new OOMObject());
		}
	}

}
