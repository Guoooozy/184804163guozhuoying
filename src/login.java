import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 9:10
 * 登录界面
 */
public class login  extends JFrame implements ActionListener {
    JButton jb1, jb2;  //按钮
    JPanel jp1,jp2,jp3;        //面板
    JTextField jtf;   //文本框
    JLabel jlb1, jlb2; //标签
    JPasswordField jpf; //密码框

    String name = "123";   //账号密码
    String pwd = "123";

    public login() {
        jb1 = new JButton("登录");
        jb2 = new JButton("重置");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("用户名");  //添加标签
        jlb2 = new JLabel("  密  码");

        jtf = new JTextField(10);   //创建文本框和密码框
        jpf = new JPasswordField(10);

        //加入面板中
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jb1);
        jp3.add(jb2);

        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        //设置布局
        this.setTitle("用户登录");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="登录")
        {
            try {
                login();
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
        jtf.setText("");    //设置为空
        jpf.setText("");

    }

    //验证登录信息，并做处理
    public void login() throws HeadlessException, IOException
    {
        if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "账号密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "账号为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);

        }
        else if (new Check().check1(jtf.getText(),jpf.getText()))
        {
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            dispose();  //使文原窗体消失

            AfterLogin afterLogin=new AfterLogin(jtf.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "账号密码错误请重新输入！","消息提示",JOptionPane.ERROR_MESSAGE);
            clear();  //调用清除函数
        }
    }


}
