package org.young.util;

import java.util.List;

import org.young.constant.ConstantSQL;
import org.young.constant.ConstantString;


import static org.junit.Assert.*;

/**
 * 
 * @author by Young.ZHU
 * on 下午10:46:05 2012-9-21
 *
 * Package: org.young.util.SQLUtil
 */
public class SQLUtil {

	public static final String MSG_COLUMN_NOT_EMPTY = "The Column List Should Not Be Empty!";
	
	public static String buildWhereStateAND(List<String> colList) {
		assertFalse(MSG_COLUMN_NOT_EMPTY, CollectionUtil.isEmpty(colList));
		
		String sql = ConstantString.STR_EMPTY;
		
		int length = colList.size();
		for (int i = 0; i < length; i++) {
			if (0 != i) {
				sql += ConstantSQL.SQL_AND;
			}
			sql += colList.get(i) + ConstantString.STR_EQUAL + ConstantString.STR_QUESTION_MARK;
		}
		
		return sql;
	}
	
	/**
	 * 返回类似 (?, ?, ?, ?)
	 * @param paramsNum 参数个数
	 * @return
	 */
	public static String buildParamsWithQuestionMark(int paramsNum) {
		StringBuffer sb = new StringBuffer();
		
		if (0 < paramsNum) {
			sb.append("(");
			for (int i = 0; i < paramsNum; i ++) {
				if (0 != i) {
					sb.append(", ");
				} 
				
				sb.append("?");
			}
			sb.append(")");
		}
		
		return sb.toString();
	}
}
