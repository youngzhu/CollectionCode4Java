package org.young.db.mysql;


/**
 * MySQL相关的代码收藏
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
     * @param pageSize 每页显示记录数
     * @param pageNum 当前页
     *
     * @return
     */
    public static String getPagingSql(String querySql, int pageSize,
        int pageNum) {
        StringBuffer sb = new StringBuffer();

        int          start    = (pageSize * (pageNum - 1));

        sb.append(querySql)
          .append((pageNum > 1) ? (" limit " + start + ", " + pageSize)
                            : (" limit " + pageSize));

        return sb.toString();
    }
}
