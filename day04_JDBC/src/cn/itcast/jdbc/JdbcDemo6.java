package cn.itcast.jdbc;


import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询emp表数据案例
 * 演示jdbc工具类
 */
public class JdbcDemo6 {

    public static void main(String[] args) {
        List<Emp> li = new JdbcDemo6().findAll2();
        System.out.println(li);
    }


    public List<Emp> findAll2(){

        List<Emp> list = null;
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn =null;
        try {


            // 1. 加载驱动
            // 2. 获取数据库连接对象
             conn = JDBCUtils.getConnection();

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


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
         /*   // 7. 释放资源
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
        }*/

            // 7. 释放资源
            JDBCUtils.close(rs, stmt, conn);
        }

        return list;
    }

}
