package com.company;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid
 */
public class DruidDemo {
    public static void main(String[] args) {
        //加载配置文件
        try {
            Properties properties = new Properties();
            InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("com/pro.properties");
            properties.load(is);
            //获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //获取连接
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
