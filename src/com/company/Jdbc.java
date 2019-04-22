package com.company;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws Exception  {
        Class.forName("com.mysql.jdbc");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "yanrui", "xu1998");
        String sql = "select * from students";
        Statement statement = connection.createStatement();
        boolean count = statement.execute(sql);
        System.out.println(count);
        statement.close();
        connection.close();
    }
}
