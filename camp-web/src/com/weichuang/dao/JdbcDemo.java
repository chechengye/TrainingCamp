package com.weichuang.dao;

import com.weichuang.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.*;

public class JdbcDemo {
    /**
     * DBUtils 工具类进行删除操作
     * QueryRunner
     * update更新处理
     * query查询处理
     */
    @Test
    public void testDelete(){
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "delete from t_user where id = ?";
        try {
            int rows = qr.update(sql, 2);
            if(rows > 0){
                System.out.println("删除成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、连接mysql数据库，并获得连接对象 jdbc:mysql:// ：jdbc连接mysql协议
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/camp_web" , "root","root");
            //3、获取prepareStatement  ? : 占位符，之后动态添加
            pstmt = conn.prepareStatement("update t_user set name = ? where id = ? ");
            //4、动态赋值 ,索引从1开始
            pstmt.setString(1 , "zhangfei");
            pstmt.setInt(2 , 4);
            //5、执行数据库操作，executeUpdate : 更新操作 rows : 受影响的行数
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.println("更新成功!");
            }else{
                System.out.println("更新失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery(){
        Connection conn = null;
        Statement stmt = null; //不支持通配符，只能进行sql语句的拼接，容易造成sql攻击
        ResultSet rs = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、连接mysql数据库，并获得连接对象 jdbc:mysql:// ：jdbc连接mysql协议
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/camp_web" , "root","root");
            //3、用来执行sql语句的
            stmt = conn.createStatement();
            //4、执行sql语句executeQuery ： 进行查询操作 ,获得结果集
            rs = stmt.executeQuery("select * from t_user");
            //5、访问处理结果集 rs.next() : 会改变光标位置，从0开始依次到最后
            while (rs.next()){
                //若成立，可以获取rs中的值 。数据库中索引的位置是从1开始
                System.out.println("name : " + rs.getString("name")
                        + " , age :" + rs.getInt(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //不管try、catch块是否出现异常都会执行到的
            if(null != rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(null != stmt){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
