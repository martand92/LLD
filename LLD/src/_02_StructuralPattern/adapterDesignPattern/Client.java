package _02_StructuralPattern.adapterDesignPattern;

import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		StudentClient client = new StudentClient();
		List<Student> studentList = client.getStudentList();
		
		System.out.println(studentList);
	}

}
