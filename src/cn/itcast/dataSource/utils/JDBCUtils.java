package cn.itcast.dataSource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * druid连接池的工具类
 */
public class JDBCUtils {
//    1.定义成员变量datasource
    private static DataSource ds;

    static {
        try {
//        2.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
//            3.获取DataSource对象
            try {
                ds = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Statement stmt,Connection conn){
        /*if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
        close(null,stmt,conn);
    }
    public static void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
