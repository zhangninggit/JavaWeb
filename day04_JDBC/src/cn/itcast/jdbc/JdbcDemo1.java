package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {

    /**
     *          //1. 导入驱动jar包
     * 	        //2.注册驱动
     * 	        Class.forName("com.mysql.jdbc.Driver");
     * 	        //3.获取数据库连接对象
     * 	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
     * 	        //4.定义sql语句
     * 	        String sql = "update account set balance = 500 where id = 1";
     * 	        //5.获取执行sql的对象 Statement
     * 	        Statement stmt = conn.createStatement();
     * 	        //6.执行sql
     * 	        int count = stmt.executeUpdate(sql);
     * 	        //7.处理结果
     * 	        System.out.println(count);
     * 	        //8.释放资源
     * 	        stmt.close();
     * 	        conn.close();
     */

    public static void main(String[] args) throws Exception {
        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

         //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.108:3306/day14", "dabiao", "123456");

        //4.定义sql语句
        String sql = "update user set password = 234 where id = 1";

        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //6.执行sql
        int i = stmt.executeUpdate(sql);

        //7.处理结果
        System.out.println(i);

        // 释放资源
        stmt.close();
        conn.close();


    }


}
