package org.young.db.mysql;


/**
 * MySQL相关的代码收�?
 *
 * @author by Young.ZHU
 *                on 2012-7-16
 *
 * Package&FileName: org.young.db.mysql.MySQL
 */
public class MySQL {
    //~ Methods ****************************************************************

    /**
     * 分页
     *
     * @param querySql 查询的SQL
     * @param pageSize 每页显示记录�?
     * @param pageIndex 当前�?
     *
     * @return
     */
    public static String getPagingSql(String querySql, int pageSize,
        int pageIndex) {
        StringBuffer sb = new StringBuffer();

        int          offset    = (pageSize * (pageIndex - 1));
        boolean      hasOffset = (pageIndex > 1);

        sb.append(querySql)
          .append(hasOffset ? (" limit " + offset + ", " + (offset + pageSize))
                            : (" limit " + pageSize));

        return sb.toString();
    }
}
