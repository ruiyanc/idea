package com.commpay;

public class 线程间通信 {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();
        new BaoZiPu(bz).start();
        new Eat(bz).start();
    }
}

class BaoZi {
    String pi;
    String xian;
    /**有为true，无为false*/
    boolean flag = false;
}

class BaoZiPu extends Thread{
    private BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                //有包子则等待，wait（）
                if (bz.flag) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒后执行生产，交替生成两种包子
                if (count % 2 == 0) {
                    bz.pi = "薄皮";
                    bz.xian = "三鲜馅";
                } else {
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱馅";
                }
                count++;
                if (count == 10) {
                    break;
                }
                System.out.println("包子铺正在生产：" + bz.pi + bz.xian + "包子");
                //生产包子需要3s
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //生产好了有包子flag为true
                bz.flag = true;
                //唤醒吃的线程，吃包子
                bz.notify();
                System.out.println("包子铺生产好了：" + bz.pi + bz.xian + "包子，可以吃了");
            }
        }
    }
}

class Eat extends Thread {
    private BaoZi bz;
    public Eat(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag == false) {
                    //等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒，吃包子
                System.out.println("正在吃:" + bz.pi + bz.xian + "的包子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                bz.notify();
                System.out.println("已经吃完了：" + bz.pi + bz.xian + "的包子，包子铺开始生产");
                System.out.println("----------------------");
            }
        }
    }
}
