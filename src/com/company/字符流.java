package com.company;

import java.io.*;

public class 字符流 {
    public static void main(String[] args) {
        File file = new File(".."+File.separatorChar+"untitled"+File.separatorChar+"test.txt");
        /*JDK7新特性可以在try后的括号中定义变量，并使用后系统自动关闭流对象*/
//        BufferedWriter 字符缓冲输出流
        try (  BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write("Hello World!!");
//            char[] chars = new char[1024];
//            int len;
//            while ((len = fr.read(chars)) != -1) {
//                System.out.println(new String(chars, 0 ,len));
//            }
            String line;
            //readLine()读取一行字符数据
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
