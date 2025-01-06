package _03_DesignPatterns._02_StructuralPattern.decoratorDesignPattern;

//Implement the concrete Shape class 
//This is basic object which will then be decorated
public class BasicShape implements Shape {

	private String type;

	public BasicShape(String type) {
		this.type = type;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a " + type);

	}

}
