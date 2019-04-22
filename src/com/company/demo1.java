package com.company;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo1 {
    public static void main(String[] args)  {
        try {
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "yanrui", "xu1998");
        String sql = "select * from students";
        Statement statement = null;
            statement = (Statement) connection.createStatement();
            boolean count = statement.execute(sql);
            System.out.println(count);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
