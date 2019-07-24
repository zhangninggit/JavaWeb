package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {

    /**
     * user表 添加一条记录
     * @param args
     */
    public static void main(String[] args) {
        // 1.注册数据库驱动

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.108:3306/day14", "dabiao", "123456");

            // 3. 定义SQL语句
            String sql = "insert into user values(0,'张宁','666')";

            // 4. 获取执行sql语句的对象
            stmt = conn.createStatement();

            // 5. 执行sql
            int i = stmt.executeUpdate(sql);

            // 6. 处理结果
            System.out.println(i);
            if (i > 0) {
                System.out.println("添加成功！");
            }else {
                System.out.println("添加失败！");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 7. 关闭资源
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
