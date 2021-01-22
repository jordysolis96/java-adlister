<%--
  Created by IntelliJ IDEA.
  User: jordysol96
  Date: 1/22/21
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% if(request.getMethod().equalsIgnoreCase("post")) {
    String password = request.getParameter("pass");
    String username = request.getParameter("user");
    if(password.equals("password") && username.equals("admin")){
        response.sendRedirect("/profile.jsp");
    } else {
        response.sendRedirect("/otherUser.jsp");
    }
}
%>

<html>
<head>
    <title>Login</title>
    <%@include file="partials/head.jsp" %>
</head>
<body>

<h1>Log in page</h1>
<form action="login.jsp" method="POST">
    <label>
        Enter Username
        <input type="text" name="user" id="user">
    </label>
    <label>
        Enter Password
        <input type="password" name="pass" id="pass">
    </label>
    <button type="submit">Log in</button>
</form>

</body>
</html>

