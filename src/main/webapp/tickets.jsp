<%@ page import="servlets.service.TicketService" %>
<%@ page import="servlets.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Buying tickets</h1>
    <ul>
        <%
            Long flightId = Long.valueOf(request.getParameter("flightId"));
            List<TicketDto> byFlightId = TicketService.getInstance().findByFlightId(flightId);

            for (TicketDto ticketDto : byFlightId) {
                out.write(String.format("<li>Seat reservd: %s</li>", ticketDto.getSeatNo()));
            }
        %>
    </ul>
</body>
</html>
