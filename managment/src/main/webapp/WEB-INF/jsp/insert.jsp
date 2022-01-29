<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- insert data code -->
	
	
	<form:form action = "insert" method ="Post" modelAttribute="stock" >
	
	
			
              <label>NAME</label>
              <input type="text" name = "name" placeholder = "name" /> <br>

              <label>arrival Date</label>
              <input type="date" name= "arrival_date" placeholder = "arrival_date" /> <br>
              
              <label>dispatch</label>
              <input type="text" name = "dispatch" placeholder = "dispatch" /> <br>

              <label>status</label>
              <input type="text" name= "status" placeholder = "status" /> <br>
              
              <label>quantity</label>
              <input type="text" name = "quantity" placeholder = "quantity" /> <br>

              <label>address</label>
              <input type="text" name= "address" placeholder = "address" /> <br>
              
              <label>details</label>
              <input type="text" name = "details" placeholder = "details" />  <br>


            
            ${msg}
	
	 <button class="btn btn-primary btn-lg" type="submit">data</button>
	</form:form>
	
	

</body>
</html>