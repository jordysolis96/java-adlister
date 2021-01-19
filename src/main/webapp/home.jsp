<%--
  Created by IntelliJ IDEA.
  User: jordysol96
  Date: 1/19/21
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int pageNumber = 1; %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello Jupiter!</h1>
<%--Testing!--%>
<%--123--%>
<p>The page number is: <%= pageNumber %></p>

    <h3>View Bob's profile</h3>
<form action="user-profile.jsp" method="get">
<input type="hidden" id="username" value="Bob">
<input type="hidden" id="lastname" value="Z">
<button type="submit">Go There</button>
</form>

    <h3>Add a To Do</h3>
<form action="todo.jsp" method="post">
    <input type="text" id="item" name="item">
    <button type="submit">Add to list</button>
</form>
</body>
</html>
