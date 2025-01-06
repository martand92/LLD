package _03_DesignPatterns._02_StructuralPattern.adapterDesignPattern;

public class CollegeStudent implements Student{

	String name;
	String surname;
	String email;

	CollegeStudent(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return surname;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

}
