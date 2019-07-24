package cn.itcast.util;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的度读取，只需要读取一次
     */

    static{

        try {
            // 读取文件资源，获取值

            // 1. 创建Properties集合类。

            Properties pro = new Properties();

            // 获取src路径下的文件的方式  ----> ClassLoader(); 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL url1 = classLoader.getResource("jdbc.properties");
            String path = url1.getPath();


            // 2. 加载文件
            // pro.load(new FileReader("F:\\Study\\itcast\\day04_JDBC\\src\\jdbc.properties"));
            pro.load(new FileReader(path));

            // 3. 获取值
             url = pro.getProperty("url");
             user = pro.getProperty("user");
             password = pro.getProperty("password");
             driver = pro.getProperty("driver");
            // 3. 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     * @param args
     */
    public static void main(String[] args) {

    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement stmt ,Connection conn){
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

    public static void close(ResultSet rs, Statement stmt ,Connection conn){

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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

