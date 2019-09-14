<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<form action="/addProduct" method="post">
    Name <input name="name" type="text">
    Price <input name="price" type="number">
    Quantity <input name="quantity" type="number">
    <input type="submit" value="Add">
</form>
<a href="/searchProduct">Show and search products</a>
<c:if test="${param['success']}">
    Success!!
</c:if>
<c:if test="${!param['success']}">
    Failed
</c:if>
</body>
</html>
