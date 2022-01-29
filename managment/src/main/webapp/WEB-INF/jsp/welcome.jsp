<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<table>
		<tr>
			<td>Welcome ${username}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="index.jsp">Home</a></td>
			
			
		</tr>
	</table>
	<form:form action = "fetching" method ="Get" modelAttribute="stock" >
	
	<table border="1">

		<th>Name</th>
		<th>arrival_date</th>
		<th>dispatch</th>
		<th>status</th>
		<th>quantity</th>
		<th>address</th>
		<th>details</th>
		

		<c:forEach var="stok" items="${stocklist}">
			<tr>
				
				<td>${stok.name}</td>
				<td>${stok.arrival_date}</td>
				<td>${stok.dispatch}</td>
				<td>${stok.status}</td>
				<td>${stok.quantity}</td>
				<td>${stok.address}</td>
				<td>${stok.details}</td>
				<td><a href="update/${stok.name}">Update</a>
				<a href="delete/${stok.name}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	 <button class="btn btn-primary btn-lg" type="submit">data</button>
	</form:form>
	
	<br>
	<br>
	<br>
	
	<a type="button" class="btn btn-primary" href="create">Insert Data</a>
	
	
</body>
</html>