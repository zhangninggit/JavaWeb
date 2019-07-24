package cn.itcast.jdbctemplate;

import cn.itcast.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 1. 导入jar包
        // 2. 创建JDBCTemplate对象

        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        // 3.调用方法
        String sql = "update USER set PASSWORD = ? where id = ?";
        int i = template.update(sql, 666, 5);

        System.out.println(i);


    }
}
