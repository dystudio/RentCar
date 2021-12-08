/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.other;

import huang.wen.manage.DBUtil;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class Register extends JFrame {
    public Register() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("configuration.ConfigurationFile");
        returnButton = new JButton();
        panel1 = new JPanel();
        splitPane4 = new JSplitPane();
        splitPane5 = new JSplitPane();
        label7 = new JLabel();
        textField2 = new JTextField();
        splitPane6 = new JSplitPane();
        checkBox1 = new JCheckBox();
        registerButton = new JButton();
        splitPane1 = new JSplitPane();
        splitPane2 = new JSplitPane();
        label4 = new JLabel();
        label5 = new JLabel();
        splitPane3 = new JSplitPane();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        label6 = new JLabel();

         splitPane7=new JSplitPane();
         splitPane8=new JSplitPane();
         label8=new JLabel();
         textField3=new JTextField();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/huang/wen/source/register_logo.png")).getImage());
        setMinimumSize(new Dimension(260, 192));
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- returnButton ----
        returnButton.setText(bundle.getString("Register.returnButton.text"));
        returnButton.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/return.png")));
        contentPane.add(splitPane7, BorderLayout.SOUTH);

        splitPane7.setLeftComponent(splitPane8);
        splitPane7.setRightComponent(returnButton);
        label8.setText("性别：");
        splitPane8.setLeftComponent(label8);
        splitPane8.setRightComponent(textField3);
        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //======== splitPane4 ========
            {

                //======== splitPane5 ========
                {

                    //---- label7 ----
                    label7.setText(bundle.getString("Register.label7.text"));
                    splitPane5.setLeftComponent(label7);
                    splitPane5.setRightComponent(textField2);
                }
                splitPane4.setLeftComponent(splitPane5);

                //======== splitPane6 ========
                {

                    //---- radioButton1 ----
                    checkBox1.setText(bundle.getString("Register.checkBox1.text"));
                    checkBox1.setToolTipText("\u5982\u679c\u60a8\u9700\u8981\u6ce8\u518c\u7ba1\u7406\u5458\u8d26\u53f7\uff0c\u8bf7\u52fe\u9009\u6b64\u9009\u9879");
                    splitPane6.setLeftComponent(checkBox1);

                    //---- registerButton ----
                    registerButton.setText(bundle.getString("Register.registerButton.text"));
                    registerButton.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/sign_up_now.png")));
                    splitPane6.setRightComponent(registerButton);
                }
                splitPane4.setRightComponent(splitPane6);
            }
            panel1.add(splitPane4, BorderLayout.SOUTH);

            //======== splitPane1 ========
            {

                //======== splitPane2 ========
                {
                    splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

                    //---- label4 ----
                    label4.setText(bundle.getString("Register.label4.text"));
                    label4.setPreferredSize(new Dimension(24, 30));
                    label4.setMinimumSize(new Dimension(24, 30));
                    label4.setMaximumSize(new Dimension(24, 30));
                    splitPane2.setTopComponent(label4);

                    //---- label5 ----
                    label5.setText(bundle.getString("Register.label5.text"));
                    label5.setMaximumSize(new Dimension(24, 30));
                    label5.setMinimumSize(new Dimension(24, 30));
                    label5.setPreferredSize(new Dimension(24, 30));
                    splitPane2.setBottomComponent(label5);
                }
                splitPane1.setLeftComponent(splitPane2);

                //======== splitPane3 ========
                {
                    splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);

                    //---- textField1 ----
                    textField1.setMaximumSize(new Dimension(49, 30));
                    splitPane3.setTopComponent(textField1);

                    //---- passwordField1 ----
                    passwordField1.setMaximumSize(new Dimension(49, 30));
                    splitPane3.setBottomComponent(passwordField1);
                    splitPane3.setDividerLocation(35);
                }
                splitPane1.setRightComponent(splitPane3);
            }
            panel1.add(splitPane1, BorderLayout.CENTER);

            //---- label6 ----
            label6.setText(bundle.getString("Register.label6.text"));
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            panel1.add(label6, BorderLayout.NORTH);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //返回上一级
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Welcome();
            }
        });
        //注册
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _account = textField1.getText();
                String _password = new String(passwordField1.getPassword());
                String _name = textField2.getText();
                String _gender = textField3.getText();
                if (_gender.equals("男") || _gender.equals("女")) {
                    if (_account.equals("") || _password.equals("") || _name.equals("")) {
                        JOptionPane.showConfirmDialog(panel1, "请输入完整的信息！", "User-注册失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (checkBox1.isSelected()) {
                            //注册管理员账号
                            int verify = 0;
                            String str = JOptionPane.showInputDialog(panel1, "请输入授权码进行验证\n然后进行下一步操作", "请先验证", JOptionPane.PLAIN_MESSAGE);
                            if(str instanceof String) {
                                String sql_1 = "select * from other_data where super_password = ?";
                                Connection conn = null;
                                PreparedStatement pstmt = null;
                                DBUtil mysqlTool = new DBUtil();
                                try {
                                    conn = mysqlTool.getConnection();
                                    pstmt = conn.prepareStatement(sql_1);
                                    pstmt.setString(1, str);//给占位符？传递值
                                    //执行查询语句
                                    ResultSet res = pstmt.executeQuery();
                                    if (res.next()) {//若查询结果有数据返回则登录成功
                                        verify = 1;
                                    } else {
                                        JOptionPane.showConfirmDialog(panel1, "很抱歉，您未能通过验证！", "验证失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                } finally {
                                    mysqlTool.close(pstmt);
                                    mysqlTool.close(conn);    //必须关闭
                                }

                                if (verify == 1) {
                                    String sql_2 = "insert into administrator(name,gender,account,password) values(?,?,?,?)";
                                    conn = null;
                                    pstmt = null;

                                    try {
                                        conn = mysqlTool.getConnection();
                                        pstmt = conn.prepareStatement(sql_2);
                                        pstmt.setString(1, _name);
                                        pstmt.setString(2, _gender);
                                        pstmt.setString(3, _account);
                                        pstmt.setString(4, _password);
                                        pstmt.executeUpdate();            //执行
                                        JOptionPane.showConfirmDialog(panel1, "账号已成功注册！", "Administrator-注册成功", JOptionPane.DEFAULT_OPTION, INFORMATION_MESSAGE);
                                        dispose();
                                        new Welcome();
                                    } catch (SQLException ex) {
                                        JOptionPane.showConfirmDialog(panel1, "该管理员账号已存在\n请重新输入其他账号", "Administrator-注册失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                    } finally {
                                        mysqlTool.close(pstmt);
                                        mysqlTool.close(conn);    //必须关闭
                                    }
                                }
                            }
                        } else {
                            //注册普通用户账号
                            String sql = "insert into users(name,gender, account,password,is_rent,balance) values(?,?,?,?,?,?)";
                            Connection conn = null;
                            PreparedStatement pstmt = null;
                            DBUtil mysqlTool = new DBUtil();
                            try {
                                conn = mysqlTool.getConnection();
                                pstmt = conn.prepareStatement(sql);
                                pstmt.setString(1, _name);
                                pstmt.setString(2, _gender);
                                pstmt.setString(3, _account);
                                pstmt.setString(4, _password);
                                pstmt.setString(5, "0");
                                pstmt.setFloat(6, 0);
                                pstmt.executeUpdate();            //执行
                                JOptionPane.showConfirmDialog(panel1, "账号已成功注册！", "User-注册成功", JOptionPane.DEFAULT_OPTION, INFORMATION_MESSAGE);
                                dispose();
                                new Welcome();
                            } catch (SQLException ex) {
                                JOptionPane.showConfirmDialog(panel1, "该用户账号已存在\n请重新输入其他账号", "User-注册失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                            } finally {
                                mysqlTool.close(pstmt);
                                mysqlTool.close(conn);    //必须关闭
                            }
                        }
                    }
                }else{
                    JOptionPane.showConfirmDialog(panel1, "性别只能填“男”、“女”、“保密”", "User-注册失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton returnButton;
    private JPanel panel1;
    private JSplitPane splitPane4;
    private JSplitPane splitPane5;
    private JLabel label7;
    private JTextField textField2;
    private JSplitPane splitPane6;
    private JCheckBox checkBox1;;
    private JButton registerButton;
    private JSplitPane splitPane1;
    private JSplitPane splitPane2;
    private JLabel label4;
    private JLabel label5;
    private JSplitPane splitPane3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label6;

    private JSplitPane splitPane7;
    private JSplitPane splitPane8;
    private JLabel label8;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
