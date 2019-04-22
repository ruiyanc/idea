package com.commpay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器套接字绑定端口号
        ServerSocket server = new ServerSocket(8890);
        //使用ServerSocket对象的accept（）获取请求的客户端对象
        Socket socket = server.accept();
        //使用Socket对象的getInputStream（）获取字节输入流对象
        Client.readZdy(socket);
        OutputStream os = socket.getOutputStream();
        os.write("收到，谢谢".getBytes());
        socket.close();
        server.close();
    }
}
