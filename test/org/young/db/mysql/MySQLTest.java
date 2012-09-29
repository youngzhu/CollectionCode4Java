package org.young.db.mysql;

import org.junit.Test;


public class MySQLTest {
    //~ Static fields/initializers *********************************************

    private static final String QUERY_SQL = "SELECT * FROM T_EMPLOYEE";

    //~ Methods ****************************************************************

    @Test
    public void testGetPagingSql() {
        String str1 = MySQL.getPagingSql(QUERY_SQL, 5, 1);

        String str2 = MySQL.getPagingSql(QUERY_SQL, 10, 8);

        System.out.println(str1);

        System.out.println(str2);
    }
}
