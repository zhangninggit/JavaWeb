package cn.itcast.jdbc;

import java.sql.*;

/**
 *  ResultSet：结果集对象,封装查询结果
 * 		* boolean next(): 游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，如果是，则返回false，如果不是则返回true
 * 		* getXxx(参数):获取数据
 * 			* Xxx：代表数据类型   如： int getInt() ,	String getString()
 * 				* 参数：
 * 					1. int：代表列的编号,从1开始   如： getString(1)
 * 					2. String：代表列名称。 如： getDouble("balance")
 *
 * 		* 注意：
 * 			* 使用步骤：
 * 				1. 游标向下移动一行
 * 				2. 判断是否有数据
 * 				3. 获取数据
 */
public class JdbcDemo4 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.108:3306/day14", "dabiao", "123456");

            // 3. 定义sql语句
            String sql = "select * from user";

            // 4. 获取执行sql语句对象
            stmt = conn.createStatement();

            // 5. 执行sql
            rs = stmt.executeQuery(sql);

            // 6. 处理结果
            while(rs.next()){
                int l1 = rs.getInt(1);
                String l2 = rs.getString(2);
                String l3 = rs.getString(3);
                System.out.println(l1+"---"+l2+"-----"+l3);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 7. 释放资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
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
