package com.yasinzhang.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Yasin Zhang
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(65001);
        byte[] buff = new byte[100];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        // 接收客户端发送过来的内容，并将内容封装进DatagramPacket对象中
        socket.receive(packet);
        // 打印接收到的数据报
        byte[] data = packet.getData();
        String content = new String(data, 0, packet.getLength());
        System.out.println(content);
        // 服务端发送数据报
        byte[] sentContent = String.valueOf(content.length()).getBytes();
        DatagramPacket packetToClient = new DatagramPacket(sentContent, sentContent.length,
            packet.getAddress(), packet.getPort());
        socket.send(packetToClient);
    }
}
