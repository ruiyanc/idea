package com.commpay;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 线程安全 implements Runnable {
    private int ticket = 100;
    //创建一个锁对象
    Object obj = new Object();
    /**Lock锁。创建一个ReentrantLock对象*/
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //在线程安全代码前加Lock锁
            lock.lock();
            //同步代码块
//            synchronized (obj) {
                    payIicket();
                    lock.unlock();
            if (ticket == 0) break;
        }
//            }
    }

    /**定义同步方法，会把方法内部的代码锁住，只让一个线程执行*/
    public synchronized void payIicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}


