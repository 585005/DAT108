<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Log in</title>
</head>
<body>
	<h2>Log in</h2>
	
	<p>Only registered participants are allowed to see the participants list.</p>
	
	<c:choose>
    <c:when test="${error=='1'}">
	<p>
		<font color="red">The user does not exist</font>
	</p>
        <br />
          </c:when> 
          <c:when test="${error=='2'}">
          <p>
          	<font color="red">Invalid phone number or password</font>
          	</p>
          	<br />
          	</c:when>
        </c:choose>
	
	<form action="LoginServlet" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="phone">Phone-number:</label> <input type="text" name="phone" />
			</div>
			<div class="pure-control-group">
				<label for="password">Password:</label> <input type="password"
					name="password" />
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Log
					in</button>
			</div>
			<p>Don't have a user?</p>
			
			<a href="http://localhost:8080/oblig4/RegistrationServlet">Create an account</a> 
			
		</fieldset>
	</form>

</body>
</html>