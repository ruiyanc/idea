package com.commpay;

public class MyThread extends Thread{
    @Override
    public void run() {
        //获取线程的名称
        System.out.println(Thread.currentThread());
        System.out.println(getName());
    }
}
