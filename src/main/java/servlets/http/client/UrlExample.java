package servlets.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {
    public static void main(String[] args) throws IOException {

    }

    private static void checkFileWithURLClass() throws IOException {
        URL url = new URL("file:/Users/dmitriybaskakov/Desktop/Servlets/src/main/java/servlets/datagram/DatagramRunner.java");
        URLConnection connection = url.openConnection();

        System.out.println(new String(connection.getInputStream().readAllBytes()));
    }

    private static void checkGoogleWithURLClass() throws IOException {
        URL url = new URL("https://google.com");
        URLConnection connection = url.openConnection();

        connection.setDoOutput(true);

        try (OutputStream outputStream = connection.getOutputStream()) {

        }

        System.out.println();
    }
}
