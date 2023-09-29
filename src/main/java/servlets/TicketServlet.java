package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.service.TicketService;
import servlets.util.JspHelper;

import java.io.IOException;

import static java.lang.Long.parseLong;
import static java.lang.Long.valueOf;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String flightId = (req.getParameter("flightId"));
        Long longFlightId = parseLong(flightId);
        req.setAttribute("tickets", ticketService.findByFlightId(longFlightId));

        req.getRequestDispatcher(JspHelper.getPath("tickets"))
                .forward(req, resp);
    }
}
