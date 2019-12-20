import com.sun.source.tree.TryTree;

import java.sql.*;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 8:42
 * 包装用户类
 */
public class UserMessage {
    public void write(String [] message)//增加用户
    {
        JDBC jdbc=new JDBC();
        jdbc.insert(message);
    }
    public boolean find2(String ret)//查找函数
    {
        JDBC jdbc=new JDBC();
        return jdbc.select2(ret);
    }
    public  String find1(String ret)
    {
        JDBC jdbc=new JDBC();
        return jdbc.select1(ret);
    }
    public String findmoney(String acc)
    {
        JDBC jdbc=new JDBC();
        return jdbc.select3(acc);
    }
    public void writemoney(String acc,String money)
    {
        JDBC jdbc=new JDBC();
        jdbc.update(money,acc);
    }

}
