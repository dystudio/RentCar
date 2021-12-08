/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.manage;

import huang.wen.cars.Bus;
import huang.wen.cars.Car;
import huang.wen.cars.Truck;
import huang.wen.other.ChangePassword;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static java.lang.System.exit;


public class User {

    String name_user = null;
    String gender_user = null;
    String account_user = null;
    float balance_user = 0;
    String is_rent_user = null;
    float turnover=0; //营业额
    //连接数据库
    DBUtil mysqlTool = new DBUtil();
    Connection conn = mysqlTool.getConnection();

    public User(String account) throws SQLException {
        this.account_user=account;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("configuration.ConfigurationFile");
        Jframe_user = new JFrame("汽车租赁系统");
        label1 = new JLabel();
        panel1 = new JPanel();
        menu = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        car = new JTable();
        scrollPane3 = new JScrollPane();
        bus = new JTable();
        scrollPane4 = new JScrollPane();
        truck = new JTable();
        scrollPane5 = new JScrollPane();
        panel2 = new JPanel();
        label3 = new JLabel();
        splitPane3 = new JSplitPane();
        splitPane2 = new JSplitPane();
        splitPane6 = new JSplitPane();
        label_greetings = new JLabel();
        label5 = new JLabel();
        splitPane13 = new JSplitPane();
        label_name = new JLabel();
        splitPane14 = new JSplitPane();
        label_gender = new JLabel();
        splitPane15 = new JSplitPane();
        label_account = new JLabel();
        splitPane16 = new JSplitPane();
        label_accountBalance = new JLabel();
        vSpacer1 = new JPanel(null);
        splitPane4 = new JSplitPane();
        splitPane5 = new JSplitPane();
        Button_rentCar = new JButton();
        Button_returnVehicle = new JButton();
        splitPane1 = new JSplitPane();
        Button_viewAllVehicles = new JButton();
        splitPane7 = new JSplitPane();
        Button_viewAvailableVehicles = new JButton();
        splitPane8 = new JSplitPane();
        Button_rentalSituation = new JButton();
        splitPane9 = new JSplitPane();
        label4 = new JLabel();
        splitPane10 = new JSplitPane();
        Button_accountRecharge = new JButton();
        splitPane11 = new JSplitPane();
        Button_changePassword = new JButton();
        splitPane12 = new JSplitPane();
        Button_signOut = new JButton();
        splitPane17 = new JSplitPane();
        button1 = new JButton();
        label2 = new JLabel();

        //======== Jframe_user ========
        {
            Jframe_user.setVisible(true);
            Jframe_user.setMinimumSize(new Dimension(930, 620));
            Jframe_user.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            Jframe_user.setResizable(false);
            Jframe_user.setIconImage(new ImageIcon(getClass().getResource("/huang/wen/source/logo_white.png")).getImage());
            var Jframe_userContentPane = Jframe_user.getContentPane();
            Jframe_userContentPane.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText(bundle.getString("User.label1.text"));
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setMaximumSize(new Dimension(234, 30));
            label1.setMinimumSize(new Dimension(234, 30));
            label1.setPreferredSize(new Dimension(234, 30));
            label1.setFont(new Font("\u6977\u4f53", Font.PLAIN, 25));
            Jframe_userContentPane.add(label1, BorderLayout.PAGE_START);

            //======== panel1 ========
            {
                panel1.setMaximumSize(new Dimension(630, 620));
                panel1.setMinimumSize(new Dimension(630, 620));
                panel1.setPreferredSize(new Dimension(630, 620));
                panel1.setLayout(new BorderLayout());

                //======== menu ========
                {
                    menu.setMinimumSize(new Dimension(630, 620));
                    menu.setPreferredSize(new Dimension(630, 620));
                    menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //======== scrollPane1 ========
                    {

                        //---- car ----
                        car.setMinimumSize(new Dimension(30, 620));
                        car.setMaximumSize(new Dimension(2147483647, 620));
                        car.setPreferredSize(new Dimension(150, 620));
                        car.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        car.setFillsViewportHeight(true);
                        scrollPane1.setViewportView(car);
                    }
                    menu.addTab("\u8f7f\u8f66", scrollPane1);

                    //======== scrollPane3 ========
                    {

                        //---- bus ----
                        bus.setPreferredSize(new Dimension(150, 620));
                        scrollPane3.setViewportView(bus);
                    }
                    menu.addTab("\u5ba2\u8f66", scrollPane3);

                    //======== scrollPane4 ========
                    {

                        //---- truck ----
                        truck.setPreferredSize(new Dimension(150, 620));
                        scrollPane4.setViewportView(truck);
                    }
                    menu.addTab("\u8d27\u8f66", scrollPane4);
                }
                panel1.add(menu, BorderLayout.NORTH);
            }
            Jframe_userContentPane.add(panel1, BorderLayout.LINE_END);

            //======== scrollPane5 ========
            {
                scrollPane5.setPreferredSize(new Dimension(250, 199));

                //======== panel2 ========
                {
                    panel2.setLayout(new BorderLayout());

                    //---- label3 ----
                    label3.setText(bundle.getString("User.label3.text"));
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    label3.setMaximumSize(new Dimension(24, 30));
                    label3.setPreferredSize(new Dimension(24, 30));
                    label3.setMinimumSize(new Dimension(24, 30));
                    label3.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
                    panel2.add(label3, BorderLayout.PAGE_START);

                    //======== splitPane3 ========
                    {

                        //======== splitPane2 ========
                        {
                            splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

                            //======== splitPane6 ========
                            {
                                splitPane6.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                //---- label_greetings ----
                                label_greetings.setText(bundle.getString("User.label_greetings.text"));
                                label_greetings.setMaximumSize(new Dimension(72, 30));
                                label_greetings.setMinimumSize(new Dimension(72, 30));
                                label_greetings.setPreferredSize(new Dimension(72, 30));
                                label_greetings.setFont(new Font("\u65b9\u6b63\u59da\u4f53", Font.PLAIN, 16));
                                splitPane6.setTopComponent(label_greetings);

                                //---- label5 ----
                                label5.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Female user.png")));
                                splitPane6.setBottomComponent(label5);
                            }
                            splitPane2.setTopComponent(splitPane6);

                            //======== splitPane13 ========
                            {
                                splitPane13.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                //---- label_name ----
                                label_name.setText(bundle.getString("User.label_name.text"));
                                label_name.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                                label_name.setMaximumSize(new Dimension(41, 30));
                                label_name.setMinimumSize(new Dimension(41, 30));
                                label_name.setPreferredSize(new Dimension(41, 30));
                                splitPane13.setTopComponent(label_name);

                                //======== splitPane14 ========
                                {
                                    splitPane14.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                    //---- label_gender ----
                                    label_gender.setText(bundle.getString("User.label_gender.text"));
                                    label_gender.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                                    label_gender.setMaximumSize(new Dimension(41, 30));
                                    label_gender.setMinimumSize(new Dimension(41, 30));
                                    label_gender.setPreferredSize(new Dimension(41, 30));
                                    splitPane14.setTopComponent(label_gender);

                                    //======== splitPane15 ========
                                    {
                                        splitPane15.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                        //---- label_account ----
                                        label_account.setText(bundle.getString("User.label_account.text"));
                                        label_account.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                                        label_account.setMaximumSize(new Dimension(41, 30));
                                        label_account.setMinimumSize(new Dimension(41, 30));
                                        label_account.setPreferredSize(new Dimension(41, 30));
                                        splitPane15.setTopComponent(label_account);

                                        //======== splitPane16 ========
                                        {
                                            splitPane16.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                            //---- label_accountBalance ----
                                            label_accountBalance.setText(bundle.getString("User.label_accountBalance.text"));
                                            label_accountBalance.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
                                            label_accountBalance.setPreferredSize(new Dimension(68, 30));
                                            label_accountBalance.setMinimumSize(new Dimension(68, 30));
                                            label_accountBalance.setMaximumSize(new Dimension(68, 30));
                                            splitPane16.setTopComponent(label_accountBalance);
                                            splitPane16.setBottomComponent(vSpacer1);
                                        }
                                        splitPane15.setBottomComponent(splitPane16);
                                    }
                                    splitPane14.setBottomComponent(splitPane15);
                                }
                                splitPane13.setBottomComponent(splitPane14);
                            }
                            splitPane2.setBottomComponent(splitPane13);
                        }
                        splitPane3.setLeftComponent(splitPane2);

                        //======== splitPane4 ========
                        {
                            splitPane4.setOrientation(JSplitPane.VERTICAL_SPLIT);

                            //======== splitPane5 ========
                            {
                                splitPane5.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                //---- Button_rentCar ----
                                Button_rentCar.setText(bundle.getString("User.Button_rentCar.text"));
                                Button_rentCar.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Hire.png")));
                                Button_rentCar.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                                Button_rentCar.setMaximumSize(new Dimension(151, 36));
                                Button_rentCar.setMinimumSize(new Dimension(151, 36));
                                Button_rentCar.setPreferredSize(new Dimension(151, 36));
                                Button_rentCar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                splitPane5.setTopComponent(Button_rentCar);

                                //---- Button_returnVehicle ----
                                Button_returnVehicle.setText(bundle.getString("User.Button_returnVehicle.text"));
                                Button_returnVehicle.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Return the vehicle.png")));
                                Button_returnVehicle.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                                Button_returnVehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                splitPane5.setBottomComponent(Button_returnVehicle);
                            }
                            splitPane4.setTopComponent(splitPane5);

                            //======== splitPane1 ========
                            {
                                splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                //---- Button_viewAllVehicles ----
                                Button_viewAllVehicles.setText(bundle.getString("User.Button_viewAllVehicles.text"));
                                Button_viewAllVehicles.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/find all vehicles.png")));
                                Button_viewAllVehicles.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                                Button_viewAllVehicles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                splitPane1.setTopComponent(Button_viewAllVehicles);

                                //======== splitPane7 ========
                                {
                                    splitPane7.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                    //---- Button_viewAvailableVehicles ----
                                    Button_viewAvailableVehicles.setText(bundle.getString("User.Button_viewAvailableVehicles.text"));
                                    Button_viewAvailableVehicles.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/find available vehicles.png")));
                                    Button_viewAvailableVehicles.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                                    Button_viewAvailableVehicles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    splitPane7.setTopComponent(Button_viewAvailableVehicles);

                                    //======== splitPane8 ========
                                    {
                                        splitPane8.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                        //---- Button_rentalSituation ----
                                        Button_rentalSituation.setText(bundle.getString("User.Button_rentalSituation.text"));
                                        Button_rentalSituation.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                                        Button_rentalSituation.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/my car rental situation.png")));
                                        Button_rentalSituation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                        splitPane8.setTopComponent(Button_rentalSituation);

                                        //======== splitPane9 ========
                                        {
                                            splitPane9.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                            //---- label4 ----
                                            label4.setText(bundle.getString("User.label4.text"));
                                            label4.setMaximumSize(new Dimension(60, 40));
                                            label4.setMinimumSize(new Dimension(60, 40));
                                            label4.setPreferredSize(new Dimension(60, 40));
                                            label4.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 11));
                                            label4.setHorizontalAlignment(SwingConstants.CENTER);
                                            label4.setForeground(new Color(102, 153, 255));
                                            splitPane9.setTopComponent(label4);

                                            //======== splitPane10 ========
                                            {
                                                splitPane10.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                //---- Button_accountRecharge ----
                                                Button_accountRecharge.setText(bundle.getString("User.Button_accountRecharge.text"));
                                                Button_accountRecharge.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/recharge.png")));
                                                Button_accountRecharge.setFont(new Font("\u65b0\u5b8b\u4f53", Font.PLAIN, 18));
                                                Button_accountRecharge.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                                splitPane10.setTopComponent(Button_accountRecharge);

                                                //======== splitPane11 ========
                                                {
                                                    splitPane11.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                    //---- Button_changePassword ----
                                                    Button_changePassword.setText(bundle.getString("User.Button_changePassword.text"));
                                                    Button_changePassword.setFont(new Font("\u65b0\u5b8b\u4f53", Font.PLAIN, 18));
                                                    Button_changePassword.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/change Password.png")));
                                                    Button_changePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                                    splitPane11.setTopComponent(Button_changePassword);

                                                    //======== splitPane12 ========
                                                    {
                                                        splitPane12.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                        //---- Button_signOut ----
                                                        Button_signOut.setText(bundle.getString("User.Button_signOut.text"));
                                                        Button_signOut.setFont(new Font("\u65b0\u5b8b\u4f53", Font.PLAIN, 18));
                                                        Button_signOut.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/sign out.png")));
                                                        Button_signOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                                        splitPane12.setTopComponent(Button_signOut);

                                                        //======== splitPane17 ========
                                                        {
                                                            splitPane17.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                            //---- button1 ----
                                                            button1.setText(bundle.getString("User.button1.text"));
                                                            button1.setMaximumSize(new Dimension(138, 36));
                                                            button1.setMinimumSize(new Dimension(138, 36));
                                                            button1.setPreferredSize(new Dimension(138, 36));
                                                            button1.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Delete account.png")));
                                                            button1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                                                            splitPane17.setTopComponent(button1);

                                                            //---- label2 ----
                                                            label2.setText(bundle.getString("User.label2.text"));
                                                            label2.setHorizontalTextPosition(SwingConstants.CENTER);
                                                            label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 18));
                                                            splitPane17.setBottomComponent(label2);
                                                        }
                                                        splitPane12.setBottomComponent(splitPane17);
                                                    }
                                                    splitPane11.setBottomComponent(splitPane12);
                                                }
                                                splitPane10.setBottomComponent(splitPane11);
                                            }
                                            splitPane9.setBottomComponent(splitPane10);
                                        }
                                        splitPane8.setBottomComponent(splitPane9);
                                    }
                                    splitPane7.setBottomComponent(splitPane8);
                                }
                                splitPane1.setBottomComponent(splitPane7);
                            }
                            splitPane4.setBottomComponent(splitPane1);
                        }
                        splitPane3.setRightComponent(splitPane4);
                    }
                    panel2.add(splitPane3, BorderLayout.CENTER);
                }
                scrollPane5.setViewportView(panel2);
            }
            Jframe_userContentPane.add(scrollPane5, BorderLayout.CENTER);
            Jframe_user.setSize(1150, 660);
            Jframe_user.setLocationRelativeTo(Jframe_user.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //初始化用户信息(首次刷新)
        RefreshUserInformation(bundle);
        //显示所有轿车(1代表查找所有)
        find_Cars(conn, 1);
        //显示所有客车
        find_Buses(conn, 1);
        //显示所有货车
        find_Trucks(conn, 1);
        //租用车辆
        Button_rentCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is_rent_user.equals("0")) {
                    int index = -1;

                    Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String current_date = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); //时间戳转化为时间

                    if (menu.getSelectedIndex() == 0) {
                        index = car.getSelectedRow();
                        if (index == -1) {
                            JOptionPane.showMessageDialog(Jframe_user, "请先在右边的表格中\n选中你想租用的车辆", "租车失败", JOptionPane.WARNING_MESSAGE);
                        }else {
                            String flag = car.getValueAt(index, 0).toString();
                            if (flag.equals("可租")) {
                                String number_temp = car.getValueAt(index, 1).toString();
                                String brand_temp = car.getValueAt(index, 2).toString();
                                Object[] options = {"确定", "我再想想"};
                                int temp = JOptionPane.showOptionDialog(Jframe_user, "确定租用车牌号为：" + number_temp + "的" + brand_temp + "轿车吗？", "租车确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                                if (temp == 0) {
                                    PreparedStatement pstmt_rent = null;
                                    PreparedStatement pstmt_rent_user = null;
                                    try {
                                        String sql_update = "update cars set flag =?, date=? where vehicleId=?";
                                        pstmt_rent = conn.prepareStatement(sql_update);
                                        pstmt_rent.setString(1, account_user);
                                        pstmt_rent.setString(2, current_date);
                                        pstmt_rent.setString(3, number_temp);
                                        pstmt_rent.executeUpdate();

                                        String sql_update_user = "update users set is_rent =? where account=?";
                                        pstmt_rent_user = conn.prepareStatement(sql_update_user);
                                        pstmt_rent_user.setString(1, number_temp);
                                        pstmt_rent_user.setString(2, account_user);
                                        pstmt_rent_user.executeUpdate();

                                        find_Cars(conn, 1);
                                        RefreshUserInformation(bundle);
                                        JOptionPane.showMessageDialog(Jframe_user, "租车成功！\n祝您用车愉快^_^！", "租车成功", JOptionPane.PLAIN_MESSAGE);

                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } finally {
                                        mysqlTool.close(pstmt_rent);
                                        mysqlTool.close(pstmt_rent_user);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(Jframe_user, "您所选用的汽车已被租用\n请选择其他车辆！", "租车失败", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else if (menu.getSelectedIndex() == 1) {
                        index = bus.getSelectedRow();
                        if (index == -1) {
                            JOptionPane.showMessageDialog(Jframe_user, "请先在右边的表格中\n选中你想租用的车辆", "租车失败", JOptionPane.WARNING_MESSAGE);
                        }else {
                            String flag = bus.getValueAt(index, 0).toString();
                            if (flag.equals("可租")) {
                                String number_temp = bus.getValueAt(index, 1).toString();
                                String brand_temp = bus.getValueAt(index, 2).toString();
                                Object[] options = {"确定", "我再想想"};
                                int temp = JOptionPane.showOptionDialog(Jframe_user, "确定租用车牌号为：" + number_temp + "的" + brand_temp + "客车吗？", "租车确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                                if (temp == 0) {
                                    PreparedStatement pstmt_rent = null;
                                    PreparedStatement pstmt_rent_user = null;
                                    try {
                                        String sql_update = "update buses set flag =?, date=? where vehicleId=?";
                                        pstmt_rent = conn.prepareStatement(sql_update);
                                        pstmt_rent.setString(1, account_user);
                                        pstmt_rent.setString(2, current_date);
                                        pstmt_rent.setString(3, number_temp);
                                        pstmt_rent.executeUpdate();

                                        String sql_update_user = "update users set is_rent =? where account=?";
                                        pstmt_rent_user = conn.prepareStatement(sql_update_user);
                                        pstmt_rent_user.setString(1, number_temp);
                                        pstmt_rent_user.setString(2, account_user);
                                        pstmt_rent_user.executeUpdate();

                                        find_Buses(conn, 1);
                                        RefreshUserInformation(bundle);
                                        JOptionPane.showMessageDialog(Jframe_user, "租车成功！\n祝您用车愉快^_^！", "租车成功", JOptionPane.PLAIN_MESSAGE);
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } finally {
                                        mysqlTool.close(pstmt_rent);
                                        mysqlTool.close(pstmt_rent_user);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(Jframe_user, "您所选用的汽车已被租用\n请选择其他车辆！", "租车失败", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else if (menu.getSelectedIndex() == 2) {
                        index = truck.getSelectedRow();
                        if (index == -1) {
                            JOptionPane.showMessageDialog(Jframe_user, "请先在右边的表格中\n选中你想租用的车辆", "租车失败", JOptionPane.WARNING_MESSAGE);
                        } else {
                            String flag = truck.getValueAt(index, 0).toString();
                            if (flag.equals("可租")) {
                                String number_temp = truck.getValueAt(index, 1).toString();
                                String brand_temp = truck.getValueAt(index, 2).toString();
                                Object[] options = {"确定", "我再想想"};
                                int temp = JOptionPane.showOptionDialog(Jframe_user, "确定租用车牌号为：" + number_temp + "的" + brand_temp + "货车吗？", "租车确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                                if (temp == 0) {
                                    PreparedStatement pstmt_rent = null;
                                    PreparedStatement pstmt_rent_user = null;
                                    try {
                                        String sql_update = "update trucks set flag =?, date=? where vehicleId=?";
                                        pstmt_rent = conn.prepareStatement(sql_update);
                                        pstmt_rent.setString(1,account_user);
                                        pstmt_rent.setString(2, current_date);
                                        pstmt_rent.setString(3, number_temp);
                                        pstmt_rent.executeUpdate();

                                        String sql_update_user = "update users set is_rent =? where account=?";
                                        pstmt_rent_user = conn.prepareStatement(sql_update_user);
                                        pstmt_rent_user.setString(1, number_temp);
                                        pstmt_rent_user.setString(2, account_user);
                                        pstmt_rent_user.executeUpdate();

                                        find_Trucks(conn, 1);
                                        RefreshUserInformation(bundle);
                                        JOptionPane.showMessageDialog(Jframe_user, "租车成功！\n祝您用车愉快^_^！", "租车成功", JOptionPane.PLAIN_MESSAGE);
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } finally {
                                        mysqlTool.close(pstmt_rent);
                                        mysqlTool.close(pstmt_rent_user);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(Jframe_user, "您所选用的汽车已被租用\n请选择其他车辆！", "租车失败", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Jframe_user, "系统检测到您已经租用了一辆汽车\n每个用户只能同时租一辆汽车！", "租车失败", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //归还车辆
        Button_returnVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is_rent_user.equals("0")) {
                    JOptionPane.showMessageDialog(Jframe_user, "您暂未租用任何汽车！", "还车失败", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int days = 0;
                        Object[] options = {"确定", "我再想想"};
                        int temp = JOptionPane.showOptionDialog(Jframe_user, "确定归还你所租的车辆吗？", "还车确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (temp == 0) {
                            int flag = 0;
                            PreparedStatement pstmt = null;
                            Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
                            try {//轿车
                                pstmt = conn.prepareStatement("select * from cars where vehicleId = ?");
                                pstmt.setString(1, is_rent_user);
                                ResultSet res_car = pstmt.executeQuery();
                                while (res_car.next() && flag == 0) {
                                    flag = 1;
                                    Car car_temp = new Car();
                                    //计算租用时间
                                    String time = res_car.getString("date");
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date date;
                                    date = format.parse(time);
                                    days = (int) ((System.currentTimeMillis() - date.getTime()) / (1000 * 24 * 3600));
                                    //计算租金
                                    car_temp.setPerRent(res_car.getFloat("rent"));
                                    car_temp.calRent(days);
                                    //添加营业额记录
                                    PreparedStatement pstmt_1 = null;
                                    try {
                                        String sql_record = "insert into income(time,vehicleId,days,amount) values(?,?,?,?)";
                                        pstmt = (PreparedStatement) conn.prepareStatement(sql_record);
                                        pstmt.setString(1, sd);
                                        pstmt.setString(2, is_rent_user);
                                        pstmt.setInt(3, days);
                                        pstmt.setFloat(4, car_temp.getPerRent());
                                        pstmt.executeUpdate();            //执行
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                    //更新营业额
                                    PreparedStatement pstmt_2 = null;
                                    pstmt_2 = conn.prepareStatement("update other_data set money = ? where number = 1");
                                    pstmt_2.setFloat(1, turnover + car_temp.getPerRent());
                                    pstmt_2.executeUpdate();
                                    //更新车库信息
                                    pstmt = conn.prepareStatement("update cars set flag = 1,date=0 where vehicleId = ?");
                                    pstmt.setString(1, is_rent_user);
                                    pstmt.executeUpdate();
                                    //更新用户信息
                                    pstmt = conn.prepareStatement("update users set is_rent = 0 where account = ?");
                                    pstmt.setString(1, account_user);
                                    pstmt.executeUpdate();
                                    pstmt = conn.prepareStatement("update users set balance = ? where account = ?");
                                    pstmt.setFloat(1, balance_user - car_temp.getPerRent());
                                    pstmt.setString(2, account_user);
                                    pstmt.executeUpdate();
                                    JOptionPane.showMessageDialog(Jframe_user, "本次共租车" + days + "天\n需支付" + car_temp.getPerRent() + "元" + "\n期待下次您的光临^_^！", "还车成功", JOptionPane.PLAIN_MESSAGE);
                                    find_Cars(conn, 1);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(Jframe_user, "系统出错", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                            try {//客车
                                pstmt = conn.prepareStatement("select * from buses where vehicleId = ?");
                                pstmt.setString(1, is_rent_user);
                                ResultSet res_bus = pstmt.executeQuery();
                                while (res_bus.next() && flag == 0) {
                                    flag = 1;
                                    Bus bus_temp = new Bus();
                                    //计算租用时间
                                    String time = res_bus.getString("date");
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date date;
                                    date = format.parse(time);
                                    days = (int) ((System.currentTimeMillis() - date.getTime()) / (1000 * 24 * 3600));
                                    //计算租金
                                    bus_temp.setPerRent(res_bus.getFloat("rent"));
                                    bus_temp.calRent(days);
                                    //添加营业额记录
                                    PreparedStatement pstmt_1 = null;
                                    try {
                                        String sql_record = "insert into income(time,vehicleId,days,amount) values(?,?,?,?)";
                                        pstmt = (PreparedStatement) conn.prepareStatement(sql_record);
                                        pstmt.setString(1, sd);
                                        pstmt.setString(2, is_rent_user);
                                        pstmt.setInt(3, days);
                                        pstmt.setFloat(4, bus_temp.getPerRent());
                                        pstmt.executeUpdate();            //执行
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                    //更新营业额
                                    PreparedStatement pstmt_2 = null;
                                    pstmt_2 = conn.prepareStatement("update other_data set money = ? where number = 1");
                                    pstmt_2.setFloat(1, turnover + bus_temp.getPerRent());
                                    pstmt_2.executeUpdate();
                                    //更新车库信息
                                    pstmt = conn.prepareStatement("update buses set flag = 1,date=0 where vehicleId = ?");
                                    pstmt.setString(1, is_rent_user);
                                    pstmt.executeUpdate();
                                    //更新用户信息
                                    pstmt = conn.prepareStatement("update users set is_rent = 0 where account = ?");
                                    pstmt.setString(1, account_user);
                                    pstmt.executeUpdate();
                                    pstmt = conn.prepareStatement("update users set balance = ? where account = ?");
                                    pstmt.setFloat(1, balance_user - bus_temp.getPerRent());
                                    pstmt.setString(2, account_user);
                                    pstmt.executeUpdate();
                                    JOptionPane.showMessageDialog(Jframe_user, "本次共租车" + days + "天\n需支付" + bus_temp.getPerRent() + "元" + "\n期待下次您的光临^_^！", "还车成功", JOptionPane.PLAIN_MESSAGE);
                                    find_Buses(conn, 1);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(Jframe_user, "系统出错", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                            try {//货车
                                pstmt = conn.prepareStatement("select * from trucks where vehicleId = ?");
                                pstmt.setString(1, is_rent_user);
                                ResultSet res_truck = pstmt.executeQuery();
                                while (res_truck.next() && flag == 0) {
                                    flag = 1;
                                    Truck truck_temp = new Truck();
                                    //计算租用时间
                                    String time = res_truck.getString("date");
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date date;
                                    date = format.parse(time);
                                    days = (int) ((System.currentTimeMillis() - date.getTime()) / (1000 * 24 * 3600));
                                    //计算租金
                                    truck_temp.setPerRent(res_truck.getFloat("rent"));
                                    truck_temp.calRent(days);
                                    //添加营业额记录
                                    PreparedStatement pstmt_1 = null;
                                    try {
                                        String sql_record = "insert into income(time,vehicleId,days,amount) values(?,?,?,?)";
                                        pstmt = (PreparedStatement) conn.prepareStatement(sql_record);
                                        pstmt.setString(1, sd);
                                        pstmt.setString(2, is_rent_user);
                                        pstmt.setInt(3, days);
                                        pstmt.setFloat(4, truck_temp.getPerRent());
                                        pstmt.executeUpdate();            //执行
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                    //更新营业额
                                    PreparedStatement pstmt_2 = null;
                                    pstmt_2 = conn.prepareStatement("update other_data set money = ? where number = 1");
                                    pstmt_2.setFloat(1, turnover + truck_temp.getPerRent());
                                    pstmt_2.executeUpdate();
                                    //更新车库信息
                                    pstmt = conn.prepareStatement("update trucks set flag = 1,date=0 where vehicleId = ?");
                                    pstmt.setString(1, is_rent_user);
                                    pstmt.executeUpdate();
                                    //更新用户信息
                                    pstmt = conn.prepareStatement("update users set is_rent = 0 where account = ?");
                                    pstmt.setString(1, account_user);
                                    pstmt.executeUpdate();
                                    pstmt = conn.prepareStatement("update users set balance = ? where account = ?");
                                    pstmt.setFloat(1, balance_user - truck_temp.getPerRent());
                                    pstmt.setString(2, account_user);
                                    pstmt.executeUpdate();
                                    JOptionPane.showMessageDialog(Jframe_user, "本次共租车" + days + "天\n需支付" + truck_temp.getPerRent() + "元" + "\n期待下次您的光临^_^！", "还车成功", JOptionPane.PLAIN_MESSAGE);
                                    find_Trucks(conn, 1);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(Jframe_user, "系统出错", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Jframe_user, "发生数据错误", "数据有误", JOptionPane.WARNING_MESSAGE);
                    }
                    RefreshUserInformation(bundle);
                }
            }
        });
        //查看所有车辆
        Button_viewAllVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find_Cars(conn, 1);
                find_Buses(conn, 1);
                find_Trucks(conn, 1);
            }
        });
        //查看可租车辆
        Button_viewAvailableVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find_Cars(conn, 0);
                find_Buses(conn, 0);
                find_Trucks(conn, 0);
            }
        });
        //我的租车情况
        Button_rentalSituation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is_rent_user.equals("0")) {
                    JOptionPane.showMessageDialog(Jframe_user, "您暂未租用任何汽车", "租车情况", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Jframe_user, "您已租用车牌号为："+is_rent_user+"汽车", "租车情况", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        //账户充值
        Button_accountRecharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = JOptionPane.showInputDialog(panel1, "请输入充值金额(仅支持整数金额)", "充值", JOptionPane.PLAIN_MESSAGE);
                int money = 0;
                try {
                    money = Integer.parseInt(str);
                    if (money >= 0) {
                        balance_user += money;
                        label_accountBalance.setText(bundle.getString("User.label_accountBalance.text") + balance_user);
                        //写入数据库
                        PreparedStatement pstmt_balance = null;
                        try {
                            String sql_update = "update users set balance =? where account=?";
                            pstmt_balance = conn.prepareStatement(sql_update);
                            pstmt_balance.setFloat(1, balance_user);
                            pstmt_balance.setString(2, account_user);
                            pstmt_balance.executeUpdate();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            mysqlTool.close(pstmt_balance);
                        }
                        JOptionPane.showMessageDialog(Jframe_user, "成功充值" + money + "\n祝您租车愉快！", "充值成功", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(Jframe_user, "请输入一个大于0的金额！", "充值失败", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Jframe_user, "请输入一个整数金额！", "充值失败", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //修改密码
        Button_changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePassword change_paassword = new ChangePassword(conn, account_user);
            }
        });
        //退出登录
        Button_signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mysqlTool.close(conn);   //关闭数据库连接
                Jframe_user.dispose();
                exit(0);
            }
        });
        //注销账户
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RefreshUserInformation(bundle);
                JOptionPane.showMessageDialog(Jframe_user, "请仔细阅读，然后进行下一步操作\n1.账号所有信息将彻底删除\n2.删除后的账户无法再恢复\n3.归还所租车辆后才能删除", "【请谨慎操作】", JOptionPane.WARNING_MESSAGE);
                if (is_rent_user.equals("0")) {
                    String input_password = JOptionPane.showInputDialog(panel1, "为了确保是本人操作，请输入您的登录密码以进行下一步", "二次验证", JOptionPane.PLAIN_MESSAGE);
                    if (input_password instanceof String) {
                        String true_password = null;
                        try {
                            PreparedStatement pstmt = null;
                            pstmt = conn.prepareStatement("select * from users where account = ?");
                            pstmt.setString(1, account_user);
                            ResultSet res = pstmt.executeQuery();
                            while (res.next()) {
                                true_password = res.getString("password");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        if (true_password.equals(input_password)) {
                            Object[] options = {"确定", "我再想想"};
                            int temp = JOptionPane.showOptionDialog(Jframe_user, "注销后的账号将永远无法恢复\n确认继续删除账号吗？", "注销确认", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                            if (temp == 0) {
                                String sql_1 = "delete from users where account = ?";
                                PreparedStatement pstmt = null;
                                try {
                                    pstmt = (PreparedStatement) conn.prepareStatement(sql_1);
                                    pstmt.setString(1, account_user);
                                    pstmt.executeUpdate();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                } finally {
                                    JOptionPane.showMessageDialog(Jframe_user, "您的账号已成功注销\n感谢您的使用^_^\n期待我们下一次更好的相遇", "注销成功", JOptionPane.INFORMATION_MESSAGE);
                                    mysqlTool.close(conn);   //关闭数据库连接
                                    Jframe_user.dispose();
                                    exit(0);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(Jframe_user, "密码输入错误，我们暂时无法注销您的账号", "验证失败", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Jframe_user, "暂时不能删除您的账号\n原因：您还有未归还的车辆", "注销失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    void find_Cars(Connection conn,int pattern) {
        List<Car> cars = new ArrayList<Car>();
        Vector vData = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
        Vector vName = new Vector();
        Vector vRow = null; //数据行向量，使用它的add()添加元素，有几行就new几个行向量。其中的元素就是单元格的内容
        PreparedStatement pstmt_car = null;
        try {
            String sql_find_allCar = "select * from cars";
            pstmt_car = conn.prepareStatement(sql_find_allCar);
            ResultSet res_car = pstmt_car.executeQuery(sql_find_allCar);
            while (res_car.next()) {//遍历查找结果
                if(pattern==1 || res_car.getString("flag").equals("1")) {
                    Car car_temp = new Car(
                            res_car.getString("flag"),
                            res_car.getString("vehicleId"),
                            res_car.getString("brand"),
                            res_car.getString("type"),
                            res_car.getFloat("rent"),
                            res_car.getString("date")
                    );
                    cars.add(car_temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_car);
        }
        vName.add("租用情况");
        vName.add("车牌号");
        vName.add("品牌");
        vName.add("型号");
        vName.add("每日租金");
        for (int i = 0; i < cars.size(); i++) {
            vRow = new Vector();
            if(cars.get(i).flag.equals("1")){
                vRow.add("可租");
            }else {
                vRow.add("已租出");
            }
            vRow.add(cars.get(i).getPlateNumber());
            vRow.add(cars.get(i).getBrand());
            vRow.add(cars.get(i).getType());
            vRow.add(cars.get(i).getPerRent());
            vData.add(vRow.clone());
        }
        MyTableModel model = new MyTableModel(vData, vName); //新建一个默认数据模型
        car.setModel(model);
        scrollPane1.setViewportView(car);
        car.setShowHorizontalLines(true);//显示水平线
        car.setShowVerticalLines(true); //显示垂直线
    }

    void find_Buses(Connection conn,int pattern) {
        List<Bus> buses = new ArrayList<Bus>();
        Vector vData = new Vector();
        Vector vName = new Vector();
        PreparedStatement pstmt_bus = null;
        Vector vRow = null;
        try {
            String sql_find_allBus = "select * from buses";
            pstmt_bus = conn.prepareStatement(sql_find_allBus);
            ResultSet res_bus = pstmt_bus.executeQuery(sql_find_allBus);
            while (res_bus.next()) {//遍历查找结果
                if (pattern == 1 || res_bus.getString("flag").equals("1")) {
                    Bus bus_temp = new Bus(
                            res_bus.getString("flag"),
                            res_bus.getString("vehicleId"),
                            res_bus.getString("brand"),
                            res_bus.getInt("seat"),
                            res_bus.getFloat("rent"),
                            res_bus.getString("date")
                    );
                    buses.add(bus_temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_bus);
        }
        vName.add("租用情况");
        vName.add("车牌号");
        vName.add("品牌");
        vName.add("座位数量");
        vName.add("每日租金");
        for (int i = 0; i < buses.size(); i++) {
            vRow = new Vector();
            if(buses.get(i).flag.equals("1")){
                vRow.add("可租");
            }else {
                vRow.add("已租出");
            }
            vRow.add(buses.get(i).getPlateNumber());
            vRow.add(buses.get(i).getBrand());
            vRow.add(buses.get(i).getSeat());
            vRow.add(buses.get(i).getPerRent());
            vData.add(vRow.clone());
        }
        MyTableModel model = new MyTableModel(vData, vName);
        bus.setModel(model);
        scrollPane3.setViewportView(bus);
        bus.setShowHorizontalLines(true);//显示水平线
        bus.setShowVerticalLines(true); //显示垂直线
    }

    void find_Trucks(Connection conn,int pattern) {
        List<Truck> trucks = new ArrayList<Truck>();
        Vector vData = new Vector();
        Vector vName = new Vector();
        Vector vRow = null;
        PreparedStatement pstmt_truck = null;
        try {
            String sql_find_allTruck = "select * from trucks";
            pstmt_truck = conn.prepareStatement(sql_find_allTruck);
            ResultSet res_truck = pstmt_truck.executeQuery(sql_find_allTruck);
            while (res_truck.next()) {//遍历查找结果
                if (pattern == 1 || res_truck.getString("flag").equals("1")) {
                    Truck truck_temp = new Truck(
                            res_truck.getString("flag"),
                            res_truck.getString("vehicleId"),
                            res_truck.getString("brand"),
                            res_truck.getFloat("tonnage"),
                            res_truck.getFloat("rent"),
                            res_truck.getString("date")
                    );
                    trucks.add(truck_temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_truck);
        }
        vName.add("租用情况");
        vName.add("车牌号");
        vName.add("品牌");
        vName.add("吨位");
        vName.add("每日租金");
        for (int i = 0; i < trucks.size(); i++) {
            vRow = new Vector();
            if(trucks.get(i).flag.equals("1")){
                vRow.add("可租");
            }else {
                vRow.add("已租出");
            }
            vRow.add(trucks.get(i).getPlateNumber());
            vRow.add(trucks.get(i).getBrand());
            vRow.add(trucks.get(i).getTon());
            vRow.add(trucks.get(i).getPerRent());
            vData.add(vRow.clone());
        }
        MyTableModel model = new MyTableModel(vData, vName); //新建一个默认数据模型
        truck.setModel(model);
        scrollPane4.setViewportView(truck);
        truck.setShowHorizontalLines(true);//显示水平线
        truck.setShowVerticalLines(true); //显示垂直线
    }

    void RefreshUserInformation(ResourceBundle bundle) {
        String sql_find = "select * from users where account = ?";
        PreparedStatement pstmt_1 = null;
        try {
            pstmt_1 = conn.prepareStatement(sql_find);
            pstmt_1.setString(1, account_user);//给占位符？传递值
            //执行查询语句
            ResultSet res = pstmt_1.executeQuery();
            while (res.next()) {
                name_user = res.getString("name");
                gender_user = res.getString("gender");
                balance_user = res.getFloat("balance");
                is_rent_user = res.getString("is_rent");
            }
            if (gender_user.equals("男")) {
                label5.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Male user.png")));
            } else if (gender_user.equals("女")) {
                label5.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Female user.png")));
            }
            label_greetings.setText(bundle.getString("User.label_greetings.text") + name_user + "-");
            label_name.setText(bundle.getString("User.label_name.text") + name_user);
            label_gender.setText(bundle.getString("User.label_gender.text") + gender_user);
            label_account.setText(bundle.getString("User.label_account.text") + account_user);
            label_accountBalance.setText(bundle.getString("User.label_accountBalance.text") + balance_user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //顺便刷新一下营业额
        String sql_find_money = "select * from other_data where number=1";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql_find_money);
            ResultSet res = pstmt.executeQuery(sql_find_money);
            while (res.next()) {//遍历查找结果
                turnover=res.getFloat("money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame Jframe_user;
    private JLabel label1;
    private JPanel panel1;
    private JTabbedPane menu;
    private JScrollPane scrollPane1;
    private JTable car;
    private JScrollPane scrollPane3;
    private JTable bus;
    private JScrollPane scrollPane4;
    private JTable truck;
    private JScrollPane scrollPane5;
    private JPanel panel2;
    private JLabel label3;
    private JSplitPane splitPane3;
    private JSplitPane splitPane2;
    private JSplitPane splitPane6;
    private JLabel label_greetings;
    private JLabel label5;
    private JSplitPane splitPane13;
    private JLabel label_name;
    private JSplitPane splitPane14;
    private JLabel label_gender;
    private JSplitPane splitPane15;
    private JLabel label_account;
    private JSplitPane splitPane16;
    private JLabel label_accountBalance;
    private JPanel vSpacer1;
    private JSplitPane splitPane4;
    private JSplitPane splitPane5;
    private JButton Button_rentCar;
    private JButton Button_returnVehicle;
    private JSplitPane splitPane1;
    private JButton Button_viewAllVehicles;
    private JSplitPane splitPane7;
    private JButton Button_viewAvailableVehicles;
    private JSplitPane splitPane8;
    private JButton Button_rentalSituation;
    private JSplitPane splitPane9;
    private JLabel label4;
    private JSplitPane splitPane10;
    private JButton Button_accountRecharge;
    private JSplitPane splitPane11;
    private JButton Button_changePassword;
    private JSplitPane splitPane12;
    private JButton Button_signOut;
    private JSplitPane splitPane17;
    private JButton button1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

//继承DefaultTableModel类并重写isCellEditable，使得JTable表格无法编辑
class MyTableModel extends DefaultTableModel{
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public MyTableModel(Vector data,Vector columns){
        super(data, columns);
    }
}
