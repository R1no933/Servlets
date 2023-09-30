package servlets.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        // http port - 80
        // https port - 443
        InetAddress inetAddress = Inet4Address.getByName("localhost");

        try (Socket socket = new Socket(inetAddress, 7777);
             DataOutputStream  outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Responce from server is: " + inputStream.readUTF());
            }
        }
    }
}
