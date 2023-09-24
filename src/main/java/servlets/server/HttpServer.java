package servlets.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {
    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket accept = serverSocket.accept();
            processSocket(accept);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket accept) {
        try (accept;
             DataInputStream inputStream = new DataInputStream(accept.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(accept.getOutputStream())) {

            // request handler
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));

            //response handler
            byte[] body = Files.readAllBytes(Path.of("resources", "ExampleHtml.html"));
            String headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length);
            // output
            outputStream.write(headers.getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);

        } catch (IOException e) {
            // TODO: log error message
            e.printStackTrace();
        }
    }
}
