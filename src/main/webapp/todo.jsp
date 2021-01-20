<%--
  Created by IntelliJ IDEA.
  User: jordysol96
  Date: 1/19/21
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("isAdmin", true); %>
<% request.setAttribute("myTasks", new String[] {"todo 1", "todo 2", "todo 3"}); %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${isAdmin}">
        <%@ include file="partials/admin-nav.jsp"%>
    </c:if>


    <h1>Here is your To Do List:</h1>
<ul>
        <c:forEach items="${myTasks}" var="task">
            <li>${task}</li>
        </c:forEach>
</ul>

<p><%= request.getMethod()%></p>
</body>
</html>
