/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.manage;

import huang.wen.cars.Bus;
import huang.wen.cars.Car;
import huang.wen.cars.MotoVehicle;
import huang.wen.cars.Truck;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import static java.lang.System.exit;

public class Administrator {
    String name_administrator = null;
    String gender_administrator = null;
    String account_administrator;
    //连接数据库
    DBUtil mysqlTool = new DBUtil();
    Connection conn = mysqlTool.getConnection();
    //用户信息
    List<Users_infor> users = new ArrayList<>();

    public Administrator(String account) throws SQLException {
        this.account_administrator=account;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("configuration.ConfigurationFile");
        Administrator = new JFrame("后台管理");
        panel1 = new JPanel();
        splitPane1 = new JSplitPane();
        splitPane2 = new JSplitPane();
        label_name = new JLabel();
        splitPane3 = new JSplitPane();
        label_gender = new JLabel();
        splitPane4 = new JSplitPane();
        button_addCar = new JButton();
        splitPane5 = new JSplitPane();
        button_reviseCar = new JButton();
        splitPane6 = new JSplitPane();
        button_findCar = new JButton();
        splitPane7 = new JSplitPane();
        button_removeCar = new JButton();
        splitPane8 = new JSplitPane();
        label1 = new JLabel();
        splitPane9 = new JSplitPane();
        button_turnover = new JButton();
        splitPane10 = new JSplitPane();
        button_exportInformation = new JButton();
        splitPane11 = new JSplitPane();
        button_exitSystem = new JButton();
        textField1 = new JTextField();
        Menu = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        table_garage = new JTable();
        scrollPane2 = new JScrollPane();
        table_users = new JTable();

        //======== Administrator ========
        {
            Administrator.setMinimumSize(new Dimension(1000, 600));
            Administrator.setVisible(true);
            Administrator.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            Administrator.setResizable(false);
            Administrator.setIconImage(new ImageIcon(getClass().getResource("/huang/wen/source/logo_white.png")).getImage());
            var AdministratorContentPane = Administrator.getContentPane();
            AdministratorContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== splitPane1 ========
                {
                    splitPane1.setDividerLocation(200);
                    //======== splitPane2 ========
                    {
                        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

                        //---- label_name ----
                        label_name.setText(bundle.getString("Administrator.label_name.text"));
                        label_name.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                        splitPane2.setTopComponent(label_name);

                        //======== splitPane3 ========
                        {
                            splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);

                            //---- label_gender ----
                            label_gender.setText(bundle.getString("Administrator.label_gender.text"));
                            label_gender.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                            splitPane3.setTopComponent(label_gender);

                            //======== splitPane4 ========
                            {
                                splitPane4.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                //---- button_addCar ----
                                button_addCar.setText(bundle.getString("Administrator.button_addCar.text"));
                                button_addCar.setPreferredSize(new Dimension(150, 36));
                                button_addCar.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                button_addCar.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/New vehicle.png")));
                                button_addCar.setMinimumSize(new Dimension(150, 36));
                                button_addCar.setMaximumSize(new Dimension(150, 36));
                                splitPane4.setTopComponent(button_addCar);

                                //======== splitPane5 ========
                                {
                                    splitPane5.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                    //---- button_reviseCar ----
                                    button_reviseCar.setText(bundle.getString("Administrator.button_reviseCar.text"));
                                    button_reviseCar.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                    button_reviseCar.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Modify vehicle information.png")));
                                    button_reviseCar.setMaximumSize(new Dimension(150, 36));
                                    button_reviseCar.setPreferredSize(new Dimension(150, 36));
                                    button_reviseCar.setMinimumSize(new Dimension(150, 36));
                                    splitPane5.setTopComponent(button_reviseCar);

                                    //======== splitPane6 ========
                                    {
                                        splitPane6.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                        //---- button_findCar ----
                                        button_findCar.setText(bundle.getString("Administrator.button_findCar.text"));
                                        button_findCar.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                        button_findCar.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Inquire.png")));
                                        button_findCar.setMaximumSize(new Dimension(150, 36));
                                        button_findCar.setMinimumSize(new Dimension(150, 36));
                                        button_findCar.setPreferredSize(new Dimension(150, 36));
                                        splitPane6.setTopComponent(button_findCar);

                                        //======== splitPane7 ========
                                        {
                                            splitPane7.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                            //---- button_removeCar ----
                                            button_removeCar.setText(bundle.getString("Administrator.button_removeCar.text"));
                                            button_removeCar.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                            button_removeCar.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Remove.png")));
                                            button_removeCar.setPreferredSize(new Dimension(150, 36));
                                            button_removeCar.setMinimumSize(new Dimension(150, 36));
                                            button_removeCar.setMaximumSize(new Dimension(150, 36));
                                            splitPane7.setTopComponent(button_removeCar);

                                            //======== splitPane8 ========
                                            {
                                                splitPane8.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                //---- label1 ----
                                                label1.setText(bundle.getString("Administrator.label1.text"));
                                                splitPane8.setTopComponent(label1);

                                                //======== splitPane9 ========
                                                {
                                                    splitPane9.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                    //---- button_turnover ----
                                                    button_turnover.setText(bundle.getString("Administrator.button_turnover.text"));
                                                    button_turnover.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                                    button_turnover.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Turnover.png")));
                                                    button_turnover.setMaximumSize(new Dimension(150, 36));
                                                    button_turnover.setMinimumSize(new Dimension(150, 36));
                                                    button_turnover.setPreferredSize(new Dimension(150, 36));
                                                    splitPane9.setTopComponent(button_turnover);

                                                    //======== splitPane10 ========
                                                    {
                                                        splitPane10.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                        //---- button_exportInformation ----
                                                        button_exportInformation.setText(bundle.getString("Administrator.button_exportInformation.text"));
                                                        button_exportInformation.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                                        button_exportInformation.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Export.png")));
                                                        button_exportInformation.setPreferredSize(new Dimension(150, 36));
                                                        button_exportInformation.setMinimumSize(new Dimension(150, 36));
                                                        button_exportInformation.setMaximumSize(new Dimension(150, 36));
                                                        splitPane10.setTopComponent(button_exportInformation);

                                                        //======== splitPane11 ========
                                                        {
                                                            splitPane11.setOrientation(JSplitPane.VERTICAL_SPLIT);

                                                            //---- button_exitSystem ----
                                                            button_exitSystem.setText(bundle.getString("Administrator.button_exitSystem.text"));
                                                            button_exitSystem.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.PLAIN, 16));
                                                            button_exitSystem.setMaximumSize(new Dimension(150, 30));
                                                            button_exitSystem.setPreferredSize(new Dimension(150, 30));
                                                            button_exitSystem.setMinimumSize(new Dimension(150, 30));
                                                            splitPane11.setTopComponent(button_exitSystem);

                                                            //---- textField1 ----
                                                            textField1.setText(bundle.getString("Administrator.textField1.text"));
                                                            textField1.setHorizontalAlignment(SwingConstants.CENTER);
                                                            textField1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
                                                            textField1.setEditable(false);
                                                            textField1.setMinimumSize(new Dimension(150, 30));
                                                            textField1.setMaximumSize(new Dimension(150, 100000));
                                                            textField1.setPreferredSize(new Dimension(150, 30));
                                                            textField1.setRequestFocusEnabled(false);
                                                            splitPane11.setBottomComponent(textField1);
                                                        }
                                                        splitPane10.setBottomComponent(splitPane11);
                                                    }
                                                    splitPane9.setBottomComponent(splitPane10);
                                                }
                                                splitPane8.setBottomComponent(splitPane9);
                                            }
                                            splitPane7.setBottomComponent(splitPane8);
                                        }
                                        splitPane6.setBottomComponent(splitPane7);
                                    }
                                    splitPane5.setBottomComponent(splitPane6);
                                }
                                splitPane4.setBottomComponent(splitPane5);
                            }
                            splitPane3.setBottomComponent(splitPane4);
                        }
                        splitPane2.setBottomComponent(splitPane3);
                    }
                    splitPane1.setLeftComponent(splitPane2);

                    //======== Menu ========
                    {

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setViewportView(table_garage);
                        }
                        Menu.addTab("\u8f66\u5e93", scrollPane1);

                        //======== scrollPane2 ========
                        {
                            scrollPane2.setViewportView(table_users);
                        }
                        Menu.addTab("\u7528\u6237", scrollPane2);
                    }
                    splitPane1.setRightComponent(Menu);
                }
                panel1.add(splitPane1, BorderLayout.CENTER);
            }
            AdministratorContentPane.add(panel1, BorderLayout.CENTER);
            Administrator.pack();
            Administrator.setLocationRelativeTo(Administrator.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //初始化管理员信息(首次刷新)
        RefreshUserInformation(bundle);
        //获取所有车辆信息并显示
        DisplayVehicles(conn);
        //获取所有用户的信息并显示
        DisplayUserInformation(conn);
        //新增车辆
        button_addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleFactory vehicleFactory = new VehicleFactory();
                String newVehicle = JOptionPane.showInputDialog(Administrator, "请输入汽车类型\n[轿车、客车、货车]", "新增车辆——汽车类型",JOptionPane.PLAIN_MESSAGE);
                if(newVehicle instanceof String) {
                    MotoVehicle Vehicle = vehicleFactory.getVehicleByType(newVehicle);
                    if (Vehicle == null) {
                        JOptionPane.showMessageDialog(Administrator, "目前仅支持轿车、客车、货车三种车型", "添加失败", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Vehicle.AddProcess(Administrator);
                        DisplayVehicles(conn);
                    }
                }
            }
        });
        //修改车辆信息
        button_reviseCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = -1;
                if (Menu.getSelectedIndex() == 0) {
                    index = table_garage.getSelectedRow();
                    if (index != -1) {
                        String type_temp = table_garage.getValueAt(index, 0).toString();
                        String number_temp = table_garage.getValueAt(index, 1).toString();
                        String brand_temp = table_garage.getValueAt(index, 2).toString();
                        if (table_garage.getValueAt(index, 5).toString().equals("暂未租出")) {
                            String sql_update;
                            PreparedStatement pstmt = null;
                            try {
                                if (type_temp.equals("轿车")) {
                                    sql_update = "update cars set vehicleId=?, brand=?, type=?, rent=? where vehicleId=?";
                                    String str_vehicleId = JOptionPane.showInputDialog(Administrator, "请输入新的车牌号", "修改车牌号", JOptionPane.PLAIN_MESSAGE);
                                    if (str_vehicleId instanceof String) {
                                        String str_brand = JOptionPane.showInputDialog(Administrator, "请输入修改之后的汽车品牌", "修改汽车品牌", JOptionPane.PLAIN_MESSAGE);
                                        if (str_brand instanceof String) {
                                            String str_type = JOptionPane.showInputDialog(Administrator, "请输入修改之后的汽车型号", "修改汽车型号", JOptionPane.PLAIN_MESSAGE);
                                            if (str_type instanceof String) {
                                                String str_rent = JOptionPane.showInputDialog(Administrator, "请输入修改之后的单价（每日租金）", "修改每日租金", JOptionPane.PLAIN_MESSAGE);
                                                if (str_rent instanceof String) {
                                                    Object[] options = {"确定", "取消"};
                                                    int temp = JOptionPane.showOptionDialog(Administrator, "确定对车牌号为：" + number_temp + "的" + brand_temp + type_temp + "进行修改吗？", "修改确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
                                                    if (temp == 0) {
                                                        pstmt = (PreparedStatement) conn.prepareStatement(sql_update);
                                                        pstmt.setString(1, str_vehicleId);
                                                        pstmt.setString(2, str_brand);
                                                        pstmt.setString(3, str_type);
                                                        pstmt.setFloat(4, Integer.parseInt(str_rent));
                                                        pstmt.setString(5, number_temp);
                                                        pstmt.executeUpdate();
                                                        JOptionPane.showMessageDialog(Administrator, "已成功修改原车牌号为\"" + number_temp + "\"的汽车", "修改成功", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (type_temp.equals("客车")) {
                                    sql_update = "update buses set vehicleId=?, brand=?, seat=?, rent=? where vehicleId=?";
                                    String str_vehicleId = JOptionPane.showInputDialog(Administrator, "请输入新的车牌号", "修改车牌号", JOptionPane.PLAIN_MESSAGE);
                                    if (str_vehicleId instanceof String) {
                                        String str_brand = JOptionPane.showInputDialog(Administrator, "请输入修改之后的客车品牌", "修改客车品牌", JOptionPane.PLAIN_MESSAGE);
                                        if (str_brand instanceof String) {
                                            String str_seat = JOptionPane.showInputDialog(Administrator, "请输入修改之后的座位数", "修改客车载客量", JOptionPane.PLAIN_MESSAGE);
                                            if (str_seat instanceof String) {
                                                String str_rent = JOptionPane.showInputDialog(Administrator, "请输入修改之后的单价（每日租金）", "修改每日租金", JOptionPane.PLAIN_MESSAGE);
                                                if (str_rent instanceof String) {
                                                    Object[] options = {"确定", "取消"};
                                                    int temp = JOptionPane.showOptionDialog(Administrator, "确定对车牌号为：" + number_temp + "的" + brand_temp + type_temp + "座进行修改吗？", "修改确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
                                                    if (temp == 0) {
                                                        pstmt = (PreparedStatement) conn.prepareStatement(sql_update);
                                                        pstmt.setString(1, str_vehicleId);
                                                        pstmt.setString(2, str_brand);
                                                        pstmt.setInt(3, Integer.parseInt(str_seat));
                                                        pstmt.setFloat(4, Integer.parseInt(str_rent));
                                                        pstmt.setString(5, number_temp);
                                                        pstmt.executeUpdate();
                                                        JOptionPane.showMessageDialog(Administrator, "已成功修改原车牌号为\"" + number_temp + "\"的汽车", "修改成功", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (type_temp.equals("货车")) {
                                    sql_update = "update trucks set vehicleId=?, brand=?, tonnage=?, rent=? where vehicleId=?";
                                    String str_vehicleId = JOptionPane.showInputDialog(Administrator, "请输入新的车牌号", "修改车牌号", JOptionPane.PLAIN_MESSAGE);
                                    if (str_vehicleId instanceof String) {
                                        String str_brand = JOptionPane.showInputDialog(Administrator, "请输入修改之后的货车品牌", "修改货车品牌", JOptionPane.PLAIN_MESSAGE);
                                        if (str_brand instanceof String) {
                                            String str_tonnage = JOptionPane.showInputDialog(Administrator, "请输入修改之后的货车吨位", "修改货车载重", JOptionPane.PLAIN_MESSAGE);
                                            if (str_tonnage instanceof String) {
                                                String str_rent = JOptionPane.showInputDialog(Administrator, "请输入修改之后的单价（每日租金）", "修改每日租金", JOptionPane.PLAIN_MESSAGE);
                                                if (str_rent instanceof String) {
                                                    Object[] options = {"确定", "取消"};
                                                    int temp = JOptionPane.showOptionDialog(Administrator, "确定对车牌号为：" + number_temp + "的" + brand_temp + type_temp + "进行修改吗？", "修改确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
                                                    if (temp == 0) {
                                                        pstmt = (PreparedStatement) conn.prepareStatement(sql_update);
                                                        pstmt.setString(1, str_vehicleId);
                                                        pstmt.setString(2, str_brand);
                                                        pstmt.setFloat(3, Integer.parseInt(str_tonnage));
                                                        pstmt.setFloat(4, Integer.parseInt(str_rent));
                                                        pstmt.setString(5, number_temp);
                                                        pstmt.executeUpdate();
                                                        JOptionPane.showMessageDialog(Administrator, "已成功修改原车牌号为\"" + number_temp + "\"的汽车", "修改成功", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                DisplayVehicles(conn);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            } finally {
                                mysqlTool.close(pstmt);
                            }
                        } else {
                            JOptionPane.showMessageDialog(Administrator, "该汽车正在外租中，暂时不能修改！", "修改失败", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(Administrator, "请在右方选择需要修改的汽车！", "修改失败", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(Administrator, "请在右方选择需要修改的汽车！", "修改失败", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //查询车辆信息
        button_findCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str_input = JOptionPane.showInputDialog(Administrator, "请输入你希望查询车辆的车牌号", "查询车辆信息", JOptionPane.PLAIN_MESSAGE);
                if (str_input instanceof String) {
                    ResultSet res = null;
                    int flag = 0;//校验查询情况
                    PreparedStatement pstmt = null;
                    if (flag == 0) {
                        try {
                            String sql = "select * from cars where vehicleId = ?";
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, str_input);
                            res = pstmt.executeQuery();
                            if (res.next()) {
                                flag = 1;
                                String flag_temp = res.getString("flag");
                                String vehicleId_temp = res.getString("vehicleId");
                                String brand_temp = res.getString("brand");
                                String type_temp = res.getString("type");
                                float rent_temp = res.getFloat("rent");
                                String date_temp = res.getString("date");
                                if (flag_temp.equals("1")) {
                                    flag_temp = "暂未租出";
                                } else {
                                    flag_temp = "已被" + res.getString("flag") + "租用";
                                }

                                if (date_temp.equals("0")) {
                                    date_temp = "";
                                } else {
                                    date_temp = "\n租用时间：" + res.getString("date");
                                }
                                JOptionPane.showMessageDialog(Administrator,
                                        "查询到如下信息：\n车牌号：" + vehicleId_temp + "\n汽车类型：轿车\n汽车品牌：" + brand_temp + "\n汽车类型：" + type_temp + "\n每日租金：" + rent_temp + "\n租用情况：" + flag_temp + date_temp,
                                        "查询成功", JOptionPane.PLAIN_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            mysqlTool.close(pstmt);
                        }
                    }
                    if (flag == 0) {
                        try {
                            String sql = "select * from buses where vehicleId = ?";
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, str_input);
                            res = pstmt.executeQuery();
                            if (res.next()) {
                                flag = 1;
                                String flag_temp = res.getString("flag");
                                String vehicleId_temp = res.getString("vehicleId");
                                String brand_temp = res.getString("brand");
                                int seat_temp = res.getInt("seat");
                                float rent_temp = res.getFloat("rent");
                                String date_temp = res.getString("date");
                                if (flag_temp.equals("1")) {
                                    flag_temp = "暂未租出";
                                } else {
                                    flag_temp = "已被" + res.getString("flag") + "租用";
                                }
                                if (date_temp.equals("0")) {
                                    date_temp = "";
                                } else {
                                    date_temp = "\n租用时间：" + res.getString("date");
                                }
                                JOptionPane.showMessageDialog(Administrator,
                                        "查询到如下信息：\n车牌号：" + vehicleId_temp + "\n汽车类型：客车\n汽车品牌：" + brand_temp + "\n汽车类型：" + seat_temp + "\n每日租金：" + rent_temp + "\n租用情况：" + flag_temp + date_temp,
                                        "查询成功", JOptionPane.PLAIN_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            mysqlTool.close(pstmt);
                        }
                    }
                    if (flag == 0) {
                        try {
                            String sql = "select * from trucks where vehicleId = ?";
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, str_input);
                            res = pstmt.executeQuery();
                            if (res.next()) {
                                flag = 1;
                                String flag_temp = res.getString("flag");
                                String vehicleId_temp = res.getString("vehicleId");
                                String brand_temp = res.getString("brand");
                                float tonnage_temp = res.getFloat("tonnage");
                                float rent_temp = res.getFloat("rent");
                                String date_temp = res.getString("date");

                                if (flag_temp.equals("1")) {
                                    flag_temp = "暂未租出";
                                } else {
                                    flag_temp = "已被" + res.getString("flag") + "租用";
                                }

                                if (date_temp.equals("0")) {
                                    date_temp = "";
                                } else {
                                    date_temp = "\n租用时间：" + res.getString("date");
                                }
                                JOptionPane.showMessageDialog(Administrator,
                                        "查询到如下信息：\n车牌号：" + vehicleId_temp + "\n汽车类型：货车\n汽车品牌：" + brand_temp + "\n汽车类型：" + tonnage_temp + "\n每日租金：" + rent_temp + "\n租用情况：" + flag_temp + date_temp,
                                        "查询成功", JOptionPane.PLAIN_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            mysqlTool.close(pstmt);
                        }
                    }
                    if (flag == 0) {
                        JOptionPane.showMessageDialog(Administrator, "未在车库中找到车牌号为\"" + str_input + "\"的汽车\n以下原因会导致这种情况：\n1.输入的车牌号有误\n2.车库中不存在该车辆", "查询失败", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        //移除车辆
        button_removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = -1;
                if (Menu.getSelectedIndex() == 0) {
                    index = table_garage.getSelectedRow();
                    if (index != -1) {
                        String type_temp = table_garage.getValueAt(index, 0).toString();
                        String number_temp = table_garage.getValueAt(index, 1).toString();
                        String brand_temp = table_garage.getValueAt(index, 2).toString();
                        if(table_garage.getValueAt(index, 5).toString().equals("暂未租出")) {
                            Object[] options = {"确定", "取消"};
                            int temp = JOptionPane.showOptionDialog(Administrator, "确定移除车牌号为：" + number_temp + "的" + brand_temp + type_temp + "吗？", "移除确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
                            if (temp == 0) {
                                String sql_1 = "delete from cars where vehicleId = ?";
                                String sql_2 = "delete from buses where vehicleId = ?";
                                String sql_3 = "delete from trucks where vehicleId = ?";
                                PreparedStatement pstmt = null;
                                try {
                                    pstmt = (PreparedStatement) conn.prepareStatement(sql_1);
                                    pstmt.setString(1, number_temp);
                                    pstmt.executeUpdate();

                                    pstmt = (PreparedStatement) conn.prepareStatement(sql_2);
                                    pstmt.setString(1, number_temp);
                                    pstmt.executeUpdate();

                                    pstmt = (PreparedStatement) conn.prepareStatement(sql_3);
                                    pstmt.setString(1, number_temp);
                                    pstmt.executeUpdate();

                                    JOptionPane.showMessageDialog(Administrator, "已成功将\"" + number_temp + "\"移除", "移除成功", JOptionPane.INFORMATION_MESSAGE);
                                    DisplayVehicles(conn);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                } finally {
                                    mysqlTool.close(pstmt);
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(Administrator, "该汽车正在外租中，暂时不能移除！", "移除失败", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        //提示用户输入车牌号
                        String str_input = JOptionPane.showInputDialog(Administrator, "请输入你希望移除车辆的车牌号", "移除指定车辆", JOptionPane.PLAIN_MESSAGE);
                        if(str_input instanceof String) {
                            String sql_1 = "delete from cars where vehicleId = ?";
                            String sql_2 = "delete from buses where vehicleId = ?";
                            String sql_3 = "delete from trucks where vehicleId = ?";
                            PreparedStatement pstmt = null;
                            try {
                                pstmt = (PreparedStatement) conn.prepareStatement(sql_1);
                                pstmt.setString(1, str_input);
                                pstmt.executeUpdate();

                                pstmt = (PreparedStatement) conn.prepareStatement(sql_2);
                                pstmt.setString(1, str_input);
                                pstmt.executeUpdate();

                                pstmt = (PreparedStatement) conn.prepareStatement(sql_3);
                                pstmt.setString(1, str_input);
                                pstmt.executeUpdate();

                                JOptionPane.showMessageDialog(Administrator, "已成功将\"" + str_input + "\"移除", "移除成功", JOptionPane.INFORMATION_MESSAGE);
                                DisplayVehicles(conn);

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            } finally {
                                mysqlTool.close(pstmt);
                            }
                        }
                    }
                } else {
                    //提示用户输入车牌号
                    String str_input = JOptionPane.showInputDialog(Administrator, "请输入你希望移除车辆的车牌号", "移除指定车辆", JOptionPane.PLAIN_MESSAGE);
                    if(str_input instanceof String) {
                        String sql_1 = "delete from cars where vehicleId = ?";
                        String sql_2 = "delete from buses where vehicleId = ?";
                        String sql_3 = "delete from trucks where vehicleId = ?";
                        PreparedStatement pstmt = null;
                        try {
                            pstmt = (PreparedStatement) conn.prepareStatement(sql_1);
                            pstmt.setString(1, str_input);
                            pstmt.executeUpdate();

                            pstmt = (PreparedStatement) conn.prepareStatement(sql_2);
                            pstmt.setString(1, str_input);
                            pstmt.executeUpdate();

                            pstmt = (PreparedStatement) conn.prepareStatement(sql_3);
                            pstmt.setString(1, str_input);
                            pstmt.executeUpdate();

                            JOptionPane.showMessageDialog(Administrator, "已成功将\"" + str_input + "\"移除", "移除成功", JOptionPane.INFORMATION_MESSAGE);
                            DisplayVehicles(conn);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            mysqlTool.close(pstmt);
                        }
                    }
                }
            }
        });
        //营业额
        button_turnover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrator.dispose();
                new Turnover(account_administrator);
            }
        });
        //导出用户信息
        button_exportInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String current_date = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); //时间戳转化为时间

                //选择文件保存路径
                File file = null;
                JFileChooser fileChooser = new JFileChooser(".\\"); //默认保存位置
                // 设置打开文件选择框后默认输入的文件名
                fileChooser.setSelectedFile(new File("用户信息表.html"));
                // 打开文件选择框
                int result = fileChooser.showSaveDialog(Administrator);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // 如果点击了"保存", 则获取选择的保存路径
                    file = fileChooser.getSelectedFile();
                }

                //写入中文字符时解决中文乱码问题
                if (file != null) {
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(new File(file.getAbsolutePath()));
                        OutputStreamWriter osw = null;
                        osw = new OutputStreamWriter(fos, "UTF-8");
                        BufferedWriter bw = new BufferedWriter(osw);
                        //写入文件
                        bw.write("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<head>\n" +
                                "<meta charset=\"UTF - 8\">\n" +
                                "<title>用户信息</title>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "<hr/>\n" +
                                "<br/>\n" +
                                "<h1 align=\"center\" style=\"font - size:30pt\">QuantumCloud汽车租赁系统</h1>\n" +
                                "<hr/>\n" +
                                "<h2 align=\"center\" style=\"font - size:10pt\">导出时间：" + current_date + "</h2>\n" +
                                "<br/>\n" +
                                "<table border=\"1\" align=\"center\" cellpadding=\"8\" cellspacing=\"0\">\n" +
                                "<tr align=\"center\" bgcolor=\"CC0000\">\n" +
                                "<th colspan=\"6\" style=\"color:white\">用户信息表</th>\n" +
                                "<tr/>\n" +
                                "<tr align=\"center\" bgcolor=\"#FAEBD7\">\n" +
                                "    <th rowspan=\"1\">序号</th>\n" +
                                "    <th rowspan=\"1\">用户账号</th>\n" +
                                "    <th rowspan=\"1\">姓名</th>\n" +
                                "    <th rowspan=\"1\">性别</th>\n" +
                                "    <th rowspan=\"1\">租车情况</th>\n" +
                                "    <th rowspan=\"1\">账户余额</th>\n" +
                                "</tr>" + "\t\n");
                        //循环打印用户信息
                        for (int i = 0; i < users.size(); i++) {
                            bw.write("<tr align=\"center\" bgcolor=\"#FAEBD7\">" + "\t\n");
                            bw.write("<th rowspan=\"1\">" + (i + 1) + "</th>" + "\t\n");
                            bw.write("<th rowspan=\"1\">" + users.get(i).getAccount() + "</th>" + "\t\n");
                            bw.write("<th rowspan=\"1\">" + users.get(i).getName() + "</th>" + "\t\n");
                            bw.write("<th rowspan=\"1\">" + users.get(i).getGender() + "</th>" + "\t\n");
                            if (users.get(i).getIs_rent().equals("0")) {
                                bw.write("<th rowspan=\"1\">暂未租车</th>" + "\t\n");
                            } else {
                                bw.write("<th rowspan=\"1\">已租用\"" + users.get(i).getIs_rent() + "\"</th>" + "\t\n");
                            }
                            bw.write("<th rowspan=\"1\">" + users.get(i).getBalance() + "</th>" + "\t\n");
                            bw.write("</tr>" + "\t\n");
                        }

                        bw.write("</table>\n" +
                                "</body>\n" +
                                "</html>" + "\t\n");
                        //先打开的后关闭，后打开的先关闭
                        bw.close();
                        osw.close();
                        fos.close();
                        JOptionPane.showMessageDialog(Administrator, "导出成功！已保存至\n"+file, "导出成功", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(Administrator, "发生一些错误\n导出失败！", "导出失败", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });
        //退出系统
        button_exitSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mysqlTool.close(conn);   //关闭数据库连接
                Administrator.setVisible(false);
                exit(0);
            }
        });

    }

    void RefreshUserInformation(ResourceBundle bundle) {
        String sql_find = "select * from administrator where account = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql_find);
            pstmt.setString(1, account_administrator);
            //执行查询语句
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                name_administrator = res.getString("name");
                gender_administrator = res.getString("gender");

            }
            label_name.setText(bundle.getString("Administrator.label_name.text")+name_administrator);
            label_gender.setText(bundle.getString("Administrator.label_gender.text")+gender_administrator);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void DisplayUserInformation(Connection conn){
        Vector vData = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
        Vector vName = new Vector();
        Vector vRow = null; //数据行向量，使用它的add()添加元素，有几行就new几个行向量。其中的元素就是单元格的内容
        PreparedStatement pstmt_user = null;
        try {
            String sql_find_allUsers = "select * from users";
            pstmt_user = conn.prepareStatement(sql_find_allUsers);
            ResultSet res_user = pstmt_user.executeQuery(sql_find_allUsers);
            while (res_user.next()) {//遍历查找结果
                Users_infor user_temp = new Users_infor(
                        res_user.getString("name"),
                        res_user.getString("gender"),
                        res_user.getString("account"),
                        res_user.getString("is_rent"),
                        res_user.getFloat("balance")
                );
                users.add(user_temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_user);
        }
        vName.add("用户账号");
        vName.add("用户姓名");
        vName.add("用户性别");
        vName.add("租车情况");
        vName.add("账户余额");
        for (int i = 0; i < users.size(); i++) {
            vRow = new Vector();
            vRow.add(users.get(i).getAccount());
            vRow.add(users.get(i).getName());
            vRow.add(users.get(i).getGender());
            if(users.get(i).getIs_rent().equals("0")){
                vRow.add("暂未租用任何车辆");
            }else{
                vRow.add(users.get(i).getIs_rent());
            }
            vRow.add(users.get(i).getBalance());
            vData.add(vRow.clone());
        }
        MyTableModel model = new MyTableModel(vData, vName); //新建一个默认数据模型
        table_users.setModel(model);
        scrollPane2.setViewportView(table_users);
        table_users.setShowHorizontalLines(true);//显示水平线
        table_users.setShowVerticalLines(true); //显示垂直线
    }

    void DisplayVehicles(Connection conn) {
        Vector vData = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
        Vector vName = new Vector();
        Vector vRow = null; //数据行向量，使用它的add()添加元素，有几行就new几个行向量。其中的元素就是单元格的内容

        //加载轿车信息
        List<Car> cars = new ArrayList<>();
        PreparedStatement pstmt_car = null;
        try {
            String sql_find_allCar = "select * from cars";
            pstmt_car = conn.prepareStatement(sql_find_allCar);
            ResultSet res_car = pstmt_car.executeQuery(sql_find_allCar);
            while (res_car.next()) {//遍历查找结果
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_car);
        }

        //加载客车信息
        List<Bus> buses = new ArrayList<>();
        PreparedStatement pstmt_bus = null;
        try {
            String sql_find_allBus = "select * from buses";
            pstmt_bus = conn.prepareStatement(sql_find_allBus);
            ResultSet res_bus = pstmt_bus.executeQuery(sql_find_allBus);
            while (res_bus.next()) {//遍历查找结果
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_bus);
        }

        //加载货车信息
        List<Truck> trucks = new ArrayList<>();
        PreparedStatement pstmt_truck = null;
        try {
            String sql_find_allTruck = "select * from trucks";
            pstmt_truck = conn.prepareStatement(sql_find_allTruck);
            ResultSet res_truck = pstmt_truck.executeQuery(sql_find_allTruck);
            while (res_truck.next()) {//遍历查找结果
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mysqlTool.close(pstmt_truck);
        }

        vName.add("汽车类型");
        vName.add("车牌号");
        vName.add("汽车品牌");
        vName.add("汽车型号");
        vName.add("每日租金");
        vName.add("租用情况");
        vName.add("租用时间");

        //添加轿车信息
        for (int i = 0; i < cars.size(); i++) {
            vRow = new Vector();
            vRow.add("轿车");
            vRow.add(cars.get(i).getPlateNumber());
            vRow.add(cars.get(i).getBrand());
            vRow.add(cars.get(i).getType());
            vRow.add(cars.get(i).getPerRent());
            if(cars.get(i).flag.equals("1")){
                vRow.add("暂未租出");
            }else{
                vRow.add("已被\""+cars.get(i).flag+"\"租用");
            }
            if(cars.get(i).getDate().equals("0")){
                vRow.add("暂无");
            }else {
                vRow.add(cars.get(i).getDate());
            }
            vData.add(vRow.clone());
        }

        //添加客车信息
        for (int i = 0; i < buses.size(); i++) {
            vRow = new Vector();
            vRow.add("客车");
            vRow.add(buses.get(i).getPlateNumber());
            vRow.add(buses.get(i).getBrand());
            vRow.add(buses.get(i).getSeat()+"座");
            vRow.add(buses.get(i).getPerRent());
            if(buses.get(i).flag.equals("1")){
                vRow.add("暂未租出");
            }else{
                vRow.add("已被\""+buses.get(i).flag+"\"租用");
            }
            if(buses.get(i).getDate().equals("0")){
                vRow.add("暂无");
            }else {
                vRow.add(buses.get(i).getDate());
            }
            vData.add(vRow.clone());
        }
        //添加货车信息
        for (int i = 0; i < trucks.size(); i++) {
            vRow = new Vector();
            vRow.add("货车");
            vRow.add(trucks.get(i).getPlateNumber());
            vRow.add(trucks.get(i).getBrand());
            vRow.add(trucks.get(i).getTon()+"吨");
            vRow.add(trucks.get(i).getPerRent());
            if(trucks.get(i).flag.equals("1")){
                vRow.add("暂未租出");
            }else{
                vRow.add("已被\""+trucks.get(i).flag+"\"租用");
            }
            if(trucks.get(i).getDate().equals("0")){
                vRow.add("暂无");
            }else {
                vRow.add(trucks.get(i).getDate());
            }
            vData.add(vRow.clone());
        }

        MyTableModel model = new MyTableModel(vData, vName); //新建一个默认数据模型
        table_garage.setModel(model);
        scrollPane1.setViewportView(table_garage);
        table_garage.setShowHorizontalLines(true);//显示水平线
        table_garage.setShowVerticalLines(true); //显示垂直线
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame Administrator;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JSplitPane splitPane2;
    private JLabel label_name;
    private JSplitPane splitPane3;
    private JLabel label_gender;
    private JSplitPane splitPane4;
    private JButton button_addCar;
    private JSplitPane splitPane5;
    private JButton button_reviseCar;
    private JSplitPane splitPane6;
    private JButton button_findCar;
    private JSplitPane splitPane7;
    private JButton button_removeCar;
    private JSplitPane splitPane8;
    private JLabel label1;
    private JSplitPane splitPane9;
    private JButton button_turnover;
    private JSplitPane splitPane10;
    private JButton button_exportInformation;
    private JSplitPane splitPane11;
    private JButton button_exitSystem;
    private JTextField textField1;
    private JTabbedPane Menu;
    private JScrollPane scrollPane1;
    private JTable table_garage;
    private JScrollPane scrollPane2;
    private JTable table_users;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}

class Users_infor{
    private String name;
    private String gender;
    private String account;
    private String is_rent;
    private float balance;

    public Users_infor(String name, String gender, String account, String is_rent, float balance) {
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.is_rent = is_rent;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIs_rent() {
        return is_rent;
    }

    public void setIs_rent(String is_rent) {
        this.is_rent = is_rent;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
