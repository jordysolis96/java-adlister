<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="All Ads"/>
    </jsp:include>
</head>
<body>
<h1>List of Ads</h1>
<c:forEach  var="ad" items="${ads}">
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
</c:forEach>
</body>
</html>
