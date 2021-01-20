<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jordysol96
  Date: 1/19/21
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%! int pageNumber = 1; %>--%>
<% request.setAttribute("number", 1); %>
<% request.setAttribute("title", "Home Page"); %>
<% request.setAttribute("isLoggedIn", false); %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <%@ include file="partials/Navbar.jsp"%>
    <h1>Hello Jupiter!</h1>
<%--Testing!--%>
<%--123--%>
<p>The page number is: ${number}</p>


    <c:choose>
        <c:when test="${isLoggedIn}">
    <h3>View Bob's profile</h3>
<form action="user-profile.jsp" method="get">
<input type="hidden" id="username" name="username" value="Bob">
<input type="hidden" id="lastname" name="username-id" value="12345">
<button type="submit">Go There</button>
</form>

    <h3>Add a To Do</h3>
<form action="todo.jsp" method="post">
    <input type="text" id="item" name="item">
    <button type="submit">Add to list</button>
</form>
    </c:when>
        <c:otherwise>
            <h3>Please log in first!</h3>
        </c:otherwise>
</c:choose>


<%@ include file="partials/footer.jsp" %>
</body>
</html>
