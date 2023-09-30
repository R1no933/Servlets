package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dto.FlightDto;
import servlets.service.FlightService;
import servlets.util.JspHelper;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightDto = flightService.flightAll();

        req.setAttribute("flights", flightDto);
        req.getSession().setAttribute("flightsMap", flightDto.stream()
                .collect((toMap(FlightDto::getId, FlightDto::getDescription))));
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
