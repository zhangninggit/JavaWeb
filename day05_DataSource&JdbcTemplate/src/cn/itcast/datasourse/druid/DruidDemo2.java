package cn.itcast.datasourse.druid;

import cn.itcast.util.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试新的工具类（Druid）
 */
public class DruidDemo2 {
    /**
     *需求给USER表添加一条记录
     *
     */

    public static void main(String[] args) {
        // 1. 获取DataSource连接池对象
        DataSource ds = JdbcUtils.getDatasource();

        // 2. 获取数据库连接对象
        Connection conn = null;
        PreparedStatement pstmt =null;
        try {
            conn = JdbcUtils.getConnection();

            // 3. 定义sql语句
            String sql = "insert into USER Values(0,?,?)";

            // 4. 创建执行sql语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"zhangning");
            pstmt.setString(2,"777");

            // 5. 执行sql语句
            int i = pstmt.executeUpdate();

            // 6. 处理执行结果
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 7.归还连接资源
            JdbcUtils.close(null,pstmt,conn);
        }

    }
}
