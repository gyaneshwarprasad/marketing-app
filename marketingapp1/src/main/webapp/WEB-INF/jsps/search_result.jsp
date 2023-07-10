
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>
	<h3>Create Lead</h3>

	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Action</th>
		<tr>
			<c:forEach var="lead" items="${leads}">
				<tr>
					<td>${lead.id}</td>
					<td>${lead.firstName}</td>
					<td>${lead.lastName}</td>
					<td>${lead.email}</td>
					<td>${lead.mobile}</td>
					<td><a href="delete?id=${lead.id}">delete</a></td>
					<td><a href="update?id=${lead.id}">update</a></td>
				<tr>
			</c:forEach>
	</table>


</body>
</html>