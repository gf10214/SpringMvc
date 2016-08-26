package com.wangshuo.javaDemo.Thread;



/**
 * Created by wangshuo on 2016/8/8 0008.
 */
public class TestSync implements Runnable {
    Timer timer = new Timer();

    public static void main(String args[]) {
        TestSync test = new TestSync();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");// 设置t1线程的名字
        t2.setName("t2");// 设置t2线程的名字
        t1.start();
        t2.start();
    }
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
