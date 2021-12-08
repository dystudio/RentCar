/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.cars;

import huang.wen.manage.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Truck extends MotoVehicle {
    float tonnage; //货物重量

    public Truck(String flag,String vehicleId, String brand, float tonnage,float rent,String date) {
        super(vehicleId, brand, rent, flag, date);
        this.tonnage = tonnage;
    }

    public Truck() {
    }

    public double getTon() {
        return tonnage;
    }

    public void setTon(float ton) {
        this.tonnage = ton;
    }

    //新增车辆
    @Override
    public void AddProcess(JFrame Administrator) {
        setFlag("1");
        String str_1 = JOptionPane.showInputDialog(Administrator, "请输入该货车的车牌号", "新增车辆——车牌号", JOptionPane.PLAIN_MESSAGE);
        if (str_1 instanceof String) {
            setPlateNumber(str_1);
            String str_2 = JOptionPane.showInputDialog(Administrator, "请输入该货车的品牌", "新增车辆——品牌", JOptionPane.PLAIN_MESSAGE);
            if (str_2 instanceof String) {
                setBrand(str_2);
                String str_3 = JOptionPane.showInputDialog(Administrator, "请输入该货车的吨位", "新增车辆——载重量", JOptionPane.PLAIN_MESSAGE);
                if(str_3 instanceof String){
                    setTon(Integer.parseInt(str_3));
                    String str_4 = JOptionPane.showInputDialog(Administrator, "请输入该货车的每日租金", "新增车辆——日租金", JOptionPane.PLAIN_MESSAGE);
                    if(str_4 instanceof String){
                        setPerRent(Integer.parseInt(str_4));
                        setDate("0");
                        Object[] options = {"确定", "取消"};
                        int temp = JOptionPane.showOptionDialog(Administrator, "确定添加如下车辆吗？\n车牌号：" + str_1 + "\n汽车品牌：" + str_2 + "\n汽车载重量：" + str_3 + "\n汽车日租金：" + str_4, "添加确认", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (temp == 0) {
                            String sql = "insert into trucks(flag, vehicleId, brand, seat, rent, date) values(?, ?, ?, ?, ?, ?)";
                            DBUtil mysqlTool = new DBUtil();
                            Connection conn = mysqlTool.getConnection();
                            PreparedStatement pstmt = null;
                            try {
                                pstmt = conn.prepareStatement(sql);
                                pstmt.setString(1, getFlag());
                                pstmt.setString(2, getPlateNumber());
                                pstmt.setString(3, getBrand());
                                pstmt.setFloat(4, (float) getTon());
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
        if (days > 7 && days <= 30) {
            rent = (float) (rent * days * 0.9);
        } else if (days > 30 && days <= 150) {
            rent = (float) (rent * days * 0.7);
        } else if (days > 150) {
            rent = (float) (rent * days * 0.5);
        } else {
            rent = rent * days;
        }
        setPerRent(rent);
    }
}
