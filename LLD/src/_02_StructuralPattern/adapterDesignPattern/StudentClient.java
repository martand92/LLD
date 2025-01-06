package _02_StructuralPattern.adapterDesignPattern;

import java.util.*;

public class StudentClient {

	public List<Student> getStudentList() {

		List<Student> students = new ArrayList<>();

		CollegeStudent collegeStudent = new CollegeStudent("a", "b", "c");
		SchoolStudent schoolStudent = new SchoolStudent("x", "y", "z");

		students.add(collegeStudent);

		// Without SchoolStudent Adapter pattern, as SchoolStudent class pattern is
		// different than intended Student class pattern this will throw error
		// students.add(schoolStudent); <-- throws error

		// Hence SchoolStudent class should be translated to Student class patter using
		// SchoolStudentAdapter
		students.add(new SchoolStudentAdapter(schoolStudent));

		return students;
	}

}
