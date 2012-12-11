package org.young.db.sql;

import org.young.constant.ConstantSQL;

public class OracleSQL extends AbstractCommonSQL {

	public String getPagingSql(String querySql, int pageSize, int pageNum) {
		StringBuffer sb = new StringBuffer();
		
		/*[pageNum == 1]
		 * select * from [TBL_NAME]
where rownum <= N
		 */
		if (1 == pageNum) {
			sb.append(querySql);
			
			if (querySql.toUpperCase().contains("WHERE")) {
				sb.append(ConstantSQL.SQL_AND);
					
			} else {
				sb.append(ConstantSQL.SQL_WHERE);
			}
			
			sb.append(" rownum <= ").append(pageSize);
		} else {
			/*[pageNum > 1]
			 * select t2.* from
	(select rownum rn, t1.* from [TBL_NAME] t1 where rownum <= M) t2
	where t2.rn > N
			*
			*select rownum rn, t1.* from (select * from [tbl_name]) t1 where rownum <= ?
			 */
			int start = super.getStartIndex(pageNum, pageSize);
			int end = start + pageSize;
			
			sb.append("select t_outter.* from(")
				.append("select rownum rn, t_inner.* from (")
				.append(querySql)
				.append(") t_inner where rownum <= ")
				.append(end)
				.append(") t_outter where t_outter.rn > ")
				.append(start);
		}
		
		
		return sb.toString();
	}

}
