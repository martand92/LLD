package _03_DesignPatterns._02_StructuralPattern;

import java.util.*;

interface FileComponent {
	public void showDetails();
}

class File implements FileComponent {

	String name;
	String size;

	File(String name, String size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public void showDetails() {
		System.out.println("File name : " + name + ", File size : " + size);
	}

}

//Composite
class Directory implements FileComponent {

	List<FileComponent> files = new ArrayList<FileComponent>();

	public void addFile(FileComponent file) {
		files.add(file);
	}

	public void removeFile(FileComponent file) {
		files.remove(file);
	}

	// This operation on Composite objects will continue until they are unwrapped
	// upto leaf components
	@Override
	public void showDetails() {
		for (FileComponent file : files) {
			file.showDetails();
		}
	}
}

public class _05_CompositePattern {

	public static void main(String[] args) {

		// Components / leaves
		FileComponent file1 = new File("File1", "size1");
		FileComponent file2 = new File("File2", "size2");
		file1.showDetails();
		file2.showDetails();

		// Composite to which components are added
		Directory directory1 = new Directory();
		directory1.addFile(file1);
		directory1.addFile(file2);

		System.out.println();
		System.out.println("Directory1 contains below files");
		directory1.showDetails();

		FileComponent file3 = new File("File3", "size3");
		Directory directory2 = new Directory();
		directory2.addFile(file2);
		directory2.addFile(file3);

		System.out.println();
		System.out.println("Directory2 contains below files");
		directory2.showDetails();

		// Housing above Directories in another Root directory
		Directory rootDir = new Directory();
		rootDir.addFile(directory1);
		rootDir.addFile(directory2);

		System.out.println();
		System.out.println("Root Directory contains below Directories");
		rootDir.showDetails();
	}
}