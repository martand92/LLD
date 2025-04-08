package _03_DesignPatterns._02_StructuralPattern;

// Target Interface : Client expected type
interface Student {

	public String getName();

	public String getSurname();

	public String getEmail();
}

// Legacy / adaptee class : Need to return as Student type
class SchoolStudent {

	String firstName;
	String lastName;
	String emailAddress;

	SchoolStudent(String firstName, String lastName, String emailAddress) {
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

//Adapter to accept incompatible objects and return in client expected type
class StudentAdapter implements Student {

	SchoolStudent student;// Composition

	StudentAdapter(SchoolStudent student) {
		this.student = student;
	}

	@Override
	public String getName() {
		return student.getFirstName();
	}

	@Override
	public String getSurname() {
		return student.getLastName();
	}

	@Override
	public String getEmail() {
		return student.getEmailAddress();
	}
}

public class _03_02_AdapterPattern_Composition {

	public static void main(String[] args) {
		// So make Legacy class SchoolStudent adhere to type Student using Adapter
		Student schoolStudent = new StudentAdapter(new SchoolStudent("x", "y", "z"));
		System.out.println(schoolStudent.getEmail());
	}
}

/*
 * Advantages :
 * 
 * Can work with different adaptees. Cz of composition, can inject any adaptee
 * 
 * Supports multiple adaptees : multiple adaptees can be passed as array
 * 
 * Loose coupling : Any adaptee can be injected as adapter has composition for
 * parent
 * 
 */