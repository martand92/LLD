package _03_DesignPatterns._02_StructuralPattern;

// This class is expected by Client
interface Student {

	public String getName();

	public String getSurname();

	public String getEmail();
}

class CollegeStudent implements Student {

	String name;
	String surname;
	String email;

	CollegeStudent(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getEmail() {
		return this.email;
	}
}

// this class to be returned in client's expected format
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

	SchoolStudent student;

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

public class _03_AdapterPattern {

	public static void main(String[] args) {

		Student student = new CollegeStudent("a", "b", "c");
		// Student student1 = new SchoolStudent("a", "b", "c"); compilation error as
		// SchoolStudent is not type of Student which client expects

		// So make SchoolStudent adhere to Student type using adapter
		Student schoolStudent = new StudentAdapter(new SchoolStudent("x", "y", "z"));
		System.out.println(schoolStudent.getEmail());
		// Now school student object returned as student
	}
}