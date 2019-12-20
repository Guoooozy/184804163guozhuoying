import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 15:49
 * 该类是登录成功之后的frame
 */
public class AfterLogin extends JFrame implements ActionListener {
    JButton jcun,jyu,jcatch,jtrans,jout;//存，余额，取，转，退出
    JLabel jLabel;
    public String order;
    public AfterLogin(String order)
    {
        this.order=order;
        jcun=new JButton("存钱");
        jyu=new JButton("余额");
        jcatch=new JButton("取钱");
        jtrans=new JButton("转账");
        jout=new JButton("退出");

        //设置监听
        jcun.addActionListener(this);
        jout.addActionListener(this);
        jtrans.addActionListener(this);
        jcatch.addActionListener(this);
        jyu.addActionListener(this);

        jLabel=new JLabel("您好，欢迎使用网上银行系统");
        jLabel.setFont(new java.awt.Font("Dialog",1,23));

        this.setTitle("网上银行");//标题
        this.setSize(510,500);//设置大小
        this.setLocation(400,200);//设置位置
        this.setLayout(null);

        jcun.setBounds(10,270,80,60);
        jcatch.setBounds(110,270,80,60);
        jtrans.setBounds(210,270,80,60);
        jyu.setBounds(310,270,80,60);
        jout.setBounds(410,270,80,60);
        jLabel.setBounds(100,120,300,50);


        this.add(jcatch);
        this.add(jcun);
        this.add(jLabel);
        this.add(jout);
        this.add(jtrans);
        this.add(jyu);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置可关闭
        this.setVisible(true);//设置可见
        this.setResizable(false);//设置不可拉伸
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="存钱")
        {
            new Save(this.order);
            //this.setVisible(false);//设置不可见
        }
        else if(e.getActionCommand()=="取钱")
        {
            new Catch(this.order);
            //this.setVisible(false);//设置不可见
        }
        else if(e.getActionCommand()=="转账")
        {
            new Transfer(this.order);
        }
        else if(e.getActionCommand()=="余额")
        {
            new Show(this.order);
        }
        else
        {
            System.exit(0);
        }
    }
}
