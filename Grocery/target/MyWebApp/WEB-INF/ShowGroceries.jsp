<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Show Groceries JSP</h1>
<p>Showing all groceries</p>

<table border=1>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Category</th>
	</tr>
	<c:forEach items="${requestScope.groceries}" var="grocery">
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
