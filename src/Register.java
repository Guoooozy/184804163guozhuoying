import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 9:54
 * 注册界面
 */
public class Register extends JFrame implements ActionListener {
    JButton jb1, jb2;  //按钮
    JLabel jlb1, jlb2, jlb3,jlb4,jlb5, jlb6;  //标签
    JTextField jtf1,jtf2,jtf3,jtf4, jtf5;   //文本框
    JPasswordField jpf; //密码框
    JPanel jp1,jp2,jp3, jp4,jp5,jp6,jp7;        //面板

    public Register() {
        //按钮
        jb1 = new JButton("确定");
        jb2 = new JButton("重置");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        //标签信息

        jlb1 = new JLabel("        姓名");
        jlb2 = new JLabel("身份证号");
        jlb3 = new JLabel("        账号");
        jlb4 = new JLabel("        密码");
        jlb6 = new JLabel("注册信息");
        jlb5 = new JLabel("开户金额");

        jlb6.setFont(new   java.awt.Font("Dialog",   1,   20));   //设置字体类型，加粗，大小为20
        //文本信息
        jtf1 = new JTextField(13);
        jtf2 = new JTextField(13);
        jtf3 = new JTextField(13);
        jtf4 = new JTextField(13);
        jtf5 = new JTextField(13);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        //将对应信息加入面板中
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jlb4);
        jp4.add(jtf4);

        jp5.add(jlb5);
        jp5.add(jtf5);

        jp6.add(jb1);
        jp6.add(jb2);

        jp7.add(jlb6);

        //将JPane加入JFrame中
        this.add(jp7);  //先加入提示语

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);

        //设置布局
        this.setTitle("注册信息");
        this.setLayout(new GridLayout(7, 1));
        this.setSize(350, 350);   //设置窗体大小
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
                register();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getActionCommand()=="重置")
        {
            clear();
        }

    }
    //验证注册信息，并做处理
    public void register() throws IOException
    {
        //判断信息是否补全
        if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty()|| jtf3.getText().isEmpty()||jtf4.getText().isEmpty()||jtf5.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "信息有空缺，请补全！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        //判断身份证号是否为18位
        else if (jtf2.getText().length()!=18)
        {
            JOptionPane.showMessageDialog(null, "非法身份证号，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        //判断金额是否合法
        else if (!new Check().checkmoney(jtf5.getText()))
        {
            JOptionPane.showMessageDialog(null, "存入金额不合法!","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        //判断账户名和密码是否全英文
        else if (new Check().checkcountname(jtf3.getText())||new Check().checkcountname(jtf4.getText()))
        {
            JOptionPane.showMessageDialog(null, "用户名或密码只能是英文字母，不合法!","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        //满足要求
        else if (!jtf1.getText().isEmpty()&&!jtf2.getText().isEmpty()&& !jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty()&&!jtf5.getText().isEmpty())
        {
            //注册成功， 打包为信息数组传递给UserMessage进行更新操作
            String []message = new String[5];
            message[0] = jtf1.getText();   //获取输入的文本信息
            message[1] = jtf2.getText();
            message[2] = jtf3.getText();
            message[3] = jtf4.getText();
            message[4] = jtf5.getText();
            if (!new Check().check2(message[2]))   //调用Check的check2方法检测用户是否存在， 如果不存在执行
            {
                new UserMessage().write(message);   //调用UserMseeage的write方法进行写操作
                JOptionPane.showMessageDialog(null,"注册成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                dispose();  //使窗口消失
            }
            else
            {
                JOptionPane.showMessageDialog(null,"账号已存在，请重新输入！","提示消息",JOptionPane.WARNING_MESSAGE);
                //dispose();
            }
        }
    }

    //清空账号和密码框
    private void clear() {
        jtf1.setText("");    //设置为空
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf5.setText("");

    }

}
