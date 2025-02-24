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

class Proxy implements Shape {

	static Shape circle; // if same object need to be shared across multiple proxies then make this
							// object static
	String key;

	Proxy(String key) {
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

public class _07_ProxyPattern {

	public static void main(String[] args) throws Exception {

		Shape proxy = new Proxy("key");
		proxy.draw();
		proxy.draw();// same Circle obj initially created will be used in multiple proxy calls

		Shape proxy1 = new Proxy("key");
		proxy1.draw();// As new proxy instance is created, it creates its own new Circle obj.

	}
}