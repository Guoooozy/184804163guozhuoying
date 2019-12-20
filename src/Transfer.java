import com.mysql.cj.util.Base64Decoder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 16:26
 * 转钱界面
 */
public class Transfer extends JFrame implements ActionListener {
    JButton jsure,jcan,jre;
    JPanel jp1,jp2,jp3;
    JTextField jtf1,jtf2;
    JLabel jlb1, jlb2;
    public String order;
    public Transfer(String order)
    {
        this.order=order;
        jsure=new JButton("确定");
        jcan=new JButton("重置");

        jsure.addActionListener(this);
        jcan.addActionListener(this);

        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("金额");  //添加标签
        jlb2 = new JLabel("转给");


        jtf1 = new JTextField(10);//文本框
        jtf2 = new JTextField(10);//文本框
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp3.add(jlb2);
        jp3.add(jtf2);

        jp2.add(jp1);
        jp2.add(jsure);
        jp2.add(jcan);

        this.add(jp1);
        this.add(jp3);
        this.add(jp2);

        this.setTitle("转钱");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="确定")
        {
            try {
                sure();
            } catch (HeadlessException | IOException e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getActionCommand()=="重置")
        {
            clear();
        }
    }
    //清空账号和密码框
    private void clear() {
        jtf1.setText("");    //设置为空
        jtf2.setText("");
    }
    public void sure() throws HeadlessException, IOException
    {
        int number1=Integer.valueOf(jtf1.getText());//送的钱
        int number2=Integer.valueOf(new UserMessage().findmoney(this.order));//自己本来的钱
        int number3=Integer.valueOf(new UserMessage().findmoney(jtf2.getText()));//对方账户的钱
        Integer number4=number2-number1;
        Integer number5=number3+number1;
        if(number1<0)
        {
            JOptionPane.showMessageDialog(null,"不能是负数！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(number2<0)
        {
            JOptionPane.showMessageDialog(null,"你没钱了，无法转！","提示消息",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            UserMessage userMessage=new UserMessage();
            userMessage.writemoney(this.order,number4.toString());
            userMessage.writemoney(jtf2.getText(),number5.toString());
            JOptionPane.showMessageDialog(null,"转账成功！","提示消息",JOptionPane.WARNING_MESSAGE);
        }

    }
}


