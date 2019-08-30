package org.young.db.sql;

public abstract class AbstractCommonSQL implements ICommonSQL {

	/**
	 * 获得开始的索引值 
	 * 
	 * @param pageNum - 当前页
	 * @param pageSize - 每页记录数
	 * @return
	 */
	public int getStartIndex(int pageNum, int pageSize) {
		
		return (pageSize * (pageNum - 1));
	}
}
