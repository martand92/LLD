package _02_StructuralPattern.decoratorDesignPattern;

//Then create original Shape object and then decorate (by adding color) to this shape object using decorator class
public class Main {

	public static void main(String[] args) {

		// First a basic object is created
		Shape circle = new BasicShape("Circle");

		// Then above created basic object is decorated
		Shape redCircle = new ColoredShapeDecorator(circle, "Red");

		Shape blueSquare = new ColoredShapeDecorator(new BasicShape("Square"), "Blue");

		System.out.println("Circle with color:");
		redCircle.draw();

		System.out.println("\nSquare with color:");
		blueSquare.draw();
	}

}
