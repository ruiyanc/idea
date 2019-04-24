package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    static {
        //读取资源文件，获取值
        try {
            Properties properties = new Properties();
            //获取src路径下的文件的方式 -->ClassLoader 类加载器
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL resource = classLoader.getResource("pro.properties");
            String path = resource.getPath();
            properties.load(new FileReader(path));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
