package com.xu.dao;

import com.xu.pojo.Sc;
import com.xu.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ScDao {

    public static int add(Connection con, Sc sc)throws Exception{
        String sql="insert into sc values(?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, sc.getStudentId());
        pstmt.setString(2, sc.getCourseId());
        pstmt.setInt(3,sc.getGrade());
        return pstmt.executeUpdate();
    }
}
