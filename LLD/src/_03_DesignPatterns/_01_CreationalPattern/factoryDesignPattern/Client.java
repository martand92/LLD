package _03_DesignPatterns._01_CreationalPattern.factoryDesignPattern;

public class Client {
	public static void main(String[] args) {

		ShapeFactory factory = new ShapeFactory();

		Shape circle = factory.createShape("Circle");
		circle.draw();

		Shape square = factory.createShape("Square");
		square.draw();
	}

}