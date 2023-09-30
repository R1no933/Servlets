<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <div>
        <span>Content</span>
        <p>Size: ${requestScope.flights.size()}</p>
        <p>Description: ${requestScope.flights.get(0).description}</p>
        <p>Map example: ${sessionScope.flightsMap[1]}</p>
        <p>JSESSION ID: ${cookie["JSESSINOID"]}, unique identifier</p>
        <p>Header: ${header["Cookie"]}</p>
        <p>Parameters: ${param.id}</p>
        <p>Parameter test: ${param.test}</p>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
