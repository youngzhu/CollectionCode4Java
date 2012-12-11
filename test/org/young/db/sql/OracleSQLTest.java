package org.young.db.sql;

import org.junit.Before;
import org.junit.Test;

public class OracleSQLTest extends CommonSQLTest {

	private static final String SQL_SELECT = "select * from ryx.tbl_plcinfo";
	
	private static final String SQL_SELECT_WHERE = "select * from ryx.tbl_plcinfo where sftd='1'";
	
	@Before
	public void init() {
		sqlObj = new OracleSQL();
	}
	
	@Test
	public void testGetPagingSQL() {
		String sql = sqlObj.getPagingSql(SQL_SELECT, 10, 1);
		System.out.println(sql);
		
		String sql2 = sqlObj.getPagingSql(SQL_SELECT_WHERE, 10, 1);
		System.out.println(sql2);
		
		String sql3 = sqlObj.getPagingSql(SQL_SELECT_WHERE, 10, 2);
		System.out.println(sql3);
		
		String sql4 = sqlObj.getPagingSql(SQL_SELECT, 10, 2);
		System.out.println(sql4);
	}
}
