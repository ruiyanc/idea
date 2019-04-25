package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class xml解析 {
    public static void main(String[] args) throws IOException {
        //获取XML文件的路径
        String path = xml解析.class.getClassLoader().getResource("a.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements name = document.select("name");
        System.out.println(name);
    }
}
