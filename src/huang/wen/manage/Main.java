/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.manage;

import com.formdev.flatlaf.FlatDarculaLaf;
import huang.wen.other.Welcome;
import javax.swing.*;

import static java.lang.System.exit;

//主类
public class Main {
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());//暗主题
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "未能成功初始化可视化界面！请检查：\n1.是否安装相应Jar包\n2.相应包是否加载到项目中", "界面加载失败", JOptionPane.ERROR_MESSAGE);
            exit(0);
        }

        try {
            new Welcome();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
