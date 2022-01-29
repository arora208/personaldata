<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit window</title>
</head>
<body>
<form:form action = "updated" method ="Post" modelAttribute="stock" >
	
	
			 <%-- <c:forEach var="stk" items="${liststock}"> --%>
			
              <label>NAME</label>
              <input type="text" name = "name" <%-- value = "${stk.name}" --%> /> <br>

              <label>arrival Date</label>
              <input type="date" name= "arrival_date" <%-- value = "${stk.arrival_date}" --%> /> <br>
              
              <label>dispatch</label>
              <input type="text" name = "dispatch" <%-- value = "${stk.dispatch}" --%> /> <br>

              <label>status</label>
              <input type="text" name= "status" <%-- value = "${stk.status}"  --%>/> <br>
              
              <label>quantity</label>
              <input type="text" name = "quantity" <%-- value = "${stk.quantity}"  --%>/> <br>

              <label>address</label>
              <input type="text" name= "address" <%-- value = "${stk.address}" --%> /> <br>
              
              <label>details</label>
              <input type="text" name = "details" <%-- value = "${stk.details}" --%> />  <br>

	   <%--   </c:forEach> --%>
	 <button class="btn btn-primary btn-lg" type="submit">update</button>
	</form:form>
</body>
</html>