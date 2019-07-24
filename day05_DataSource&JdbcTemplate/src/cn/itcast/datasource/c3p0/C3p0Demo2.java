package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3p0演示
 */
public class C3p0Demo2 {
    public static void main(String[] args) {
        // 获取连接池对象
        DataSource ds = new ComboPooledDataSource();

        // 获取连接对象
        try {
            // 获取最大连接
            for (int i = 1; i <=10; i++) {
                Connection conn = ds.getConnection();
                System.out.println(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
