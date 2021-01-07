package cn.itcast.dataSource.druid;

import cn.itcast.dataSource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class druiddemo2 {
    public static void main(String[] args) {
        /**
         * 完成添加操作
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into account values(null,?,?)";
//            获取qstmt对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"luoyu");
            pstmt.setDouble(2,1000);
//            执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
