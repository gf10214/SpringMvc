package com.wangshuo.javaDemo.Thread;

/**
 * Created by wangshuo on 2016/8/8 0008.
 */
public class TestThread4 {
    public static void main(String args[]) {
        MyThread2 thread2 = new MyThread2("mythread");
        // 在创建一个新的线程对象的同时给这个线程对象命名为mythread
        thread2.start();// 启动线程
        try {
            thread2.join();// 调用join()方法合并线程，将子线程mythread合并到主线程里面
            // 合并线程后，程序的执行的过程就相当于是方法的调用的执行过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}
