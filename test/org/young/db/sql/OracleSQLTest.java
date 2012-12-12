package org.young.db.sql;

import org.junit.Before;
import org.junit.Test;

public class OracleSQLTest extends CommonSQLTest {

	private static final String SQL_SELECT = "select * from ryx.tbl_plcinfo";
	
	private static final String SQL_SELECT_WHERE = "select * from ryx.tbl_plcinfo where sftd='1'";
	
	private static final String SQL_SELECT_WHERE_ORDER = "select * from ryx.tbl_plcinfo where sftd='1' ORDER BY LRSJ";
	
	private static final String SQL_SELECT_ORDER = "select * from ryx.tbl_plcinfo ORDER BY LRSJ";
	
	@Before
	public void init() {
		sqlObj = new OracleSQL();
	}
	
	@Test
	public void testGetPagingSQL_Order() {
		String sql1 = sqlObj.getPagingSql(SQL_SELECT, 10, 1);
		System.out.println(sql1);
		
		String sql2 = sqlObj.getPagingSql(SQL_SELECT, 10, 2);
		System.out.println(sql2);
		
		String sqlWhere1 = sqlObj.getPagingSql(SQL_SELECT_WHERE, 10, 1);
		System.out.println(sqlWhere1);
		
		String sqlWhere2 = sqlObj.getPagingSql(SQL_SELECT_WHERE, 10, 2);
		System.out.println(sqlWhere2);
		
		String sqlOrder1 = sqlObj.getPagingSql(SQL_SELECT_ORDER, 10, 1);
		System.out.println(sqlOrder1);
		
		String sqlOrder2 = sqlObj.getPagingSql(SQL_SELECT_ORDER, 10, 2);
		System.out.println(sqlOrder2);
		
		String sqlWhereOrder1 = sqlObj.getPagingSql(SQL_SELECT_WHERE_ORDER, 10, 1);
		System.out.println(sqlWhereOrder1);
		
		String sqlWhereOrder2 = sqlObj.getPagingSql(SQL_SELECT_WHERE_ORDER, 10, 2);
		System.out.println(sqlWhereOrder2);
	}
	
	@Test
	public void testGetPagingSQL_Simple() {
		String sql = sqlObj.getPagingSql(SQL_SELECT, 10, 1);
		System.out.println(sql);
		
		String sql2 = sqlObj.getPagingSql(SQL_SELECT_WHERE, 10, 1);
		System.out.println(sql2);
	}
	
	@Test
	public void testGetPagingSQL_Where() {
		String sql3 = sqlObj.getPagingSql(SQL_SELECT_WHERE, 10, 2);
		System.out.println(sql3);
		
		String sql4 = sqlObj.getPagingSql(SQL_SELECT, 10, 2);
		System.out.println(sql4);
	}
	
}
