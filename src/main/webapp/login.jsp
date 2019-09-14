<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/login" method="post">
    Login <input name="login" type="text">
    Password <input name="password" type="password">
    <input type="submit" value="Login">
</form>
<c:if test="${!param['success']}">
    Bad Login or pass
</c:if>
</body>
</html>
