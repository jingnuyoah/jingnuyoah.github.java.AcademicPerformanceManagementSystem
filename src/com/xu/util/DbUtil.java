package com.xu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String dbUrl="jdbc:sqlserver://localhost:1433;databasename=AcademicPerformanceDB";
    private static String dbUserName="sa";
    private static String dbPassword="123456";
    private static String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //获取数据库连接
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(jdbcName);
        Connection con= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
    //关闭数据库连接
    public static void closeCon(Connection con) throws SQLException {
        if (con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil=new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
    }
}
