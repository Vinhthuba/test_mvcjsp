<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 31/05/2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/list.css">
</head>
<body>
<h1>Product List</h1>
<a href="products?action=new" class="button add-button" style="margin-left: 40px;">Add New Product</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Scores</th>
        <th>Grade</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.scores}</td>
            <td>${product.grade}</td>
            <td>
                <a href="products?action=edit&id=${product.id}" class="button">Edit</a>
                <a href="products?action=delete&id=${product.id}" class="button" onclick="return confirm('Are you sure you want to delete this product?')">
                    Delete
                </a>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
