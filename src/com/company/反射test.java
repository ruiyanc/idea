package com.company;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

@Pro(className = "com.company.Person", methodName = "eat")
public class 反射test {
    public static void main(String[] args) throws Exception{
        /*//加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = 反射test.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("./com/pro.properties");
        pro.load(is);
        //获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");*/
        //解析注解
        //获取该类的字节码对象
        Class<反射test> testClass = 反射test.class;
        //获取上边的注解对象。就是在内存中生成一个该注解接口的子类实现对象
        Pro an = testClass.getAnnotation(Pro.class);
        //调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        //加载该类进内存
        Class<?> cls = Class.forName(className);
        Object obj = cls.getDeclaredConstructor().newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
