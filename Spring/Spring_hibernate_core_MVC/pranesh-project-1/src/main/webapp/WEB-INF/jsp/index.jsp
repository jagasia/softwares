<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<c:forEach var="e" items="${employees }">
<tr><td>${e.employeeId}</td><td>${e.firstName }</td><td>${e.lastName }</td>
</tr>
</c:forEach>
</table>
</body>
</html>