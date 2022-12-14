<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="text" name="password" value="${password}"><br>
            <input type="submit" value="Log in">
        </form> 
        <c:if test="${invalid == true}">
            <p>Please fill in each form box</p>
        </c:if>
        <c:if test="${logoutmessage == true}">
            <p>Successfully logged out</p>
        </c:if>
        <c:if test="${wronglogin == true}">
            <p>Incorrect username or password</p>
        </c:if>
    </body>
</html>
