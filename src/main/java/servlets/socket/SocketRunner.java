package servlets.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        // http port - 80
        // https port - 443
        InetAddress inetAddress = Inet4Address.getByName("google.com");

        try (Socket socket = new Socket(inetAddress, 80);
             DataOutputStream  outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {

            outputStream.writeUTF("Hello world!!!");
            byte[] allBytesResponce = inputStream.readAllBytes();

            System.out.println(allBytesResponce.length);
        }
    }
}
