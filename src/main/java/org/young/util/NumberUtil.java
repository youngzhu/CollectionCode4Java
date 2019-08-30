package org.young.util;

/**
 * 数字相关的常用方法
 * 
 * @author by Young.ZHU on 2012-10-17
 * 
 *         Package&FileName: org.young.util.NumberUtil
 */
public class NumberUtil {
	
	private static final Double MAX_MONEY_VALUE = 999999999999.99;
	/**
	 * 人民币转成大写
	 * 		最大单位：仟亿
	 * 		最小单位：分
	 * 		最大可转换金额：999999999999.99 （玖仟玖佰玖拾玖亿玖仟玖佰玖拾玖万玖仟玖佰玖拾玖圆玖角玖分）
	 * 
	 * @param money
	 * @return String
	 */
	public static String getRMB(double money) throws Exception {
		
		if (MAX_MONEY_VALUE < money) {
			throw new Exception("The MAX VALUE is " + MAX_MONEY_VALUE);
		}
		
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digitCN = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		
		long midVal = (long) (money * 100); // 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串

		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		
		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			suffix = digitCN[rail.charAt(0) - '0'] + "角"
					+ digitCN[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			/**
			 *  - 1 是因为个位数没有单位，最低十位数——“拾”
			 */
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; 
				if (zero == '0') { // 标志
					zero = digitCN[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			
			zeroSerNum = 0; // 连续0次数清零
			
			if (zero != '0') { // 如果标志不为0,则加上"零"
				prefix += zero;
				zero = '0';
			}
			
			prefix += digitCN[chDig[i] - '0']; // 转化该数字表示
			if (idx > 0) {
				prefix += hunit[idx - 1];
			}
				
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
			}
		}

		if (prefix.length() > 0)
			prefix += '圆'; // 如果整数部分存在,则有圆的字样
		
		return prefix + suffix; // 返回正确表示（整数部分 + 小数部分）
	}
}
