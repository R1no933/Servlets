package servlets.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {

        InetAddress localhost = Inet4Address.getByName("localhost");

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] byteBuffer = "Hi, i'm udp client".getBytes();

            DatagramPacket packet = new DatagramPacket(byteBuffer, byteBuffer.length, localhost, 7777);
            datagramSocket.send(packet);
        }
    }
}
