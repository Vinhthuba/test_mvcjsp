<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 31/05/2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/form.css">
</head>
<body>
<h1>Product Form</h1>
<c:choose>
    <c:when test="${empty product.id}">
        <form action="products?action=create" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
            <br><br>
            <label for="scores">Scores:</label>
            <input type="text" id="scores" name="scores">
            <br><br>
            <label for="grade">Grade:</label>
            <input type="text" id="grade" name="grade">
            <br><br>
            <input type="submit" value="Create">
            <a href="products" class="button">Cancel</a>
        </form>
    </c:when>
    <c:otherwise>
        <form action="products?action=update" method="POST">
            <input type="hidden" name="id" value="${product.id}">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${product.name}">
            <br><br>
            <label for="scores">Scores:</label>
            <input type="text" id="scores" name="scores" value="${product.scores}">
            <br><br>
            <label for="grade">Grade:</label>
            <input type="text" id="grade" name="grade" value="${product.grade}">
            <br><br>
            <input type="submit" value="Update">
            <a href="products" class="button">Cancel</a>
        </form>

    </c:otherwise>
</c:choose>
</body>
</html>
