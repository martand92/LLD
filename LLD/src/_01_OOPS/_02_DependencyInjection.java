package _01_OOPS;

class Vehicle1 {

	public void move() {
		System.out.println("Vehicle is moving");
	}
}

class Car_DirectInstantiation {

	// This Car class owns control of lifecycle of Vehicle class as its instantiated
	// here resulting in tight coupling between car and vehicle class
	Vehicle1 vehicle = new Vehicle1();

}

class Car_DependencyInjection {
	// Dependency Injection is a pattern of Composition where objects are generally
	// passed into a class rather than being directly created within that class

	// Loose Coupling : This Car class need not control lifecycle of Vehicle class
	// as its just injected and not created here. This makes it easier to swap
	// dependencies by allowing flexible composition because you can inject
	// different implementations of the same interface or class, depending on the
	// context. This makes your code easier to extend and maintain.

	// Inversion of Control (IoC): With DI, the control of how dependencies are
	// created is inverted, meaning that an external entity (like a framework or
	// container) is responsible for creating and managing dependencies, not the
	// class itself.
	Vehicle1 vehicle; // Dependency injection(form of Composition)

	public Car_DependencyInjection(Vehicle1 vehicle) {
		this.vehicle = vehicle;
	}

	public void move() {
		vehicle.move();
	}

}

public class _02_DependencyInjection {

	public static void main(String[] args) {
		Vehicle1 vehicle = new Vehicle1(); // Direct instantiation for Vehicle
		vehicle.move();

		// Vehicle is injected to Car_DependencyInjection class
		Car_DependencyInjection obj = new Car_DependencyInjection(vehicle);
		obj.move();
	}
}

/*
 * Conclusion
 * 
 * Dependency Injection is a form of composition in the sense that it promotes
 * loose coupling and allows you to compose objects in a flexible and testable
 * manner.
 * 
 * The class receiving the dependency doesn't need to know how to create it,
 * just how to use it. DI adheres to the principles of composition, as it allows
 * for flexible relationships between objects, without the class being directly
 * responsible for creating its dependencies.
 * 
 * Direct instantiation (new keyword) does not adhere to the composition
 * principle in the same way. It tightly couples a class to its dependencies,
 * making the system more rigid and less flexible.
 */