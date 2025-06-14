package _03_DesignPatterns._02_StructuralPattern;

// Target Interface : Client expected type
interface Student1 {

	public String getName();

	public String getSurname();

	public String getEmail();
}

// Legacy / adaptee class : Need to return as Student type
class SchoolStudent1 {

	String firstName;
	String lastName;
	String emailAddress;

	SchoolStudent1(String firstName, String lastName, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}
}

//Class Adapter : Inherits from Legacy SchoolStudent and adapts to new Student
class StudentAdapter1 extends SchoolStudent1 implements Student1 {

	StudentAdapter1(String firstName, String lastName, String emailAddress) {
		super(firstName, lastName, emailAddress);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return getFirstName();
	}

	@Override
	public String getSurname() {
		return getLastName();
	}

	@Override
	public String getEmail() {
		return getEmailAddress();
	}
}

public class _03_01_AdapterPattern_Inheritance {

	public static void main(String[] args) {
		// Adapt Old class as per new Adapter interface
		Student1 schoolStudent = new StudentAdapter1("x", "y", "z");
		System.out.println(schoolStudent.getEmail());
	}
}

/*
 * Disadvantage of Class based adapter pattern
 * 
 * Single Inheritance Restriction: Cannot adapt multiple classes because Java
 * does not support multiple inheritance. In Above context, cannot extend
 * another Legacy / adaptee class in addition to SchoolStudent
 * 
 * Less Flexible: Hard to switch to another adaptee at runtime. As specific
 * adaptee is extended
 * 
 * Tightly Coupled: Changes in Legacy / adaptee class affects Adapter
 * 
 */