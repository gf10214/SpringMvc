package com.wangshuo.javaDemo.Thread;

/**
 * Created by wangshuo on 2016/8/8 0008.
 */
public class TestThread2 {
    public static void main(String args[]){
        Runner2 runner2=new Runner2();
        runner2.start();
        for(int i=0;i<10;i++){
            System.out.println("maintheod:"+i);
        }
    }
}
