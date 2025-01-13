/*
package com.xu.dao;

import com.xu.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static User login(Connection con, User user) throws SQLException {
        User resultUser=null;
        String sql="select * from useraccount where userName=? and userpassword=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getUserpassword());
        ResultSet rs= pstmt.executeQuery();
        //判断结果集是否有下条记录，有记录对其实例化
        if (rs.next()){
            resultUser=new User();
            resultUser.setLocked(rs.getInt("locked"));
            resultUser.setUsername(rs.getString("username"));
            resultUser.setUserpassword(rs.getString("userpassword"));
        }
        if (rs!=null){
            rs.close();
        }
        if (pstmt!=null){
            pstmt.close();
        }
        if (con!=null){
            con.close();
        }
        return resultUser;
    }
}
*/


package com.xu.dao;

import com.xu.pojo.User;
import com.xu.util.DbUtil;
import com.xu.util.LoginAttemptCache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public static User login(Connection con, User user) throws SQLException {
        User resultUser = null;
        String sql = "SELECT * FROM useraccount WHERE userName = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            if (rs.getInt("locked") == 1) {
                throw new SQLException("账号已被锁定！");
            }
            String dbPassword = rs.getString("userpassword");

            // 获取登录尝试次数
            int loginAttempts = LoginAttemptCache.getLoginAttempts(user.getUsername());

            if (dbPassword.equals(user.getUserpassword())) {
                resultUser = new User();
                resultUser.setUsername(rs.getString("username"));
                resultUser.setUserpassword(rs.getString("userpassword"));
                resultUser.setLocked(rs.getInt("locked"));
                resultUser.setLoginAttempts(0); // 重置登录失败次数

                // 更新缓存中的登录失败次数
                LoginAttemptCache.resetLoginAttempts(user.getUsername());
            } else {
                loginAttempts++;
                if (loginAttempts >= LoginAttemptCache.MAX_ATTEMPTS) {
                    lockAccount(con, user.getUsername());
                    throw new SQLException("账号已被锁定！");
                } else {
                    LoginAttemptCache.setLoginAttempts(user.getUsername(), loginAttempts);
                    throw new SQLException("密码错误！");
                }
            }
        } else {
            throw new SQLException("账号不存在！");
        }

        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        return resultUser;
    }

    private static void lockAccount(Connection con, String username) throws SQLException {
        String sql = "UPDATE useraccount SET locked = 1 WHERE userName = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        }
    }
}
