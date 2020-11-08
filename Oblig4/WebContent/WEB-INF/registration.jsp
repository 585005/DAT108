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
 <style>
.tooltip {
  position: relative;
  display: inline-block;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 250px;
  background-color: black;
  color: #fff;
  text-align: left;
  border-radius: 6px;
  padding: 5px 0;

  /* Position the tooltip */
  position: absolute;
  z-index: 1;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
  top: -5px;
  left: 105%;
}
</style>

<body style="text-align:center;">

  <script src="script.js"></script>
    
	<h2>Registration</h2>
	<form action="RegistrationServlet" method="post" class="pure-form pure-form-aligned">
		<fieldset>
		
			<div class="pure-control-group">
				<label for="firstname">Firstname:</label> <input type="text" id="f" onkeyup="firstnameFunction();"
					name="firstname" value="${form.firstname}" /> 
					
					<font color="red">${form.firstnameError}</font>
					
				
			</div>
			<div class="pure-control-group">
				<label for="lastname">Lastname:</label> <input type="text" id="l" onkeyup="lastnameFunction();"
					name="lastname" value="${form.lastname}" /> 
					
					<font color="red">${form.lastnameError}</font>
					
			</div>
			<div class="pure-control-group">
				<label for="phone">Phone number (8 digits):</label> <input type="text" id="pn" onkeyup="phoneFunction();"
					name="phone" value="${form.phone}" /> 
					
					<font color="red">${form.phoneError}</font>
</div>
            <div class="pure-control-group tooltip">
                <label for="password">Password:</label> <input type="password" id="pw" onkeyup="passwordFunction();"
                    name="password" value="${form.password}" /> 

                    <span class="tooltiptext">Password rules <br>
                        <span style="color: #ff0000">Red(very weak)</span>: Containing only lowercase letters. <br>
                        <span style="color: #FFFF00">Yellow(weak)</span>: Containing uppercase and lowercase letters, but nothing more. <br>
                        <span style="color: #00FF00">Green(strong)</span>: Containing both uppcase and lowercase letters as well as a number and/or a sign.
                </span>
                
	<font color="red">${form.passwordError}</font>


            </div>		
				
			
			<div class="pure-control-group">
				<label for="repeatPassword">Repeat password:</label> <input
					type="password" id="rpw" onkeyup="repeatPasswordFunction();" name="repeatPassword"
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
			<p>
			 Already have an account? <a href="http://localhost:8080/oblig4/LoginServlet">click here</a>
			</p>
		</fieldset>
	</form>
</body>
</html>