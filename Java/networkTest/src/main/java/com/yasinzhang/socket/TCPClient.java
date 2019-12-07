package com.yasinzhang.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Yasin Zhang
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 65000);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        os.write("hello world".getBytes());
        // ch获取读取数组的长度，buff用来读取输入的内容
        int ch = 0;
        byte[] buff = new byte[1024];
        ch = is.read(buff);
        String content = new String(buff, 0, ch);
        System.out.println(content);
        // 回传接收到的长度
        os.write(java.lang.String.valueOf(content.length()).getBytes());
        // 关闭输入/输出流和socket
        is.close();
        os.close();
        socket.close();
    }
}
