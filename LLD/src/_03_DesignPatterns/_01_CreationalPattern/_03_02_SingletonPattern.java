package _03_DesignPatterns._01_CreationalPattern;

//This example shows how to better manage global config using singleton pattern
interface Shape1 {
	void draw();
}

class Circle1 implements Shape1 {
	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		// Inform ShapeManager about the drawn shape
		ShapeManager.getInstance().shapeDrawn();
	}
}

class Square1 implements Shape1 {
	@Override
	public void draw() {
		System.out.println("Drawing Square");
		ShapeManager.getInstance().shapeDrawn();
	}
}

//Singleton class
final class ShapeManager {

	// Private static variable to hold the single instance
	private static ShapeManager instance;

	// Private field to track the number of shapes drawn
	private int shapeCount = 0;

	private ShapeManager() {
	}

	public static ShapeManager getInstance() {

		// Lazy loading
		if (instance == null)
			instance = new ShapeManager();

		return instance;
	}

	// Method to increment the shape count thats global
	void shapeDrawn() {
		shapeCount++;
		System.out.println("Shape drawn! Total shapes: " + shapeCount);
	}
}

public class _03_02_SingletonPattern {

	public static void main(String[] args) {

		Shape1 circle = new Circle1();
		Shape1 square = new Square1();

		circle.draw();
		square.draw();
	}
}

/*
 * Key Points in This Example : The ShapeManager class is a Singleton that
 * tracks the number of shapes drawn. It is designed to manage global operations
 * (e.g., counting the shapes drawn, database connections, or logging, thread
 * pool, file system access, encryption manager, caching, session management)
 * 
 * Even though Circle and Square objects are not singletons, the Singleton
 * ShapeManager is used to centralize and track all shape-related operations
 * 
 * Singleton Pattern is used for global resources or controllers that need to be
 * accessed from multiple places in your application, ensuring that only one
 * instance manages them (e.g., logging, configuration, shared state).
 */
