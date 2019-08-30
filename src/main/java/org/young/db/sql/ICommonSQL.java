package org.young.db.sql;

public interface ICommonSQL {

	/**
	 * 分页
	 * 
	 * @param querySql
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	String getPagingSql(String querySql, int pageSize,
	        int pageNum);
}
