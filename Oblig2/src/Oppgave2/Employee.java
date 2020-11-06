package Oppgave2;

public class Employee {

	private String firstname;
	private String lastname;
	private Gender gender;
	private String pos;
	private int yearSalary;

	public Employee(String firstname, String lastname, Gender gender, String pos, int yearSalary) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.pos = pos;
		this.yearSalary = yearSalary;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getYearSalary() {
		return yearSalary;
	}

	public int setYearSalary(int yearSalary) {
		this.yearSalary = yearSalary;
		return this.yearSalary;
	}

	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", pos=" + pos
				+ ", yearSalary=" + yearSalary + "]";
	}

}
