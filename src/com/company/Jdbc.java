package com.company;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection connection =  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC",
                "root", "xu1998");
        //定义sql语句
//        String sql = "update students set age = 38 where id = 5";
        String sql = "select * from students where id between ? and ?";
        //获取执行sql的对象
//        Statement statement =  connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        preparedStatement.setInt(2,7);
//        int count = statement.executeUpdate(sql);
//        System.out.println(count);
//        ResultSet resultSet = statement.executeQuery(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //移动游标，循环判断游标是否是最后一行
        while (resultSet.next()) {
            //获取数据
            System.out.println(resultSet.getInt(1) + resultSet.getString("name")
                    + resultSet.getInt(3) + resultSet.getDouble(4)
                    + resultSet.getString(5) + resultSet.getDate(6));
        }
        resultSet.close();
//        statement.close();
        preparedStatement.close();
        connection.close();
    }
}
