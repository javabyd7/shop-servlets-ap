<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Search product</title>
</head>
<body>
<form action="/searchProduct" method="get">
    Name <input name="name" type="text">
    <input type="submit" value="Search">
</form>
<c:out value="${product.name}"/>
<br>
<c:out value="${product.price}"/>
<br>
<c:out value="${product.quantity}"/>
</body>
</html>