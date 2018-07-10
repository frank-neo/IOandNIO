package com.demo.ioandnio.io;

import java.io.*;

public class Iodemo {


    public static void main(String[] args) {
//        InputStream:是一个抽象类
//         \:是一个 转意符
//        表示磁盘路径的两种表示方式：1、\\   2、/
        try {
//            设置文件路径，获取文件对象
            InputStream IOfile = new FileInputStream("F:/file-for-io-nio/IO.txt");
            BufferedReader iofilereader = new BufferedReader(new InputStreamReader(IOfile));
            String firstrow = iofilereader.readLine();
            String secondrow = iofilereader.readLine();
            System.out.println(firstrow);
            System.out.println(secondrow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
