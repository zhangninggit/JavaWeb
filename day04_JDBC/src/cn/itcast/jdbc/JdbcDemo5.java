package cn.itcast.jdbc;


import cn.itcast.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询emp表数据案例
 */
public class JdbcDemo5 {

    public static void main(String[] args) {
        List<Emp> li = new JdbcDemo5().findAll();
        System.out.println(li);
    }


    public List<Emp> findAll(){

        List<Emp> list = null;
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn =null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.108:3306/day14", "dabiao", "123456");

            // 3. 定义sql
            String sql = "select * from emp";

            // 4. 获取数据库连接对象
            stmt = conn.createStatement();

            // 5. 执行sql
            rs = stmt.executeQuery(sql);

            // 6. 处理数据

            list = new ArrayList<Emp>();
            Emp emp = null;
            while(rs.next()){

                emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setJob_id(rs.getInt("job_id"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setJiondate(rs.getDate("joindate"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setBonus(rs.getDouble("bonus"));
                emp.setDept_id(rs.getInt("dept_id"));

                list.add(emp);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 7. 释放资源
            if(rs != null){
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

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return list;
    }

}
