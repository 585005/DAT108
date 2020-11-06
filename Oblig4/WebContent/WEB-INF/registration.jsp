<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="no.hvl.dat108.Form" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Registration</title>
</head>
<body>
	<h2>Registration</h2>
	<form action="RegistrationServlet" method="post" class="pure-form pure-form-aligned">
		<fieldset>
		
			<div class="pure-control-group">
				<label for="firstname">Firstname:</label> <input type="text"
					name="firstname" value="${form.firstname}" /> 
					
					<font color="red">${form.firstnameError}</font>
			</div>
			<div class="pure-control-group">
				<label for="lastname">Lastname:</label> <input type="text"
					name="lastname" value="${form.lastname}" /> 
					
					<font color="red">${form.lastnameError}</font>
			</div>
			<div class="pure-control-group">
				<label for="phone">Phone number (8 digits):</label> <input type="text"
					name="phone" value="${form.phone}" /> 
					
					<font color="red">${form.phoneError}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Password:</label> <input type="password"
					name="password" value="${form.password}" /> 
					
					<font color="red">${form.passwordError}</font>
			</div>
			<div class="pure-control-group">
				<label for="repeatPassword">Repeat password:</label> <input
					type="password" name="repeatPassword"
					value="${form.repeatPassword}" /> 
					
					<font color="red">${form.repeatPasswordError}</font>
			</div>
			<div class="pure-control-group">
				<label for="gender">Gender:</label> <input type="radio" name="gender"
					value="male"
					 />male
				<input type="radio" name="gender" value="female"
					 />female
				<font color="red">${form.genderError}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Register</button>
			</div>
		</fieldset>
	</form>
</body>
</html>