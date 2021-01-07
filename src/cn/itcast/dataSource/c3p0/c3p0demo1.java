package cn.itcast.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 */
public class c3p0demo1 {
    public static void main(String[] args) throws SQLException {
//        1.创建数据库连接池对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
//        2.获取连接对象
        Connection conn = ds.getConnection();
//        3.打印
        System.out.println(conn);
    }
}
