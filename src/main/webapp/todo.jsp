<%--
  Created by IntelliJ IDEA.
  User: jordysol96
  Date: 1/19/21
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("isAdmin", true); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Here is your To Do List:</h1>
<ul>
    <li>
        <%= request.getParameter("item")%>
    </li>
</ul>
<p><%= request.getMethod()%></p>
</body>
</html>
