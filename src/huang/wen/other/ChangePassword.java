/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.other;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;

public class ChangePassword {
    String user_account;
    Connection conn;
    public ChangePassword(Connection conn ,String account) {
        initComponents();
        this.conn=conn;
        this.user_account=account;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("configuration.ConfigurationFile");
        ChangePassword = new JFrame();
        panel1 = new JPanel();
        splitPane7 = new JSplitPane();
        splitPane8 = new JSplitPane();
        splitPane9 = new JSplitPane();
        label3 = new JLabel();
        passwordField3 = new JPasswordField();
        splitPane1 = new JSplitPane();
        label1 = new JLabel();
        passwordField1 = new JPasswordField();
        splitPane2 = new JSplitPane();
        splitPane3 = new JSplitPane();
        label2 = new JLabel();
        passwordField2 = new JPasswordField();
        splitPane4 = new JSplitPane();
        button1 = new JButton();
        button2 = new JButton();

        //======== ChangePassword ========
        {
            ChangePassword.setMinimumSize(new Dimension(310, 150));
            ChangePassword.setResizable(false);
            ChangePassword.setVisible(true);
            ChangePassword.setIconImage(new ImageIcon(getClass().getResource("/huang/wen/source/change_password.png")).getImage());
            var ChangePasswordContentPane = ChangePassword.getContentPane();
            ChangePasswordContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== splitPane7 ========
                {
                    splitPane7.setOrientation(JSplitPane.VERTICAL_SPLIT);

                    //======== splitPane8 ========
                    {
                        splitPane8.setOrientation(JSplitPane.VERTICAL_SPLIT);

                        //======== splitPane9 ========
                        {

                            //---- label3 ----
                            label3.setText(bundle.getString("ChangePassword.label3.text"));
                            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                            splitPane9.setLeftComponent(label3);

                            //---- passwordField3 ----
                            passwordField3.setMinimumSize(new Dimension(49, 80));
                            splitPane9.setRightComponent(passwordField3);
                        }
                        splitPane8.setTopComponent(splitPane9);

                        //======== splitPane1 ========
                        {

                            //---- label1 ----
                            label1.setText(bundle.getString("ChangePassword.label1.text"));
                            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                            splitPane1.setLeftComponent(label1);
                            splitPane1.setRightComponent(passwordField1);
                        }
                        splitPane8.setBottomComponent(splitPane1);
                    }
                    splitPane7.setTopComponent(splitPane8);

                    //======== splitPane2 ========
                    {
                        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

                        //======== splitPane3 ========
                        {

                            //---- label2 ----
                            label2.setText(bundle.getString("ChangePassword.label2.text"));
                            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                            splitPane3.setLeftComponent(label2);
                            splitPane3.setRightComponent(passwordField2);
                        }
                        splitPane2.setTopComponent(splitPane3);

                        //======== splitPane4 ========
                        {

                            //---- button1 ----
                            button1.setText(bundle.getString("ChangePassword.button1.text"));
                            button1.setMaximumSize(new Dimension(150, 30));
                            button1.setMinimumSize(new Dimension(150, 30));
                            button1.setPreferredSize(new Dimension(150, 30));
                            button1.setFont(new Font("\u96b6\u4e66", Font.PLAIN, 18));
                            splitPane4.setLeftComponent(button1);

                            //---- button2 ----
                            button2.setText(bundle.getString("ChangePassword.button2.text"));
                            button2.setPreferredSize(new Dimension(150, 30));
                            button2.setMaximumSize(new Dimension(150, 30));
                            button2.setMinimumSize(new Dimension(150, 30));
                            button2.setFont(new Font("\u96b6\u4e66", Font.PLAIN, 18));
                            splitPane4.setRightComponent(button2);
                        }
                        splitPane2.setBottomComponent(splitPane4);
                    }
                    splitPane7.setBottomComponent(splitPane2);
                }
                panel1.add(splitPane7, BorderLayout.CENTER);
            }
            ChangePasswordContentPane.add(panel1, BorderLayout.CENTER);
            ChangePassword.pack();
            ChangePassword.setLocationRelativeTo(ChangePassword.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //确认修改
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String old_password=null;
                String old_password_input = new String(passwordField3.getPassword());
                String new_passsword = new String(passwordField1.getPassword());
                String again_new_password = new String(passwordField2.getPassword());
                PreparedStatement pstmt = null;
                try {
                    pstmt = conn.prepareStatement("select * from users where account = ?");
                    pstmt.setString(1, user_account);
                    ResultSet res = pstmt.executeQuery();
                    while (res.next()) {
                        old_password = res.getString("password");
                    }
                    if(old_password.equals(old_password_input)){
                        if(new_passsword.equals(again_new_password)){
                            String sql_update = "update users set password =? where account=?";
                            pstmt = conn.prepareStatement(sql_update);
                            pstmt.setString(1, new_passsword);
                            pstmt.setString(2, user_account);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(ChangePassword, "密码修改成功！", "修改成功", JOptionPane.INFORMATION_MESSAGE);
                            ChangePassword.dispose();
                        }else{
                            JOptionPane.showMessageDialog(ChangePassword, "两次输入的密码不一致\n请重新输入！", "密码修改失败", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(ChangePassword, "旧密码输入有误\n请重新输入！", "密码修改失败", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        //取消修改
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePassword.dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame ChangePassword;
    private JPanel panel1;
    private JSplitPane splitPane7;
    private JSplitPane splitPane8;
    private JSplitPane splitPane9;
    private JLabel label3;
    private JPasswordField passwordField3;
    private JSplitPane splitPane1;
    private JLabel label1;
    private JPasswordField passwordField1;
    private JSplitPane splitPane2;
    private JSplitPane splitPane3;
    private JLabel label2;
    private JPasswordField passwordField2;
    private JSplitPane splitPane4;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
