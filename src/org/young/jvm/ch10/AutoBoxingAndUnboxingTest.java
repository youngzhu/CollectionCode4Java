package org.young.jvm.ch10;

/**
 * 自动装箱，拆箱的测试
 *
 * @author by Young.ZHU
 *      on 2014年7月26日
 *
 * Package&FileName: org.young.jvm.ch10.AutoBoxingAndUnboxingTest
 */
public class AutoBoxingAndUnboxingTest {

	public static void main(String[] args) {
		
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		
		Long g = 3L;
		
		/*
		 * true
false
true
true
true
true
false
		 */
		System.out.println(c == d); // false => true
		System.out.println(e == f); // false => false
		System.out.println(c == (a + b)); // false => true
		System.out.println(c.equals(a + b)); // true => true
		System.out.println(g == (a + b)); // false => true
		System.out.println(c == d); // false => true
		System.out.println(g.equals(a + b)); // false => false
		
		System.out.println("Decompiled ...");
		
		/*********************************************
		 * 
		 * Decompiled Code 
		 * 反编译后的代码
		 * 
		 *********************************************/
		/*
		Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(2);
        Integer c = Integer.valueOf(3);
        Integer d = Integer.valueOf(3);
        Integer e = Integer.valueOf(321);
        Integer f = Integer.valueOf(321);
        Long g = Long.valueOf(3L);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c.intValue() == a.intValue() + b.intValue());
        System.out.println(c.equals(Integer.valueOf(a.intValue() + b.intValue())));
        System.out.println(g.longValue() == (long)(a.intValue() + b.intValue()));
        System.out.println(c == d);
        System.out.println(g.equals(Integer.valueOf(a.intValue() + b.intValue())));
        */
		
	}
}
