package _03_DesignPatterns._02_StructuralPattern.adapterDesignPattern;

public class SchoolStudent {
	
	String firstname;
	String lastname;
	String emailaddress;

	SchoolStudent(String name, String surname, String email) {
		this.firstname = name;
		this.lastname = surname;
		this.emailaddress = email;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getlastname() {
		return lastname;
	}
	
	public String getemailaddress() {
		return emailaddress;
	}

}
