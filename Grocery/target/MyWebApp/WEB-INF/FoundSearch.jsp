
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Searching Result</h1>

<table border=1>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Category</th>
	</tr>
	<c:forEach items="${requestScope.found}" var="grocery">
		<tr>
			<td>${grocery.getGroceryId()}</td>
			<td>${grocery.getGroceryName()}</td>
			<td>${grocery.getCategory()}</td>		
		</tr>
	</c:forEach>
</table>

<p>
	Click here to return <a href="index.jsp">home</a>
</p>
</body>
</html>