/*
package com.xu.util;

import java.sql.*;

public class JdbcUtil {
    private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //数据库连接参数
    private static final String url="jdbc:sqlserver://localhost:1433;databasename=STUDB";
    private static final String name="sa";
    private static final String password="123456";
    //注册驱动（仅需一次用静态方法）
    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,password);
    }

    //释放资源(方法重用)
   */
/* public static void close(Connection conn, Statement stmt){
        close(conn, stmt);
    }
*//*

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            if (rs!= null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt !=null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
*/
