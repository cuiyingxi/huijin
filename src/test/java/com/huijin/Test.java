package com.huijin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {

        // 数据库连接URL，格式为：jdbc:mysql://host:port/databaseName
        String url = "jdbc:mysql://121.36.102.236:3306/huijin";
        // 数据库用户名
        String user = "cuiyingxi";
        // 数据库密码
        String password = "947370164";

        try {
            // 加载并注册JDBC驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            Connection conn = DriverManager.getConnection(url, user, password);
            // 创建Statement对象来执行SQL语句
            Statement stmt = conn.createStatement();
            // 执行查询并获取结果
            ResultSet rs = stmt.executeQuery("SELECT * FROM huijin_user");

            // 遍历结果集
            while (rs.next()) {
                System.out.println(rs.getString("id")); // 替换为你的列名
                System.out.println(rs.getString("name")); // 替换为你的列名
            }

            // 关闭结果集、Statement和连接
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
