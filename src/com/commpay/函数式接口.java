package com.commpay;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class 函数式接口 {
    /**Supplier<T>为函数式接口，生产数据，泛型执行String，get方法就会返回一个String*/
    private static String getString(Supplier<String> sup) {
        return sup.get();
    }
    /**Consumer消费性接口，accept方法消费泛型定义的类型*/
    private static void method(String name, Consumer<String> con) {
        con.accept(name);
    }
    public static void main(String[] args) {
        //有且只有一个抽象方法的接口叫函数式接口
        //语法糖：使用更加方便，但原理不变的代码语法，比如foreach
        //注解 @Override 检查方法是否为重写的方法
        //@FunctionInterface检测接口是否是函数式接口
        System.out.println(getString(() -> "打印Supplier函数式接口"));
        method("Computer Games", (String name) -> {
            System.out.println(new String(new StringBuffer(name).reverse().toString()));
        });
        //简化lambda表达式
        method("任天堂",(name)-> System.out.println(new String(new StringBuffer(name).reverse().toString())));
    }
}
