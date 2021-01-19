<%--
  Created by IntelliJ IDEA.
  User: jordysol96
  Date: 1/19/21
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h3>Welcome, <%= request.getParameter("username")%></h3>
<h3>your user id is: <%= request.getParameter("user-id")%></h3>
<p><%= request.getMethod() %></p>
</body>
</html>
