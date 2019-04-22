package com.commpay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端对象指定IP地址和端口
        //Socket创建客户端套接字
        Socket socket = new Socket("127.0.0.1", 8890);
        //使用socket对象的getOutputStream（）获取字节输出流对象
        OutputStream os = socket.getOutputStream();
        //使用输出流对象的write（）给服务器发送数据
        os.write("你好服务器".getBytes());
        //使用socket对象的getInputStream（）获取输入流对象
        readZdy(socket);
        socket.close();

    }

    static void readZdy(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0 ,len));
    }
}
