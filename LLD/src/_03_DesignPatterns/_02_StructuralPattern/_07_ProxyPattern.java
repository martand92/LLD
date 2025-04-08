package _03_DesignPatterns._02_StructuralPattern;

interface Shape {
	public void draw() throws Exception;
}

class Circle1 implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing circle");
		System.out.println();
	}
}

class CircleProxy implements Shape {

	static Shape circle; // if this obj need to be shared across multiple proxies then make it static
	String key;

	CircleProxy(String key) {
		this.key = key;
	}

	@Override
	public void draw() throws Exception {

		// Lazy loading and also avoid creating multiple end objects
		if (circle == null)
			circle = new Circle1();

		System.out.println("circle obj hash :" + circle.hashCode());

		if (isKeyValid(key))
			circle.draw();
		else
			throw new Exception("Invalid key");
	}

	public boolean isKeyValid(String key) {
		return true;
	}
}

//With factory essentially you are only providing proxy circle object and hiding actual circle object
class ShapeFactory {
	public static Shape getCircle(String key) {
		return new CircleProxy(key);
	}
}

public class _07_ProxyPattern {

	public static void main(String[] args) throws Exception {
		// for clients though it seems like they are interacting with real circle obj,
		// they are essentially with only proxy circle obj
		Shape circle = ShapeFactory.getCircle("secret");
		circle.draw();
		circle.draw();// same Circle obj initially created will be used in multiple proxy calls
	}
}