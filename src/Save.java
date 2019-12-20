import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 16:25
 * 存钱界面
 */
public class Save extends JFrame implements ActionListener {
    JButton jsure,jcan,jre;
    JPanel jp1,jp2,jp3;
    JTextField jtf;
    JLabel jlb1, jlb2;
    public String order;
    public Save(String order)
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

        jtf = new JTextField(10);//文本框
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jp1);
        jp2.add(jsure);
        jp2.add(jcan);
        this.add(jp1);
        //this.add(jp2);
        this.add(jp2);

        this.setTitle("存钱");
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
        jtf.setText("");    //设置为空
    }
    public void sure() throws HeadlessException, IOException
    {
        if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "金额为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if(new Check().checkmoney(jtf.getText()))
        {

            UserMessage userMessage=new UserMessage();
            int  number1  = Integer.valueOf(jtf.getText());
            int number2=Integer.valueOf(new UserMessage().findmoney(this.order));
            Integer number3=number1+number2;
            userMessage.writemoney(this.order,number3.toString());
            JOptionPane.showMessageDialog(null,"存钱成功！","提示消息",JOptionPane.WARNING_MESSAGE);
        }
    }
}
