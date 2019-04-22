package com.commpay;

import java.util.Arrays;

public class DemoLambda {

    public static void main(String[] args) {
        //使用lambda表达式实现多线程，JDK8的特性
        //三部分：（参数列表）+箭头+代码
        //():参数列表，无则空着 ->:传递的意思，把参数传递给方法体 {}：抽象方法的方法体
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "新线程创建了");
        }).start();
        //使用lambda必须具有接口，且要求接口中有且仅有一个抽象方法(函数式接口)，必须具有上下文推断
        //进一步省略()内的参数列表的数据类型可以不写，若参数只有一个类型和（）都可以省略
        //若{}中的代码只有一行，都可以省略（)，{}，return，分号
        new Thread(() ->System.out.println(Thread.currentThread().getName() + "新线程创建了")).start();
    }
}
