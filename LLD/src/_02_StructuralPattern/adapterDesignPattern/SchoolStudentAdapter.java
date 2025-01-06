package _02_StructuralPattern.adapterDesignPattern;

public class SchoolStudentAdapter implements Student{
	
	private SchoolStudent schoolStudent;
		
	//constructor takes object that needs translation
	public SchoolStudentAdapter(SchoolStudent schoolStudent) {
		this.schoolStudent = schoolStudent;
	}

	@Override
	public String getName() {
		return this.schoolStudent.getFirstName();
	}

	@Override
	public String getSurname() {
		return this.schoolStudent.getlastname();
	}

	@Override
	public String getEmail() {
		return this.schoolStudent.getemailaddress();
	}
	
}
