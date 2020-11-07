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

  <script>


  function firstnameFunction() {
    var firstname = document.getElementById("f");
    const reg = /^[A-ZØÆÅ][a-zæøåA-ZØÆÅ -]{1,19}$/;
    
    if(reg.test(firstname.value)){
      	firstname.style.border="2px solid green";
  	} else {
      firstname.style.border="2px solid red";
    }
  	}
    function lastnameFunction(){
      var lastname = document.getElementById("l");
      const reg = /^[A-ZØÆÅ][a-zæøåA-ZØÆÅ-]{1,19}$/;
      if(reg.test(lastname.value)){
        lastname.style.border="2px solid green";
      }else {
        lastname.style.border="2px solid red";
      }
    }
    function phoneFunction(){
      var phone = document.getElementById("pn");
      const reg = /^[0-9]{8}$/;
      if(reg.test(phone.value)){
        phone.style.border="2px solid green";
      }else {
        phone.style.border="2px solid red";
      }
  }

    function passwordFunction(){
      var password = document.getElementById("pw");
      const reg = /^[a-zæøå]{1,8}$/;
      const reg1 = /^[a-zæøåA-ZØÆÅ-]{4,8}$/;
      const reg2 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
      if(reg.test(password.value)){
        password.style.border="2px solid red";
      
      }else if(reg1.test(password.value)){
        password.style.border="2px solid orange";

      }else if(reg2.test(password.value)){
      password.style.border="2px solid green";
      }
    }

    function repeatPasswordFunction(){
      var password = document.getElementById("pw");
      var repeatPassword = document.getElementById("rpw");

      if(password.value == repeatPassword.value){
        repeatPassword.style.border="2px solid green";
      }else {
        repeatPassword.style.border="2px solid red";
      }
    }

  </script>
    
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
		</fieldset>
	</form>
</body>
</html>