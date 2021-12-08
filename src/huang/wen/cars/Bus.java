package huang.wen.cars;

import huang.wen.manage.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bus extends MotoVehicle {
    private int seat;         //座位数量
    public Bus(String flag,String vehicleId, String brand, int seat,float rent,String date) {
        super(vehicleId, brand, rent, flag,date);
        setSeat(seat);
    }

    public Bus() {
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    //新增车辆
    @Override
    public void AddProcess(JFrame Administrator) {
        setFlag("1");
        String str_1 = JOptionPane.showInputDialog(Administrator, "请输入该客车的车牌号", "新增车辆——车牌号", JOptionPane.PLAIN_MESSAGE);
        if (str_1 instanceof String) {
            setPlateNumber(str_1);
            String str_2 = JOptionPane.showInputDialog(Administrator, "请输入该客车的品牌", "新增车辆——品牌", JOptionPane.PLAIN_MESSAGE);
            if (str_2 instanceof String) {
                setBrand(str_2);
                String str_3 = JOptionPane.showInputDialog(Administrator, "请输入该客车的座位数", "新增车辆——载客量", JOptionPane.PLAIN_MESSAGE);
                if (str_3 instanceof String) {
                    setSeat(Integer.parseInt(str_3));
                    String str_4 = JOptionPane.showInputDialog(Administrator, "请输入该客车的每日租金", "新增车辆——日租金", JOptionPane.PLAIN_MESSAGE);
                    if (str_4 instanceof String) {
                        setPerRent(Integer.parseInt(str_4));
                        setDate("0");
                        Object[] options = {"确定", "取消"};
                        int temp = JOptionPane.showOptionDialog(Administrator, "确定添加如下车辆吗？\n车牌号：" + str_1 + "\n汽车品牌：" + str_2 + "\n汽车载客量：" + str_3 + "\n汽车日租金：" + str_4, "添加确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (temp == 0) {
                            String sql = "insert into buses(flag, vehicleId, brand, seat, rent, date) values(?, ?, ?, ?, ?, ?)";
                            DBUtil mysqlTool = new DBUtil();
                            Connection conn = mysqlTool.getConnection();
                            PreparedStatement pstmt = null;
                            try {
                                pstmt = conn.prepareStatement(sql);
                                pstmt.setString(1, getFlag());
                                pstmt.setString(2, getPlateNumber());
                                pstmt.setString(3, getBrand());
                                pstmt.setInt(4, getSeat());
                                pstmt.setFloat(5, getPerRent());
                                pstmt.setString(6, getDate());
                                pstmt.executeUpdate();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                mysqlTool.close(pstmt);
                                mysqlTool.close(conn);
                                JOptionPane.showMessageDialog(Administrator, "成功新增车辆信息!", "添加成功", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
            }
        }
    }

    //计算租金
    @Override
    public void calRent(int days) {
            float rent = getPerRent();
            if (days >= 3 && days < 7) {
                rent = (float) (rent * days * 0.9);
            } else if (days >= 7 && days < 30) {
                rent = (float) (rent * days * 0.8);
            } else if (days >= 30 && days < 150) {
                rent = (float) (rent * days * 0.7);

            } else if (days >= 150) {
                rent = (float) (rent * days * 0.6);
            } else {
                rent = rent * days;
            }
            setPerRent(rent);
    }
}