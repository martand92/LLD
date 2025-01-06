package _03_DesignPatterns._02_StructuralPattern.compositeDesignPattern;

public class Client {

	public static void main(String[] args) {

		// Create leaf objects
		Circle circle = new Circle();
		Square square = new Square();

		// Create composite object that contains above leaves as children
		CompositeShape composite = new CompositeShape();
		composite.addShape(circle);
		composite.addShape(square);

		// Above composite object acts as child to another bigger composite object
		CompositeShape biggerComposite = new CompositeShape();
		biggerComposite.addShape(composite);

		// This will directly print leave draw()
		System.out.println("Drawing individual shapes:");
		circle.draw();
		square.draw();

		// This will print composite object draw() which internally delegates to
		// operation to its children (both leaf nodes in this case as composite has
		// circle and square)
		System.out.println("\nDrawing composite shapes:");
		composite.draw();

		// This will delegate operation to its child = composite object which further
		// delegates operation to its children (circle and square).
		System.out.println("\nDrawing a bigger composite shape:");
		biggerComposite.draw();

	}

}
