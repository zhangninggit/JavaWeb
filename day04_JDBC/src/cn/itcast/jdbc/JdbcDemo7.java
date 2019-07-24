package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * * 练习：
 * 		* 需求：
 * 			1. 通过键盘录入用户名和密码
 * 			2. 判断用户是否登录成功
 */
public class JdbcDemo7 {

    /**
     * 登录方法
     *
     */

    public boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }

        if (username != null && password != null){
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                // 链接数据库判断是否登录成功
                // 1. 获取连接
                conn = JDBCUtils.getConnection();

                // 2. 定义sql语句
                //  String sql = "select * from user where username='+"username"+ ' and password='+"password"+'";
                String sql =  "select * from USER where username = '"+username+"' and password = '"+password+"' ";
                String sql2 = "select * from USER where username = '"+username+"' and password = '"+password+"' ";
                // 3. 获取执行sql语句对象
                stmt = conn.createStatement();
                // 4. 执行sqlzhangsan
                rs = stmt.executeQuery(sql2);

                // 5.处理数据
                // int i = rs.getFetchSize();
                if(rs.next()){
                   // System.out.println("登陆成功！");
                    return true;
                }else
                {
                   // System.out.println("登录失败！");
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(rs,stmt,conn);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String name;
        String password;
        Scanner sc =new Scanner(System.in);
        System.out.println("输入用户名:");
        name = sc.nextLine();
        System.out.println("输入密码:");
        password = sc.nextLine();

        boolean flag = new JdbcDemo7().login(name, password);
        if(flag){
            System.out.println("登陆成功！");
        }else{
            System.out.println("登录失败！");
        }

    }
}
