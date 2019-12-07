package com.yasinzhang.socket;

import sun.util.resources.cldr.gsw.CalendarData_gsw_CH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Yasin Zhang
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buff = "Hello World".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buff, buff.length, address, 65001);
        // 发送数据
        socket.send(packet);
        // 接收数据
        byte[] data = new byte[100];
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        socket.receive(receivePacket);
        String content = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println(content);
    }
}
