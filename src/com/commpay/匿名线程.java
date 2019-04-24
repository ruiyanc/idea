package com.commpay;

public class 匿名线程 {
    public static void main(String[] args) {
        //多线程资源共享可能会出现线程安全问题
        new Thread(
            () -> System.out.println(Thread.currentThread().getName())).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        }).start();
    }
}
