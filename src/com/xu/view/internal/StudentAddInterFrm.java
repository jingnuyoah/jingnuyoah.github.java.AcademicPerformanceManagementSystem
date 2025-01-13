/*
 * Created by JFormDesigner on Fri Dec 20 20:24:54 GMT+08:00 2024
 */

package com.xu.view.internal;

import com.xu.dao.StudentDao;
import com.xu.pojo.Student;
import com.xu.util.DbUtil;
import com.xu.util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;

/**
 * @author 许耀心
 */
public class StudentAddInterFrm extends JFrame {
    public StudentAddInterFrm() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }

    private void addHandler(ActionEvent e) {
        studentAddActionPerformed(e);
    }

    private void studentAddActionPerformed(ActionEvent evt) {
        String studentId = this.StudentIdText.getText();
        String studentName = this.StudentNameText.getText();
        String studentSex = this.StudentSexText.getText();
        String studentDept = this.StudentDeptText.getText();
        String studentBirth = this.StudentBirthText.getText();
        if (StringUtil.isEmpty(studentId)) {
            JOptionPane.showMessageDialog(null, "学号不能为空");
            return;
        }

        Student student = new Student(studentId, studentName, studentSex, studentDept,studentBirth);
        Connection con = null;
        try {
            con = DbUtil.getCon();
            int addNum = StudentDao.add(con,student);
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "学生信息添加成功！");
            } else {
                JOptionPane.showMessageDialog(null, "学生信息添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "学生信息添加失败");
        } finally {
            try {
                DbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
        label1 = new JLabel();
        StudentIdText = new JTextField();
        label2 = new JLabel();
        StudentNameText = new JTextField();
        StudentSexText = new JTextField();
        StudentDeptText = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        StudentBirthText = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u4fe1\u606f\u6dfb\u52a0");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(40, 25, 65, label1.getPreferredSize().height);
        contentPane.add(StudentIdText);
        StudentIdText.setBounds(110, 20, 145, StudentIdText.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(40, 70, 60, label2.getPreferredSize().height);
        contentPane.add(StudentNameText);
        StudentNameText.setBounds(110, 65, 145, 30);
        contentPane.add(StudentSexText);
        StudentSexText.setBounds(115, 110, 140, 30);
        contentPane.add(StudentDeptText);
        StudentDeptText.setBounds(115, 155, 140, 30);

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        contentPane.add(label3);
        label3.setBounds(40, 115, 65, 17);

        //---- label4 ----
        label4.setText("\u9662\u7cfb\uff1a");
        contentPane.add(label4);
        label4.setBounds(45, 160, 60, 17);

        //---- label5 ----
        label5.setText("\u751f\u65e5\uff1a");
        contentPane.add(label5);
        label5.setBounds(45, 210, 50, label5.getPreferredSize().height);
        contentPane.add(StudentBirthText);
        StudentBirthText.setBounds(115, 205, 140, 30);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> addHandler(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(140, 250), button1.getPreferredSize()));

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
        setSize(330, 330);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
    private JLabel label1;
    private JTextField StudentIdText;
    private JLabel label2;
    private JTextField StudentNameText;
    private JTextField StudentSexText;
    private JTextField StudentDeptText;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField StudentBirthText;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
