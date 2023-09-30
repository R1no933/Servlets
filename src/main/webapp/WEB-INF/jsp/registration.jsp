<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <img src="${pageContext.request.contextPath}/images/users/Снимок%20экрана%202023-09-04%20в%2021.34.50.png" alt="Avatar">

    <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
        <label for="username">
            Username:
            <input type="text" name="username" id="username">
        </label><br>
        <label for="birthday">
            Birthday:
            <input type="date" name="birthday" id="birthday">
        </label><br>
        <label for="email">
            Email:
            <input type="email" name="email" id="email">
        </label><br>
        <label for="password">
            Password:
            <input type="password" name="password" id="password">
        </label><br>
        <label for="role">
            Select you permission:
            <select name="role" id="role">
                <c:forEach var="role" items="${requestScope.roles}">
                    <option value="${role}">${role}</option>
                </c:forEach>
            </select>
        </label><br>
        <c:forEach var="gender" items="${requestScope.genders}">
            <input type="radio" name="gender" value="${gender}">${gender}
        </c:forEach>
        <br>
        <label for="image">
            Avatar:
            <input type="file" name="image" id="image">
        </label>
        <br>
        <br>
        <button type="submit">Registration</button>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                </c:forEach>
            </div>
        </c:if>
    </form>
</body>
</html>
