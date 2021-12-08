/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.manage;

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
import javax.swing.*;


public class Turnover {
    String account_administration;

    public Turnover(String account) {
        this.account_administration=account;
        initComponents();
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    DBUtil mysqlTool = new DBUtil();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("configuration.ConfigurationFile");
        Turnover = new JFrame("营业额");
        panel1 = new JPanel();
        splitPane1 = new JSplitPane();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        splitPane2 = new JSplitPane();
        splitPane3 = new JSplitPane();
        button1 = new JButton();
        button2 = new JButton();
        textField1 = new JTextField();

        //======== Turnover ========
        {
            Turnover.setMinimumSize(new Dimension(750, 500));
            Turnover.setVisible(true);
            Turnover.setResizable(false);
            Turnover.setIconImage(new ImageIcon(getClass().getResource("/huang/wen/source/logo_white.png")).getImage());
            Turnover.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            var TurnoverContentPane = Turnover.getContentPane();
            TurnoverContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setMinimumSize(new Dimension(750, 500));
                panel1.setPreferredSize(new Dimension(750, 500));
                panel1.setLayout(new BorderLayout());

                //======== splitPane1 ========
                {
                    splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    splitPane1.setDividerLocation(420);
                    //======== scrollPane1 ========
                    {
                        scrollPane1.setMinimumSize(new Dimension(16, 200));

                        //---- table1 ----
                        table1.setPreferredSize(new Dimension(750, 500));
                        table1.setMaximumSize(new Dimension(750, 500));
                        table1.setMinimumSize(new Dimension(30, 400));
                        scrollPane1.setViewportView(table1);
                    }
                    splitPane1.setTopComponent(scrollPane1);

                    //======== splitPane2 ========
                    {

                        //======== splitPane3 ========
                        {
                            splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);

                            //---- button1 ----
                            button1.setText(bundle.getString("Turnover.button1.text"));
                            button1.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/Export.png")));
                            button1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 18));
                            splitPane3.setTopComponent(button1);

                            //---- button2 ----
                            button2.setText(bundle.getString("Turnover.button2.text"));
                            button2.setIcon(new ImageIcon(getClass().getResource("/huang/wen/source/return.png")));
                            button2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 18));
                            button2.setMaximumSize(new Dimension(95, 36));
                            button2.setMinimumSize(new Dimension(95, 36));
                            button2.setPreferredSize(new Dimension(95, 36));
                            splitPane3.setBottomComponent(button2);
                        }
                        splitPane2.setLeftComponent(splitPane3);

                        //---- textField1 ----
                        textField1.setText(bundle.getString("Turnover.textField1.text"));
                        textField1.setEditable(false);
                        textField1.setEnabled(false);
                        textField1.setFont(new Font("\u534e\u5149\u6977\u4f53_CNKI", Font.BOLD, 28));
                        textField1.setMaximumSize(new Dimension(1000, 72));
                        textField1.setMinimumSize(new Dimension(49, 72));
                        textField1.setPreferredSize(new Dimension(163, 72));
                        textField1.setDisabledTextColor(new Color(102, 255, 0));
                        splitPane2.setRightComponent(textField1);
                    }
                    splitPane1.setBottomComponent(splitPane2);
                }
                panel1.add(splitPane1, BorderLayout.CENTER);
            }
            TurnoverContentPane.add(panel1, BorderLayout.CENTER);
            Turnover.pack();
            Turnover.setLocationRelativeTo(Turnover.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //刷新
        refresh();
        //导出
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String current_date = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); //时间戳转化为时间

                //选择文件保存路径
                File file = null;
                JFileChooser fileChooser = new JFileChooser(".\\"); //默认保存位置
                // 设置打开文件选择框后默认输入的文件名
                fileChooser.setSelectedFile(new File("营业额账单.html"));
                // 打开文件选择框
                int result = fileChooser.showSaveDialog(Turnover);
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
                                "<title>营业额</title>\n" +
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
                                "<th colspan=\"6\" style=\"color:white\">营业额账单</th>\n" +
                                "<tr/>\n" +
                                "<tr align=\"center\" bgcolor=\"#FAEBD7\">\n" +
                                "    <th rowspan=\"1\">序号</th>\n" +
                                "    <th rowspan=\"1\">日期</th>\n" +
                                "    <th rowspan=\"1\">车牌号</th>\n" +
                                "    <th rowspan=\"1\">租用天数</th>\n" +
                                "    <th rowspan=\"1\">租金</th>\n" +
                                "</tr>" + "\t\n");
                        //循环打印用户信息
                        try {
                            String sql = "select * from income";
                            pstmt = conn.prepareStatement(sql);
                            ResultSet res = pstmt.executeQuery(sql);
                            int i = 0;
                            while (res.next()) {//遍历查找结果
                                i++;
                                bw.write("<tr align=\"center\" bgcolor=\"#FAEBD7\">" + "\t\n");
                                bw.write("<th rowspan=\"1\">" + i + "</th>" + "\t\n");
                                bw.write("<th rowspan=\"1\">" + res.getString("time") + "</th>" + "\t\n");
                                bw.write("<th rowspan=\"1\">" + res.getString("vehicleId") + "</th>" + "\t\n");
                                bw.write("<th rowspan=\"1\">" + res.getInt("days") + "</th>" + "\t\n");
                                bw.write("<th rowspan=\"1\">" + res.getFloat("amount") + "</th>" + "\t\n");
                                bw.write("</tr>" + "\t\n");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            mysqlTool.close(pstmt);
                        }
                        bw.write("</table>\n" +
                                "</body>\n" +
                                "</html>" + "\t\n");
                        //先打开的后关闭，后打开的先关闭
                        bw.close();
                        osw.close();
                        fos.close();
                        JOptionPane.showMessageDialog(Turnover, "导出成功！已保存至\n"+file, "导出成功", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(Turnover, "发生一些错误\n导出失败！", "导出失败", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });
        //返回上一级
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Turnover.dispose();
                try {
                    new Administrator(account_administration);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    void refresh() {
        String sql_1 = "select * from other_data where number = ?";

        try {
            conn = mysqlTool.getConnection();
            pstmt = conn.prepareStatement(sql_1);
            pstmt.setInt(1, 1);
            //执行查询语句
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                textField1.setText("总营业额："+res.getFloat("money"));
            } else {
                textField1.setText("总营业额：暂未查询到数据，请联系管理员");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            mysqlTool.close(pstmt);
        }

        Vector vData = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
        Vector vName = new Vector();
        Vector vRow = null; //数据行向量，使用它的add()添加元素，有几行就new几个行向量。其中的元素就是单元格的内容

        vName.add("序号");
        vName.add("日期");
        vName.add("车牌号");
        vName.add("租用天数");
        vName.add("租金");

        try {
            String sql = "select * from income";
            pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery(sql);
            int i = 0;
            while (res.next()) {//遍历查找结果
                i++;
                vRow = new Vector();
                vRow.add(i);
                vRow.add(res.getString("time"));
                vRow.add(res.getString("vehicleId"));
                vRow.add(res.getInt("days"));
                vRow.add(res.getFloat("amount"));
                vData.add(vRow.clone());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlTool.close(pstmt);
        }

        MyTableModel model = new MyTableModel(vData, vName); //新建一个默认数据模型
        table1.setModel(model);
        scrollPane1.setViewportView(table1);
        table1.setShowHorizontalLines(true);//显示水平线
        table1.setShowVerticalLines(true); //显示垂直线
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame Turnover;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JSplitPane splitPane2;
    private JSplitPane splitPane3;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
