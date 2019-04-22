package com.commpay;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

public class 多线程 {
    public static void main(String[] args) {
        //并发：多个事件在同一时间段内发生，交替执行
        //并行：多个事件在同一时刻发生（同时发生）
//        MyThread mt = new MyThread();
//        mt.start();
     /*第二种实现runnable接口重写run方法，然后new Thread（传参）.start()来调用
     * 好处：避免单继承的限制，降低耦合性
     * */
        //主线程
//        System.out.println(Thread.currentThread().getName());
        线程安全 run = new 线程安全();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();

        //wait(timeout)等待，notify()唤醒
        //Timed waiting 计时等待
        ExecutorService es = newFixedThreadPool(2);
        es.submit(new 线程安全());
    }
}
