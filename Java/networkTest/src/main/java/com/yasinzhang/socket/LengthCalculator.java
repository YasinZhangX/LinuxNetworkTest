package com.yasinzhang.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Yasin Zhang
 */
public class LengthCalculator extends Thread {

    private Socket socket;

    public LengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 获取socket的输出流
            OutputStream os = socket.getOutputStream();
            // 获取socket的输入流
            InputStream is = socket.getInputStream();

            // ch获取读取数组的长度，buff用来读取输入的内容
            int ch = 0;
            byte[] buff = new byte[1024];
            ch = is.read(buff);
            String content = new String(buff, 0, ch);
            System.out.println(content);
            // 回传接收到的长度
            os.write(String.valueOf(content.length()).getBytes());
            // 关闭输入/输出流和socket
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
