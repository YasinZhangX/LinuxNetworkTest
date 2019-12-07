package com.yasinzhang.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yasin Zhang
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        // 创建Socket
        ServerSocket ss = new ServerSocket(65000);

        // 接收消息
        while (true) {
            // 监听端口，直到客户端返回连接信息
            Socket socket = ss.accept();
            // 获取接收到的数据，执行业务逻辑
            new LengthCalculator(socket).start();
        }
    }
}
