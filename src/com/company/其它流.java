package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 其它流 {
    public static void main(String[] args) throws IOException {
        File file = new File("../untitled"+File.separatorChar+"test.txt");
        //转换流InputStreamReader,OutputStreamWriter
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"utf-8");
        char[] chars = new char[1024];
            int len;
            while ((len = isr.read(chars)) != -1) {
                System.out.println(new String(chars, 0 ,len));
            }
    }
}
