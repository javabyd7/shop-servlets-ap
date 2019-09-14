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
<table>
    <thead>
    <tr>
        <td>Product</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Total Earnings</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>
                <c:out value="${product.name}"/>
            </td>
            <td>
                <c:out value="${product.price}"/>
            </td>
            <td>
                <c:out value="${product.quantity}"/>
            </td>
            <td>
                <c:out value="${product.calculatePotentialTotalEarnings()}"/>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>