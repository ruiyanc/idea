package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "yanrui", "xu1998");
        String sql = "select * from students";
        Statement statement = connection.createStatement();
        boolean count = statement.execute(sql);
        System.out.println(count);
        statement.close();
        connection.close();
    }
}
