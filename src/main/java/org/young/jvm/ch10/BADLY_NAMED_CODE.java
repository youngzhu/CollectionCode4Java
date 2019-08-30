package org.young.jvm.ch10;

/**
 * 不规范命名的测试代码
 *
 * @author by Young.ZHU
 *      on 2014年8月9日
 *
 * Package&FileName: org.young.jvm.ch10.BADLY_NAMED_CODE
 */
public class BADLY_NAMED_CODE {

	enum colors {
		red, blue, green;
	}
	
	static final int _FORTY_TWO = 42;
	
	public static int NOT_A_CONSTANT = _FORTY_TWO;
	
	protected void BADLY_NAME_CODE() {
		return;
	}
	
	public void NOTcamelCASEmethodName() {
		return;
	}
}
