package cn.itcast.JDBCTemplate;

import cn.itcast.dataSource.domain.emp;
import cn.itcast.dataSource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {

    /**
     * 修改一号数据的salary为1000
     */
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test01(){
        //获取JDBCTemplate对象

//        定义sql
        String sql = "update emp set salary = 10000 where id = 1";
//        执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into emp(id,NAME,salary) values(?,?,?)";
        int count = template.update(sql, 6, "罗宇", 9000);
        System.out.println(count);
    }

    /**
     * 删除添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 6);
        System.out.println(count);
    }
    /**
     * 查询id为1的记录，并将其封装为map集合
     * 注意:这个方法查询的结果集长度只能为1
     */
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map.toString());
    }

    /**
     * 查询所有记录，将其封装为list集合
     */
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for(Map<String,Object> StringMap:list){
            System.out.println(StringMap);
        }
    }

    /**
     * 查询所有记录，将其封装为emp对象再加入list集合
     */
    @Test
    public void test6(){
        String sql = "select * from emp";
        List<emp> list = template.query(sql, new BeanPropertyRowMapper<emp>(emp.class));
        for(emp Emp:list){
            System.out.println(Emp);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test7(){
        String sql = "select count(*) from emp";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
