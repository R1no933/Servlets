<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Buying tickets</h1>
    <ul>
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket.seatNo)}</li>
        </c:forEach>
    </ul>
</body>
</html>
