package no.hvl.dat108;



public class Form {
	
	private String firstname;
	private String firstnameError;
	private String lastname;
	private String lastnameError;
	private String phone;
	private String phoneError;
	private String password; 
	private String passwordError;
	private String repeatPassword;
	private String repeatPasswordError;
	private String gender;
	private String genderError;
	private UserDAO userDAO;
	
	public Form(String firstname, String lastname, String phone, String password, String repeatPassword, String gender, UserDAO userDAO) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.gender = gender;
		this.userDAO = userDAO;
	}
	
	public boolean isAllInputValid() {
		return Validator.validateInput(firstname, lastname, phone, password, repeatPassword, gender, userDAO);
	}
	
	public void findError() {
		if(!Validator.validateFirstname(firstname)) {
			firstname = "";
			firstnameError = "Invalid firstname";
		}
		if(!Validator.validateLastname(lastname)) {
			lastname = "";
			lastnameError = "Invalid lastname";
		}
		if(!Validator.validatePhone(phone, userDAO)) {
			phone = "";
			phoneError = "invalid phonenumber";
		}
		if(!Validator.validatePassword(password)) {
			password = "";
			passwordError = "Invalid password";
		}
		if(!Validator.validateRepeatPassword(password, repeatPassword)) {
			repeatPassword = "";
			repeatPasswordError = "The repeated password do not match the first password";
		}
		if(!Validator.validateGender(gender)) {
			
			genderError = "Pick a gender";
		}
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstnameError() {
		return firstnameError;
	}

	public void setFirstnameError(String firstnameError) {
		this.firstnameError = firstnameError;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastnameError() {
		return lastnameError;
	}

	public void setLastnameError(String lastnameError) {
		this.lastnameError = lastnameError;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneError() {
		return phoneError;
	}

	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordError() {
		return passwordError;
	}

	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getRepeatPasswordError() {
		return repeatPasswordError;
	}

	public void setRepeatPasswordError(String repeatPasswordError) {
		this.repeatPasswordError = repeatPasswordError;
	}
	public String getGender() {
		return gender;
	}
	public String getGenderError() {
		return genderError;
	}
	
	

}
