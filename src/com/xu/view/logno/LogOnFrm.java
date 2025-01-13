/*
package com.xu.view.logno;

import com.xu.dao.UserDao;
import com.xu.pojo.User;
import com.xu.util.DbUtil;
import com.xu.util.StringUtil;
import com.xu.view.main.MainFrm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class LogOnFrm extends JFrame {

    public LogOnFrm() {
        // 初始化组件
        initComponents();

        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口可见性
        setVisible(true);
    }

    private void loginHandler(ActionEvent e) {
        loginActionPerform(e);
    }

    private void loginActionPerform(ActionEvent evt) {
        String userName = this.userNameTxt.getText();
        String userPassword = new String(this.passwordTxt.getText());
        Integer locked = 0;
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！");
            return;
        }
        if (StringUtil.isEmpty(userPassword)) {
            JOptionPane.showMessageDialog(null, "密码不能为空！");
            return;
        }
        User user = new User(userName, userPassword, locked);
        Connection con = null;
        try {
            con = DbUtil.getCon();
            User currentUser = UserDao.login(con, user);
            if (currentUser != null) {
                dispose(); // 登录成功销毁当前窗体
                new MainFrm().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtil.closeCon(con);
            } catch (SQLException e) {
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
        userNameTxt = new JTextField();
        passwordTxt = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("登录界面");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("高校成绩管理系统");
        label1.setFont(new Font("宋体", Font.PLAIN, 22));
        contentPane.add(label1);
        label1.setBounds(120, 25, 180, 35);

        //---- label2 ----
        label2.setText("用户名：");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 85), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("密码：");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(65, 135), label3.getPreferredSize()));
        contentPane.add(userNameTxt);
        userNameTxt.setBounds(125, 80, 185, userNameTxt.getPreferredSize().height);
        contentPane.add(passwordTxt);
        passwordTxt.setBounds(125, 130, 185, passwordTxt.getPreferredSize().height);

        //---- button1 ----
        button1.setText("登录");
        button1.addActionListener(e -> loginHandler(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 200), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(240, 200), button2.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
        setSize(405, 310);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userNameTxt;
    private JTextField passwordTxt;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

*/

package com.xu.view.logno;

import com.xu.dao.UserDao;
import com.xu.pojo.User;
import com.xu.util.DbUtil;
import com.xu.util.StringUtil;
import com.xu.view.main.MainFrm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class LogOnFrm extends JFrame {

    public LogOnFrm() {
        // 初始化组件
        initComponents();

        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口可见性
        setVisible(true);
    }

    private void loginHandler(ActionEvent e) {
        loginActionPerform(e);
    }

    private void loginActionPerform(ActionEvent evt) {
        String userName = this.userNameTxt.getText();
        String userPassword = new String(this.passwordTxt.getPassword());
        Integer locked = 0;
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "登录失败", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (StringUtil.isEmpty(userPassword)) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "登录失败", JOptionPane.ERROR_MESSAGE);
            return;
        }
        User user = new User(userName, userPassword, locked);
        Connection con = null;
        try {
            con = DbUtil.getCon();
            User currentUser = UserDao.login(con, user);
            if (currentUser != null) {
                dispose(); // 登录成功销毁当前窗体
                new MainFrm().setVisible(true);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "登录失败", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                DbUtil.closeCon(con);
            } catch (SQLException e) {
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
        userNameTxt = new JTextField();
        passwordTxt = new JPasswordField(); // 使用 JPasswordField 而不是 JTextField
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("登录界面");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("高校成绩管理系统");
        label1.setFont(new Font("宋体", Font.PLAIN, 22));
        contentPane.add(label1);
        label1.setBounds(120, 25, 180, 35);

        //---- label2 ----
        label2.setText("用户名：");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 85), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("密码：");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(65, 135), label3.getPreferredSize()));
        contentPane.add(userNameTxt);
        userNameTxt.setBounds(125, 80, 185, userNameTxt.getPreferredSize().height);
        contentPane.add(passwordTxt);
        passwordTxt.setBounds(125, 130, 185, passwordTxt.getPreferredSize().height);

        //---- button1 ----
        button1.setText("登录");
        button1.addActionListener(e -> loginHandler(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 200), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(240, 200), button2.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
        setSize(405, 310);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt; // 使用 JPasswordField 而不是 JTextField
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}


