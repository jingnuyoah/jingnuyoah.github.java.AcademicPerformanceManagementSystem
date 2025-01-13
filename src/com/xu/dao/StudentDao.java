package com.xu.dao;

import com.xu.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static int add(Connection con, Student student)throws Exception{
        String sql="insert into student values(?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, student.getStudentId());
        pstmt.setString(2, student.getStudentName());
        pstmt.setString(3,student.getStudentSex());
        pstmt.setString(4, student.getStudentDept());
        pstmt.setString(5, student.getStudentBirth());
        return pstmt.executeUpdate();
    }
    public static List<Student> query(Connection con, Student student) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from student where 1=1");
        if (student.getStudentId() != null && !student.getStudentId().isEmpty()) {
            sql.append(" and sno = ?");
        }
        if (student.getStudentName() != null && !student.getStudentName().isEmpty()) {
            sql.append(" and sname = ?");
        }
        if (student.getStudentDept() != null && !student.getStudentDept().isEmpty()) {
            sql.append(" and dept = ?");
        }
        PreparedStatement pstmt = con.prepareStatement(sql.toString());
        int index = 1;
        if (student.getStudentId() != null && !student.getStudentId().isEmpty()) {
            pstmt.setString(index++, student.getStudentId());
        }
        if (student.getStudentName() != null && !student.getStudentName().isEmpty()) {
            pstmt.setString(index++, student.getStudentName());
        }
        if (student.getStudentDept() != null && !student.getStudentDept().isEmpty()) {
            pstmt.setString(index++, student.getStudentDept());
        }
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setStudentId(rs.getString("sno"));
            s.setStudentName(rs.getString("sname"));
            s.setStudentSex(rs.getString("sex"));
            s.setStudentDept(rs.getString("Dept"));
            s.setStudentBirth(rs.getString("Birth"));
            studentList.add(s);
        }
        rs.close();
        pstmt.close();
        return studentList;
    }

    public static int delete(Connection con, String studentId) throws SQLException {
        String sql = "delete from student where sno = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, studentId);
        return pstmt.executeUpdate();
    }

    public static int update(Connection con, Student student) throws SQLException {
        String sql = "update student set sname = ?, Sex = ?, Dept = ?, Birth = ? where sno = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, student.getStudentName());
        pstmt.setString(2, student.getStudentSex());
        pstmt.setString(3, student.getStudentDept());
        pstmt.setString(4, student.getStudentBirth());
        pstmt.setString(5, student.getStudentId());
        return pstmt.executeUpdate();
    }
}
