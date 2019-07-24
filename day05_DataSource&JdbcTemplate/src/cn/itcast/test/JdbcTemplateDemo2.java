package cn.itcast.test;

import cn.itcast.domain.Emp;
import cn.itcast.util.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {

    /**
     * 调用JdbcTemplate的方法来完成CRUD的操作
     * 			* update():执行DML语句。增、删、改语句
     * 			* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
     * 				* 注意：这个方法查询的结果集长度只能是1
     * 			* queryForList():查询结果将结果集封装为list集合
     * 				* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
     * 			* query():查询结果，将结果封装为JavaBean对象
     * 				* query的参数：RowMapper
     * 					* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
     * 					* new BeanPropertyRowMapper<类型>(类型.class)
     * 			* queryForObject：查询结果，将结果封装为对象
     * 				* 一般用于聚合函数的查询
     */

    /**
     *
     4. 练习：
     * 需求：
         1. 修改1001号数据的 salary 为 10000
         2. 添加一条记录
         3. 删除刚才添加的记录
         4. 查询id为1001的记录，将其封装为Map集合
         5. 查询所有记录，将其封装为List
         6. 查询所有记录，将其封装为Emp对象的List集合
         7. 查询总记录数
     */

    /**
     * 在emp表中操作
     * 1. 修改1001号数据的salary为1000
     */
    @Test
    public void test1(){
        // 1.获取连接池对象DataSource 获取数据库连接对象Connection
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        // 2. 定义sql
        String sql = "update emp set salary = 1000 where id = ?";

        // 3. 执行修改操作
        int i = template.update(sql, 1001);

        // 4. 处理结果

        System.out.println(i);
    }


    /**
     *  2. 添加一条记录
     */
    @Test
    public void test2() {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        String sql = "insert into emp(id,ename,salary) values(1015,?,?)";

        int i = template.update(sql, "张大彪", 6666);

        System.out.println(i);

    }

    /**
     * 3. 删除刚才添加的记录
     */
    @Test
    public void test3() {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        String sql = "delete from emp where id = ?";

        int i = template.update(sql, 1015);

        System.out.println(i);
    }


    /**
     * 4. 查询id为1001的记录，将其封装为Map集合
     */
    @Test
    public void test4() {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        String sql = "select * from emp where id = ?";

        Map<String, Object> map = template.queryForMap(sql, 1001);

        System.out.println(map);

    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5() {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        String sql = "select * from emp";

        List<Map<String, Object>> list = template.queryForList(sql);

        System.out.println(list);

    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6() {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        String sql = "select * from emp";

        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class)); // BeanPropertyRowMapper<Emp>(Emp.class) 将查询结果封装成List集合

        System.out.println(list);

    }

    /**
     * 7. 查询总记录数
     */
    @Test
    public void test7() {

        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());

        String sql = "select count(id) from emp";

        Long count = template.queryForObject(sql, Long.class); //queryForObject查询聚合函数 参数2:聚合函数返回值类型

        System.out.println(count);
    }
}
