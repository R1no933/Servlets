package servlets.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            String request = inputStream.readUTF();

            while (!"stop".equalsIgnoreCase(request)) {
                System.out.println("Client request is: " + request);
                String responce = scanner.nextLine();
                outputStream.writeUTF(responce);
                request = inputStream.readUTF();
            }
        }
    }
}
