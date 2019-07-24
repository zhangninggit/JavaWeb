package cn.itcast.datasourse.druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid演示
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // 1. 导入jar包

        // 2.定义配置文件

        // 3. 加载配置文件druid.properties
        Properties pro = new Properties();
        // 将src路径下的druid.properties配置文件加载到输入流中
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        // 将is输入流中的druid.properties文件加载到Properties集合中
        pro.load(is);

        // 4. 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        // 5. 获取连接对象
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
