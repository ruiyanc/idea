package com.company;

import java.io.*;

public class 字节流 {
    public static void main(String[] args) {
        File file = new File("../untitled"+File.separatorChar+"test.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(file, true);
            //BufferedOutputStream字节缓冲输出流，输出到缓冲区close后写入硬盘
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write("数据写入到缓冲流中".getBytes());
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0 ,len));
            }
            bos.close();
            fos.close();
            bis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
