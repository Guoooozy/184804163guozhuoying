import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 16:26
 * 显示余额界面
 */
public class Show extends JFrame {
    JButton jsure, jcan, jre;
    JPanel jp1, jp2, jp3;
    JTextField jtf;
    JLabel jlb1, jlb2;
    public String order;

    public Show(String order) {
        this.order = order;
        String s=new UserMessage().findmoney(this.order);
        jlb1=new JLabel(s);
        jlb1.setFont(new java.awt.Font("Dialog",1,23));
        jlb1.setBounds(100,100,200,50);

        this.add(jlb1);
        this.setTitle("你的余额：");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
    }
}
