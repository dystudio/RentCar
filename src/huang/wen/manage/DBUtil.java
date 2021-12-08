/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.manage;

import javax.swing.*;
import java.sql.*;

import static java.lang.System.exit;

//数据库操作类
public class DBUtil {
    public Connection getConnection() {
        Connection conn = null;
        try {
            //初始化驱动类com.mysql.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rentcar?characterEncoding=UTF-8",
                    "root",
                    "2520282");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "未能成功加载数据库驱动！请检查：\n1.是否安装相应驱动\n2.驱动依赖是否加载到项目中", "数据库出错", JOptionPane.ERROR_MESSAGE);
            exit(0);
        }
        return conn;
    }

    /**
     * 封装两个关闭方法
     */
    public void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
