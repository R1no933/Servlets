package servlets.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramServer = new DatagramSocket(7777)) {
            byte[] byteBuffer = new byte[512];
            DatagramPacket packet = new DatagramPacket(byteBuffer, byteBuffer.length);
            datagramServer.receive(packet);

            System.out.println(new String(byteBuffer));
        }
    }
}
