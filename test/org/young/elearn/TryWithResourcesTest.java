package org.young.elearn;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * try-with-resources 的使用
 * try(resouces)
 * {
 * 
 * } catch (Exception e){}
 * 
 * 这里的resource会自动关闭
 * 
 * 1. resource 必须继承自 java.lang.AutoCloseable
 * 2. 定义和赋值必须都在try里完成
 * 
 * 
 *
 * @author by Young.ZHU
 *      on 2016年5月29日
 *
 * Package&FileName: org.young.elearn.TryWithResourcesTest
 */
public class TryWithResourcesTest {
	
	/**
	 * 验证一下资源是不是真的关闭了
	 */
	@Test
	public void test() {

		try (MyResources mr = new MyResources()) {
//			mr.doSomething(4);
			mr.doSomething(9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 编译错误：
	 * The resource f of a try-with-resources statement cannot be assigned
	 */
	@Test
	public void test2() {
		try (FileOutputStream f = null;) {
//			f = new FileOutputStream(new File(""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编译错误：
	 * The resource type File does not implement java.lang.AutoCloseable
	 */
	@Test
	public void test1() {
		/*try (File file = new File("d:\\xx.txt");) {
			
		} */
	}

}

class MyResources implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("resources are closed.");
	}
	
	public void doSomething(int num) throws Exception {
		if (num % 2 == 0) {
			System.out.println("it's OK.");
		} else {
			throw new Exception("Enter an even.");
		}
	}
}
