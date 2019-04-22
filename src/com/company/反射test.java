package com.company;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class 反射test {
    public static void main(String[] args) throws Exception{
        //加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = 反射test.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("./com/pro.properties");
        pro.load(is);
        //获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //加载该类进内存
        Class<?> cls = Class.forName(className);
        Object obj = cls.getDeclaredConstructor().newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
