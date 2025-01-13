package com.xu.view.internal;

import com.xu.dao.StudentDao;
import com.xu.pojo.Student;
import com.xu.util.DbUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.List;

public class StudentManageInterFrm extends JFrame {
    public StudentManageInterFrm() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // 查询按钮事件处理
        Student student = new Student();
        student.setStudentId(StudentIdTxt.getText());
        student.setStudentName(StudentNameTxt.getText());
        student.setStudentDept(StudentDeptTxt.getText());
        try (Connection con = DbUtil.getCon()) {
            List<Student> studentList = StudentDao.query(con, student);
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            for (Student s : studentList) {
                model.addRow(new Object[]{s.getStudentId(), s.getStudentName(), s.getStudentSex(), s.getStudentDept(), s.getStudentBirth()});
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "查询失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        // 删除按钮事件处理
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的记录", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String studentId = (String) table1.getValueAt(selectedRow, 0);
        try (Connection con = DbUtil.getCon()) {
            int result = StudentDao.delete(con, studentId);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                button1(null); // 重新查询刷新表格
            } else {
                JOptionPane.showMessageDialog(this, "删除失败", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "删除失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateButtonActionPerformed(ActionEvent e) {
        // 修改按钮事件处理
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的记录", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // 获取选中的学生信息
        String studentId = (String) table1.getValueAt(selectedRow, 0);
        String studentName = (String) table1.getValueAt(selectedRow, 1);
        String studentSex = (String) table1.getValueAt(selectedRow, 2);
        String studentDept = (String) table1.getValueAt(selectedRow, 3);
        String studentBirth = (String) table1.getValueAt(selectedRow, 4);
        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setStudentSex(studentSex);
        student.setStudentDept(studentDept);
        student.setStudentBirth(studentBirth);
        try (Connection con = DbUtil.getCon()) {
            // 打印当前连接状态
            System.out.println("Database connection is auto-commit: " + con.getAutoCommit());
            int result = StudentDao.update(con, student);
            if (result > 0) {
                // 更新成功后重新查询刷新表格
                button1(null);
                JOptionPane.showMessageDialog(this, "修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "修改失败，未找到匹配记录", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "修改失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        StudentIdTxt = new JTextField();
        StudentNameTxt = new JTextField();
        Selectbutton = new JButton();
        StudentDeptTxt = new JTextField();
        table1 = new JTable();
        button1 = new JButton();
        deleteButton = new JButton();  // 初始化 deleteButton
        updateButton = new JButton();  // 初始化 updateButton

        //======== this ========
        setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u641c\u7d22\u6761\u4ef6"));
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u5b66\u53f7\uff1a");
            panel1.add(label1);
            label1.setBounds(15, 35, 60, 15);

            //---- label2 ----
            label2.setText("\u59d3\u540d\uff1a");
            panel1.add(label2);
            label2.setBounds(230, 35, 65, label2.getPreferredSize().height);

            //---- label3 ----
            label3.setText("\u9662\u7cfb\uff1a");
            panel1.add(label3);
            label3.setBounds(420, 35, 70, label3.getPreferredSize().height);
            panel1.add(StudentIdTxt);
            StudentIdTxt.setBounds(70, 30, 145, StudentIdTxt.getPreferredSize().height);
            panel1.add(StudentNameTxt);
            StudentNameTxt.setBounds(285, 30, 115, StudentNameTxt.getPreferredSize().height);

            //---- Selectbutton ----
            Selectbutton.setText("\u67e5\u8be2");
            Selectbutton.addActionListener(e -> button1(e));
            panel1.add(Selectbutton);
            Selectbutton.setBounds(625, 30, 85, Selectbutton.getPreferredSize().height);
            panel1.add(StudentDeptTxt);
            StudentDeptTxt.setBounds(470, 30, 115, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(15, 5, 735, 75);

        contentPane.add(table1);
        table1.setBounds(25, 120, 720, 145);

        //---- deleteButton ----
        deleteButton.setText("\u5220\u9664");
        deleteButton.addActionListener(e -> deleteButtonActionPerformed(e));
        contentPane.add(deleteButton);
        deleteButton.setBounds(625, 280, 85, 30);  // 设置位置

        //---- updateButton ----
        updateButton.setText("\u4fee\u6539");
        updateButton.addActionListener(e -> updateButtonActionPerformed(e));
        contentPane.add(updateButton);
        updateButton.setBounds(530, 280, 85, 30);  // 设置位置

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(770, 490);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // 设置表格模型
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {"学号", "姓名", "性别", "系别", "出生日期"}
        ));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField StudentIdTxt;
    private JTextField StudentNameTxt;
    private JButton Selectbutton;
    private JTextField StudentDeptTxt;
    private JTable table1;
    private JButton button1;
    private JButton deleteButton;  // 添加这一行
    private JButton updateButton;  // 添加这一行
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
