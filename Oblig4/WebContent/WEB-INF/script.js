

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
