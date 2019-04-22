package com.commpay;

public class 匿名内部类实现线程 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                }
            }
        }.start();

        new Runnable(){

            @Override
            public void run() {

            }
        }
    }
}
