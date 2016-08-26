package com.wangshuo.javaDemo.Thread;

/**
 * Created by wangshuo on 2016/8/8 0008.
 */
public class Runner2 extends Thread {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner1:"+i);
        }
    }
}
