package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类
 */
public class JdbcUtils {

    // 定义成员变量DataSource连接池对象
    private static DataSource ds;

    static {
        // 加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds =  DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 归还连接对象
    public static void close(ResultSet rs, Statement stmt,Connection conn){
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

    public static void close(Statement stmt,Connection conn){
 /*       if(stmt != null){
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
        }*/

        close(null,stmt,conn);
    }
    // 获取连接池对线象

    public static DataSource getDatasource(){
        return ds;
    }
}
