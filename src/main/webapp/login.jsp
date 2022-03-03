<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action = "loginServlet" method= "post">
Email: <input type = "text" name = "email" value = "${requestScope.email}">
Password: <input type = "text" name = "password" value = "${requestScope.password}">
<input type = "submit" value= "Login">
</form>

<c:set var="message" value="${requestScope.message}"/>
<c:if test="${(message != null)}">
<script>
  alert("${message}");
</script>
</c:if>
</body>
</html>