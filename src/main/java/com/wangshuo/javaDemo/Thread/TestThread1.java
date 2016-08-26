package com.wangshuo.javaDemo.Thread;

/**
 * Created by wangshuo on 2016/8/8 0008.
 */
public class TestThread1 {
    public static void main(String args[]){
        Runner1 runner1=new Runner1();
        Thread t=new Thread(runner1);
        t.start();
        for(int i=0;i<10;i++){
            System.out.println("maintheod:"+i);
        }
    }
}
