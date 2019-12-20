import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 8:34
 * 开始界面
 */
public class Menu extends JFrame implements ActionListener {
    JButton jlog,jreg;//登录和注册按钮
    JLabel jb1;
    public Menu(){
        jlog=new JButton("登录");
        jreg=new JButton("注册");
        jb1=new JLabel("欢迎光临网上银行");
        jb1.setFont(new java.awt.Font("Dialog",1,23));

        //添加事件监听
        jlog.addActionListener(this);
        jreg.addActionListener(this);

        this.setTitle("网上银行");//标题
        this.setSize(500,500);//设置大小
        this.setLocation(400,200);//设置位置
        this.setLayout(null);//设置卡片布局

        //设置位置和大小

        jlog.setBounds(100,270,90,60);
        jreg.setBounds(300,270,90,60);
        jb1.setBounds(150,150,200,50);

        //添加按钮
        this.add(jlog);
        this.add(jreg);
        this.add(jb1);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置可关闭
        this.setVisible(true);//设置可见
        this.setResizable(false);//设置不可拉伸
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="登录")
        {
            new login();
            this.setVisible(false);//设置不可见
        }
        else if(e.getActionCommand()=="注册")
        {
            new Register();
            //this.setVisible(false);//设置不可见
        }
    }
}
