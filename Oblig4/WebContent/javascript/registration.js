
function validateForm() {
	var firstname = document.forms["myForm"]["firstname"].value;
	var lastname = document.forms["myForm"]["lastname"].value;
	var phone = document.forms["myForm"]["phone"].value;
	var password = document.forms["myForm"]["password"].value;
	var repeatPassword = document.forms["myForm"]["repeatPassword"].value;
	
	
}

function validateFirstname() {
	var firstname = document.getElementById("f");
	if(firstname == ""){
		firstname.style.backgroundColor = "red";
	}
	else {
		firstname.style.backgroundColor = "";
	}	
	
	function validatePassword() {
		
		if(password < 8){
			
			alert("Password: Weak, invalid length");
			return false;
		}if(password > 10){
			alert("Password: Medium"):
			return true;
		}if(password > 12){
			alert("Password: Strong"):
			return true;
		}
	}
	
	function validateRepeatPassword(){
		var password = document.getElementById("pw");
		var repeatPassword = document.getElementById("rpw");
		var n = password.localeCompare(repeatPassword);
		if(n==0){
			repeatPassword.style.backgroundColor = "green";
			return true;
		}
	}
}