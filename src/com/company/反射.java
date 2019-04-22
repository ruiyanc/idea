package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 反射 {
    public static void main(String[] args) throws Exception{
        // 反射：框架设计的灵魂。
        // 反射机制：将类的各个组成部分封装成其他对象
        // 0.获取Person的Class对象
        Class<Person> personClass = Person.class;
        // 1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        Field a = personClass.getField("a");
        Person person = new Person();
        System.out.println(a.get(person));
        a.set(person, "张三");
        System.out.println(person);
        System.out.println(" ");
        // 2.Field[] getDeclaredFields():获取所有的成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field d = personClass.getDeclaredField("d");
        // 忽略访问权限修饰符的安全检查
        d.setAccessible(true);  //   暴力反射
        System.out.println(d.get(person));

        System.out.println("----------------");

        //Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //newInstance() 构造器创建对象
        Object person1 = constructor.newInstance("李四", 25);
        System.out.println(person1);
        //如果空参构造的对象可以就简化 使用newInstance
//        System.out.println(personClass.newInstance());  //已过时
        System.out.println(personClass.getDeclaredConstructor().newInstance());

        System.out.println("----------------------");

        //获取指定名称的方法 getMethod(指定方法名，指定参数)
        Method eat = personClass.getMethod("eat");
        eat.invoke(person); // invoke（）执行方法
        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName()); // 获取方法名
        }
        //获取类名
        System.out.println(personClass.getName());

        //获取Class对象的方式。同一个
//        1.  Class.forName("全类名") :  将字节码文件加载进内存，返回Class对象。常用于配置文件，将类名定义在配置文件中，读取文件，加载类
        Class cls1 = Class.forName("com.company.Person");
        System.out.println(cls1);
//        2.  类名.class :  通过类名的属性class获取。多用于参数的传递
        Class cls2 = Person.class;
        System.out.println(cls2);
//        3.  对象.getClass（） :  getClass（）方法在Object类中定义的。多用于对象的获取字节码的方式
        Person cls3 = new Person();
        System.out.println(cls3);
        //Class对象的功能。
        // 获取成员变量们，Field[] getField
        // 获取构造方法们，
        // 获取成员方法们，获取类名
    }
}
