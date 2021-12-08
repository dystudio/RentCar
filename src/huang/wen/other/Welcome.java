/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.other;

import huang.wen.manage.Administrator;
import huang.wen.manage.DBUtil;
import huang.wen.manage.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;


public class Welcome extends JFrame {
    public Welcome() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("configuration.ConfigurationFile");
        frame1 = new JFrame("登录");
        panel1 = new JPanel();
        splitPane3 = new JSplitPane();
        splitPane4 = new JSplitPane();
        label1 = new JLabel();
        label2 = new JLabel();
        splitPane5 = new JSplitPane();
        inputAccount = new JTextField();
        inputPassword = new JPasswordField();
        splitPane1 = new JSplitPane();
        checkBox1 = new JCheckBox();
        splitPane2 = new JSplitPane();
        loginButton = new JButton();
        registerButton = new JButton();
        title = new JLabel();
        splitPane6 = new JSplitPane();
        label3 = new JLabel();
        moreButton = new JButton();

        //======== frame1 ========
        {
            frame1.setMinimumSize(new Dimension(330, 240));
            frame1.setIconImage(new ImageIcon(getClass().getResource("/huang/wen/source/logo_white.png")).getImage());
            frame1.setResizable(false);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== splitPane3 ========
                {
                    splitPane3.setPreferredSize(new Dimension(78, 72));
                    splitPane3.setMinimumSize(new Dimension(80, 72));
                    splitPane3.setMaximumSize(new Dimension(80, 72));

                    //======== splitPane4 ========
                    {
                        splitPane4.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane4.setMinimumSize(new Dimension(29, 72));
                        splitPane4.setMaximumSize(new Dimension(29, 72));
                        splitPane4.setPreferredSize(new Dimension(29, 72));

                        //---- label1 ----
                        label1.setText(bundle.getString("Welcome.label1.text"));
                        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        label1.setMaximumSize(new Dimension(27, 36));
                        label1.setMinimumSize(new Dimension(27, 36));
                        label1.setInheritsPopupMenu(false);
                        label1.setPreferredSize(new Dimension(27, 36));
                        splitPane4.setTopComponent(label1);

                        //---- label2 ----
                        label2.setText(bundle.getString("Welcome.label2.text"));
                        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        label2.setMaximumSize(new Dimension(27, 36));
                        label2.setMinimumSize(new Dimension(27, 36));
                        label2.setInheritsPopupMenu(false);
                        label2.setPreferredSize(new Dimension(27, 36));
                        splitPane4.setBottomComponent(label2);
                    }
                    splitPane3.setLeftComponent(splitPane4);

                    //======== splitPane5 ========
                    {
                        splitPane5.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane5.setMaximumSize(new Dimension(51, 72));
                        splitPane5.setPreferredSize(new Dimension(49, 72));
                        splitPane5.setMinimumSize(new Dimension(51, 72));
                        splitPane5.setDividerLocation(40);

                        //---- inputAccount ----
                        inputAccount.setMaximumSize(new Dimension(49, 36));
                        inputAccount.setMinimumSize(new Dimension(49, 36));
                        inputAccount.setPreferredSize(new Dimension(49, 36));
                        inputAccount.setMargin(new Insets(2, 5, 2, 5));
                        splitPane5.setTopComponent(inputAccount);

                        //---- inputPassword ----
                        inputPassword.setMaximumSize(new Dimension(49, 36));
                        inputPassword.setMinimumSize(new Dimension(49, 36));
                        inputPassword.setPreferredSize(new Dimension(49, 36));
                        splitPane5.setBottomComponent(inputPassword);
                    }
                    splitPane3.setRightComponent(splitPane5);
                }
                panel1.add(splitPane3, BorderLayout.CENTER);

                //======== splitPane1 ========
                {

                    //---- checkBox1 ----
                    checkBox1.setText(bundle.getString("Welcome.checkBox1.text"));
                    checkBox1.setToolTipText("\u5982\u679c\u4f60\u662f\u8be5\u7cfb\u7edf\u7684\u7ba1\u7406\u5458\u8bf7\u52fe\u9009");
                    splitPane1.setLeftComponent(checkBox1);

                    //======== splitPane2 ========
                    {
                        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

                        //---- loginButton ----
                        loginButton.setText(bundle.getString("Welcome.loginButton.text"));
                        loginButton.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/login.png")));
                        loginButton.setMaximumSize(new Dimension(82, 20));
                        splitPane2.setTopComponent(loginButton);

                        //---- registerButton ----
                        registerButton.setText(bundle.getString("Welcome.registerButton.text"));
                        registerButton.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/register.png")));
                        splitPane2.setBottomComponent(registerButton);
                    }
                    splitPane1.setRightComponent(splitPane2);
                }
                panel1.add(splitPane1, BorderLayout.SOUTH);

                //---- title ----
                title.setText(bundle.getString("Welcome.title.text"));
                title.setHorizontalAlignment(SwingConstants.CENTER);
                title.setFont(new Font("\u534e\u6587\u6977\u4f53", Font.PLAIN, 18));
                panel1.add(title, BorderLayout.NORTH);
            }
            frame1ContentPane.add(panel1, BorderLayout.CENTER);

            //======== splitPane6 ========
            {

                //---- label3 ----
                label3.setText(bundle.getString("Welcome.label3.text"));
                splitPane6.setLeftComponent(label3);

                //---- moreButton ----
                moreButton.setText(bundle.getString("Welcome.moreButton.text"));
                moreButton.setMinimumSize(new Dimension(10, 30));
                moreButton.setMaximumSize(new Dimension(10, 30));
                moreButton.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/more.png")));
                splitPane6.setRightComponent(moreButton);
            }
            frame1ContentPane.add(splitPane6, BorderLayout.SOUTH);
            frame1.setSize(335, 235);
            frame1.setLocationRelativeTo(frame1.getOwner());
            frame1.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //登录
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 按钮点击时执行的事件
                String temp_account = inputAccount.getText();
                String temp_password = new String(inputPassword.getPassword());
                if (checkBox1.isSelected()) {
                    //管理员登录
                    String sql = "select * from administrator where account = ? and password = ?";
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    DBUtil mysqlTool = new DBUtil();
                    try {
                        conn = mysqlTool.getConnection();
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, temp_account);//给占位符？传递值
                        pstmt.setString(2, temp_password);
                        //执行查询语句
                        ResultSet res = pstmt.executeQuery();
                        if (res.next()) {//若查询结果有数据返回则登录成功
                            frame1.dispose();
                            Administrator administrator=new Administrator(temp_account);
                        } else {
                            JOptionPane.showConfirmDialog(frame1, "您输入的管理员账号或密码有误，请重新输入！\n（如果为普通用户登录，请不要勾选“管理员”选项）", "Administrator-登录失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }finally {
                        mysqlTool.close(pstmt);
                        mysqlTool.close(conn);    //必须关闭
                    }
                } else {
                    //用户登录
                    String sql = "select * from users where account = ? and password = ?";
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    DBUtil mysqlTool = new DBUtil();
                    try {
                        conn = mysqlTool.getConnection();
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, temp_account);//给占位符？传递值
                        pstmt.setString(2, temp_password);
                        //执行查询语句
                        ResultSet res = pstmt.executeQuery();
                        if (res.next()) {//若查询结果有数据返回则登录成功
                            frame1.dispose();
                            User user=new User(temp_account);
                        } else {
                            JOptionPane.showConfirmDialog(frame1, "您输入的账号或密码有误，请重新输入！\n（没有注册账号？点击下方按钮立即注册）", "User-登录失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        mysqlTool.close(pstmt);
                        mysqlTool.close(conn);    //必须关闭
                    }

                }
            }
        });
        //注册
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                Register register=new Register();
            }
        });
        //更多
        moreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(frame1, "This car rental system 4.0 was developed\nby HuangWen in November 2021\n有任何疑问或建议可联系：\nQQ：1415821217\nE-mail：quantumcloud@foxmail.com", "更多", JOptionPane.DEFAULT_OPTION);
            }
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JPanel panel1;
    private JSplitPane splitPane3;
    private JSplitPane splitPane4;
    private JLabel label1;
    private JLabel label2;
    private JSplitPane splitPane5;
    private JTextField inputAccount;
    private JPasswordField inputPassword;
    private JSplitPane splitPane1;
    private JCheckBox checkBox1;
    private JSplitPane splitPane2;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel title;
    private JSplitPane splitPane6;
    private JLabel label3;
    private JButton moreButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}