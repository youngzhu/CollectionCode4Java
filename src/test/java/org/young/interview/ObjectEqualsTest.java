package org.young.interview;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class ObjectEqualsTest {

	@Test
	public void testObject() {
		Object a = new Object();
		Object b = new Object();
		
		System.out.println(a.equals(b)); // false
		
		System.out.println(a.hashCode());
		System.out.println(a.hashCode());
		System.out.println(a.hashCode());
	}
	
	@Test
	public void testString() {
		String x = new String("xyz");
		String y = new String("xyz");
		String z = "xyz";
		String zz = "xyz";
		
		System.out.println(x.equals(y)); // true
		System.out.println(x == y); // false
		
		System.out.println(x.equals(z)); // true
		System.out.println(x == z); // false
		
		System.out.println(zz.equals(z)); // true
		System.out.println(zz == z); // true
		
	}
	
	/**
	 * 如果两个对象相等（equals），则 hashCode 一定相等；
	 * 反过来则不成立，即 hashCode 相等，两个对象不一定相等。
	 * 
	 * 以下举的几个例子不符合Java标准
	 * http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()
	 * 中文：http://tool.oschina.net/apidocs/apidoc?api=jdk-zh
	 * 
	 * 覆写 equals() 方法，必须满足以下条件：
	 * （前提，x／y／z 都是非空对象，non-null reference）
	 * 1 自反性：x.equals(x) 必须返回 true
	 * 2 对称性：当且仅当 y.equals(x) 返回 true 时， x.equals(y) 才能返回true
	 * 3 传递性：如果 x.equals(y)返回true，且 y.equals(z) 返回true，
	 * 		那么 x.equals(z)也应该返回true
	 * 4 一致性：只要对象的 equals() 方法没有被改变，x.equals(y) 不管被调用多少次，
	 * 		返回值必须是一致的（true or false）。
	 * 5 x.equals(null) 必须返回false
	 * 
	 * Object类的equals()方法：引用同一个对象时，才返回true，即 x == y
	 * 
	 * 注意：重写 equals() 方法时，通常都会重写 hashCode() 方法，为了符合
	 * 		hashCode()方法的协定声明：相等的对象必须具有相等的哈希码。
	 * 
	 * 覆写 hashCode() 方法，必须满足以下条件：
	 * 1 在应用执行期间，只要对象的 equals() 方法没被改变，hashCode() 方法不管被调用多少次，
	 * 		必须返回相同的整数。同一个应用的多次执行期间，可以返回不同的值
	 * 2 如果 x.equals(y) 返回true，那么 x.hashCode() 和 y.hashCode() 的返回值必须相等
	 * 3 如果 x.equals(y) 返回false，那么 x.hashCode() 和 y.hashCode() 的返回值不要求必须不相等，
	 * 		但是，为不相等的对象生成不同的哈希码可以提高哈希表的性能
	 * 
	 */
	@Test
	public void testEquals() {
		/*
		 * equals() ，永远返回true
		 * hashCode() ，返回随机数
		 */
		A a1 = new A();
		A a2 = new A();
		
		System.out.println("AAAAAAAAAAAAAAA");
		System.out.println(a1.equals(a2)); // true
		System.out.println(a1 + "+++++" + a2); // 相同
		System.out.println(a1);
		System.out.println(a1);
		System.out.println(a1);
		
		
		B b1 = new B("b1");
		B b2 = new B("b2");
		B b3 = new B("b1");
		
		System.out.println("BBBBBBBBBBBBB");
		System.out.println(b1.equals(b2)); // true
		System.out.println(b1 + "+++" + b2); // 不同
		
		/*
		 * equals() -> true
		 * hashCode() -> 不同
		 */
		Set set = new HashSet();
		set.add(b1);
		set.add(b2);
		set.add(b3);
		System.out.println(set.size()); // 2
		
		C c1 = new C();
		C c2 = new C();
		
		System.out.println("CCCCCCCCCCCC");
		System.out.println(c1.equals(c2)); // false
		System.out.println(c1 + "+++" + c2); // 相同
		
		/*
		 * equals() -> false
		 * hashCode() -> 相同
		 */
		Set set1 = new HashSet();
		set1.add(c1);
		set1.add(c2 );
		System.out.println(set1.size()); // 2
	}

}

class A {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return new Random().nextInt();
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.hashCode());
	}
}

class B {
	
	private String b;
	
	public B(String str) {
		b = str;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return b.hashCode();
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.hashCode());
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
}

class C {
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.hashCode());
	}
}
