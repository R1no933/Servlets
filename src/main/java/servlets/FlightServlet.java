package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dto.FlightDto;
import servlets.service.FlightService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService service = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>List of flights:</h1>");
            writer.write("<ul>");
            service.flightAll().forEach(flightDto -> {
                writer.write("""
                        <li>
                            <a href="/tickets?filghtId=%d">%s
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription()));

            });
            writer.write("/<ul>");
        }
    }
}
