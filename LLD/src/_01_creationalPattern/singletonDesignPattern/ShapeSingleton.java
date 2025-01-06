package _01_creationalPattern.singletonDesignPattern;

public class ShapeSingleton {

	// Private static instance variable to hold the single instance
	private static ShapeSingleton instance;
	public String shapeType;

	// Private constructor to prevent external instantiation
	private ShapeSingleton(String shapeType) {
		this.shapeType = shapeType;
	}

	// Public singleton method to get the single instance

	// Below presents lazy loading, only if instance is not present then initialize
	// when getInstance is called

	// if you want eager loading, then initialize while its declared
	public static ShapeSingleton getInstance(String shapeType) {
		if (instance == null) {
			instance = new ShapeSingleton(shapeType);
		}
		return instance;
	}

}
