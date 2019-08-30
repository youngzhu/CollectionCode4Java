package org.young.db.sql;

import org.junit.Before;
import org.junit.Test;
import org.young.db.sql.MySQLSQL;


public class MySQLSQLTest  extends CommonSQLTest {
    //~ Static fields/initializers *********************************************

    private static final String QUERY_SQL = "SELECT * FROM T_EMPLOYEE";

    //~ Methods ****************************************************************

    @Before
    public void init() {
    	sqlObj = new MySQLSQL();
    }
    
    @Test
    public void testGetPagingSql() {
        String str1 = sqlObj.getPagingSql(QUERY_SQL, 5, 1);

        String str2 = sqlObj.getPagingSql(QUERY_SQL, 10, 8);

        System.out.println(str1);

        System.out.println(str2);
    }
}
