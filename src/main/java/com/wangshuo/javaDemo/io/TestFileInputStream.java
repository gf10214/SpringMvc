package com.wangshuo.javaDemo.io;

import java.io.*;

/**
 * Created by wangshuo on 2016/8/9 0009.
 */
public class TestFileInputStream {
    public static void main(String args[]){
        int b=0;
        FileInputStream in=null;
        FileOutputStream out = null;
        FileReader rin=null;
        try {
            in=new FileInputStream("D:/test.txt");
            out=new FileOutputStream("D:/test1.txt");
            rin=new FileReader("D:/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("系统找不到指定文件！");
            System.exit(-1);
            //AAAAAAA
        }
        long num=0;
        try {
            while ((b=in.read())!=-1){
                System.out.print((char) b);
                out.write(b);
                num++;
            }
            in.close();
            out.close();
            System.out.println();
            System.out.println("总共读取了" + num + "个字节的文件");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取有误！");
        }
    }
}
