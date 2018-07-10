package com.demo.ioandnio.io;

import java.io.*;

public class FileOprate {

    public static void main(String[] args) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            String pathname = "F:/file-for-io-nio/IO.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename),"UTF-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            while ((line = br.readLine())!= null) {
                System.out.println(line);
            }

            /* 写入Txt文件    */
            File writename = new File("F:/file-for-io-nio/IO-OUTPUT.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            if(!writename.exists()) {
                try {
                    writename.createNewFile();  // 创建新文件
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writename), "UTF-8"));
            out.write("我会写入文件啦\r\n"); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
