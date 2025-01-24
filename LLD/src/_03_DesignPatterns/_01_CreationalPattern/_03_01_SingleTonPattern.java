package _03_DesignPatterns._01_CreationalPattern;

interface Shape {
	void draw();
}

class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing Circle");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing Square");
	}
}

//Making class as final to not extend
final class Singleton {

	// Making instance static to access without creating object for this class
	private static Singleton instance;

	// above can also be made as final but requires initialization at this step
	// private static final Singleton instance = new Singleton();

	// Make the constructor private to prevent instantiation from other classes
	private Singleton() {
	}

	public static Singleton getInstance() {

		// Lazy loading
		if (instance == null)
			instance = new Singleton();

		return instance;
	}

	public void draw(Shape shape) {
		shape.draw();
	}
}

public class _03_01_SingleTonPattern {

	public static void main(String[] args) {

		// Get the single instance of Singleton
		Singleton singleton = Singleton.getInstance();

		Shape circle = new Circle();
		Shape square = new Square();

		singleton.draw(circle);
		singleton.draw(square);

		// Verifying that only one instance of ShapeManager exists
		Singleton anotherSingleton = Singleton.getInstance();
		System.out.println(singleton == anotherSingleton); // Output: true

	}

}

/*
 * When you have subclasses that are not singleton (Circle, Square), why to have
 * Singleton class?
 * 
 * A Singleton is typically used when you have a shared resource or global state
 * that should be controlled from a single point You might want to ensure that
 * all Shape operations (ex: logging, tracking, managing) go through a single
 * central controller As managing shared resources are performance expensive,
 * limiting instantiation to single instance avoids the overhead
 * 
 * 
 * With Singleton class following operations makes sense to be performed at
 * single place on concrete non-singleton classes Logging each time a shape is
 * drawn. Tracking statistics like the total number of shapes drawn Handling
 * undo/redo operations for the shapes drawn
 * 
 * 
 * For this type of central resource management, you wouldn't want multiple
 * instances, Hence you need a singleton pattern to manage at one place
 */