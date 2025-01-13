/*
 * Created by JFormDesigner on Fri Dec 20 15:30:08 GMT+08:00 2024
 */

package com.xu.view.main;

import com.xu.view.internal.ScAddInterFrm;
import com.xu.view.internal.StudentAddInterFrm;
import com.xu.view.internal.StudentManageInterFrm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 许耀心
 */
public class MainFrm extends JFrame {
    public MainFrm() {
        initComponents();
    }

    private void studentAddHandler(ActionEvent e) {
        studentAddActionPerformed(e);
    }

    private void studentAddActionPerformed(ActionEvent e) {
        StudentAddInterFrm studentAddInterFrm = new StudentAddInterFrm();
        studentAddInterFrm.setVisible(true);
    }

    private void scAddHandler(ActionEvent e) {
        scAddActionPerformed(e);
    }

    private void scAddActionPerformed(ActionEvent e){
        ScAddInterFrm scAddInterFrm = new ScAddInterFrm();
        scAddInterFrm.setVisible(true);
    }

    private void StudentManagementHandler(ActionEvent e) {
        StudentManageInterFrm studentManageInterFrm = new StudentManageInterFrm();
        studentManageInterFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem4 = new JMenuItem();

        //======== this ========
        setTitle("\u9ad8\u6821\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf\u4e3b\u754c\u9762");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u5b66\u751f\u57fa\u672c\u4fe1\u606f\u7ba1\u7406");

                //---- menuItem1 ----
                menuItem1.setText("\u5b66\u751f\u57fa\u672c\u4fe1\u606f\u7ef4\u62a4");
                menuItem1.addActionListener(e -> StudentManagementHandler(e));
                menu1.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("\u5b66\u751f\u57fa\u672c\u4fe1\u606f\u6dfb\u52a0");
                menuItem3.addActionListener(e -> studentAddHandler(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u9009\u8bfe\u7ba1\u7406");

                //---- menuItem2 ----
                menuItem2.setText("\u9009\u8bfe\u7ef4\u62a4");
                menu2.add(menuItem2);

                //---- menuItem4 ----
                menuItem4.setText("\u9009\u8bfe\u6dfb\u52a0");
                menuItem4.addActionListener(e -> scAddHandler(e));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

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
        setSize(465, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Open Source Project license - 淘宝星河飘雪
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem2;
    private JMenuItem menuItem4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
