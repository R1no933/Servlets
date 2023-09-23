package servlets.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static java.net.http.HttpResponse.*;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest getRequestExample = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET()
                .build();

        HttpRequest postRequestExample = HttpRequest.newBuilder(URI.create("https://google.com"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("absolute path", "to", "file")))
                .build();

        HttpResponse<String> response = httpClient.send(getRequestExample, BodyHandlers.ofString());
        System.out.println(response.headers());
        System.out.println("=============================");
        System.out.println(response.body());

    }
}
