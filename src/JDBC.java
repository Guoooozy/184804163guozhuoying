import com.sun.source.tree.WhileLoopTree;

import java.awt.geom.FlatteningPathIterator;
import java.sql.*;

/**
 * @author Guoooozy
 * @date 2019/12/11 - 11:51
 * 数据库增删改查
 */
public class JDBC {
    public Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://49.234.72.114:3306/gzy?&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "gzy112480..";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void insert(String[] message)//增加用户
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into bank (name,id,acc,pwd,money) values(?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            String s1, s2, s3, s4, s5;
            s1 = message[0];
            s2 = message[1];
            s3 = message[2];
            s4 = message[3];
            s5 = message[4];
            pstmt.setString(1, s1);
            pstmt.setString(2, s2);
            pstmt.setString(3, s3);
            pstmt.setString(4, s4);
            pstmt.setString(5, s5);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(String money,String acc) //更新用户信息
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "update bank set money=? where acc=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,money);
            pstmt.setString(2,acc);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

/*
    public String[] select(String which, String ret)//查询某个参数的某个值
    {
        Connection conn = getConn();
        String sql = "SELECT * from bank WHERE ?=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[] message = new String[8];
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,which);
            pstmt.setString(2,ret);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                message[0] = rs.getString(1);
                message[1] = rs.getString(2);
                message[2] = rs.getString(3);
                message[3] = rs.getString(4);
                message[4] = rs.getString(5);
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }
*/
    public String select1( String ret)//返回密码
    {
        Connection conn = getConn();
        String sql = "SELECT * from bank WHERE acc=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String s=" ";
        //String[] message = new String[8];
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,ret);
            //pstmt.setString(2,ret);
            rs = (ResultSet) pstmt.executeQuery();
            if(rs.next())
                return rs.getString(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }


    public boolean select2( String ret)//查询某个参数的某个值
    {
        Connection conn = getConn();
        String sql = "SELECT * from bank WHERE acc=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //String[] message = new String[8];
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,ret);
            //pstmt.setString(2,ret);
            rs = (ResultSet) pstmt.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String select3( String acc)//返回钱
    {
        Connection conn = getConn();
        String sql = "SELECT * from bank WHERE acc=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String s=" ";
        //String[] message = new String[8];
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,acc);
            //pstmt.setString(2,ret);
            rs = (ResultSet) pstmt.executeQuery();
            if(rs.next())
                return rs.getString(5);//返回钱
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}


