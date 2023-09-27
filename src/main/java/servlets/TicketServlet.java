package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.service.TicketService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private final TicketService service = TicketService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        Long flightId = Long.valueOf(req.getParameter("flightId"));

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Reserved seat number on flight</h1>");
            writer.write("<ul>");
            service.findByFlightId(flightId).forEach(ticketDto -> {
                writer.write("""
                        <li>
                            Reserved seat: %s
                        </li>
                        """.formatted(ticketDto.getSeatNo()));
            });
            writer.write("</ul>");
        }
    }
}
