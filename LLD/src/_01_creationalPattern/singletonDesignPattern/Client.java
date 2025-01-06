package _01_creationalPattern.singletonDesignPattern;

public class Client {

	public static void main(String[] args) {

		ShapeSingleton singleton1 = ShapeSingleton.getInstance("Circle");
		ShapeSingleton singleton2 = ShapeSingleton.getInstance("Square");

		// Both references should point to the same object, Here only ShapeSingleton is
		// made as singleton not other classes
		System.out.println(singleton1 == singleton2); // This should print "true"

		// Below outputs only "Circle" as once instance of Circle is created, it cannot
		// create other instance for square
		System.out.println(singleton1.shapeType);
		System.out.println(singleton2.shapeType);

		//Below calls only circle section
		if ("Circle".equalsIgnoreCase(singleton1.shapeType)) {
			Shape circle = new Circle();
			circle.draw();

		} else if ("Square".equalsIgnoreCase(singleton2.shapeType)) {
			Shape square = new Square();
			square.draw();
		}

	}

}
