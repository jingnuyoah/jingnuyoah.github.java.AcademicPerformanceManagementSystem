package com.xu.view.internal;

import com.xu.dao.ScDao;
import com.xu.dao.StudentDao;
import com.xu.pojo.Sc;
import com.xu.util.DbUtil;
import com.xu.util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;

/**
 * @author 许耀心
 */
public class ScAddInterFrm extends JFrame {
    public ScAddInterFrm() {
        initComponents();
    }

    private void scAddHandler(ActionEvent e) {
        scAddActionPerformed(e);
    }

    private void scAddActionPerformed(ActionEvent evt) {
        String studentId = this.StudentIdTxt.getText();
        String courseId = this.CourseIdTxt.getText();
        String grade = this.GradeTxt.getText();
        if (StringUtil.isEmpty(studentId)) {
            JOptionPane.showMessageDialog(null, "学号不能为空");
            return;
        }
        if (StringUtil.isEmpty(courseId)) {
            JOptionPane.showMessageDialog(null, "课程号不能为空");
            return;
        }
        Sc sc = new Sc(studentId, courseId,Integer.parseInt(grade));
        Connection con = null;
        try {
            con = DbUtil.getCon();
            int addNum = ScDao.add(con,sc);
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "选课信息添加成功！");
            } else {
                JOptionPane.showMessageDialog(null, "选课信息添加失败");
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
        label2 = new JLabel();
        label3 = new JLabel();
        StudentIdTxt = new JTextField();
        CourseIdTxt = new JTextField();
        GradeTxt = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u9009\u8bfe\u4fe1\u606f\u6dfb\u52a0");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(40, 40, 60, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u8bfe\u7a0b\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(40, 90, 55, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6210\u7ee9\uff1a");
        contentPane.add(label3);
        label3.setBounds(40, 145, 50, label3.getPreferredSize().height);
        contentPane.add(StudentIdTxt);
        StudentIdTxt.setBounds(125, 35, 120, StudentIdTxt.getPreferredSize().height);
        contentPane.add(CourseIdTxt);
        CourseIdTxt.setBounds(125, 85, 120, CourseIdTxt.getPreferredSize().height);
        contentPane.add(GradeTxt);
        GradeTxt.setBounds(125, 135, 120, GradeTxt.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> scAddHandler(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(115, 205), button1.getPreferredSize()));

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
        setSize(315, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField StudentIdTxt;
    private JTextField CourseIdTxt;
    private JTextField GradeTxt;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}