package no.hvl.dat108;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4", name= "user1")
public class User {
	String firstname;
	String lastname;
    @Id
    private String phone;
    @Embedded
    private Password password;
    
    private String gender;
    
	public User(String firstname, String lastname, String phone, Password password, String gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
	}
	
	public User() {}
	
	public User(String firstname, String lastname, String phone, String gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Password getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Users [phonenumber=" + phone + ", password=" + password + "]";
	}

	
}
