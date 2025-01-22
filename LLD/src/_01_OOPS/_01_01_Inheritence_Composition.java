package _01_OOPS;

class Vehicle {

	protected String type;

	public Vehicle() {
		this.type = "Generic Vehicle";
	}

	public String getType() {
		return type;
	}

	public void move() {
		System.out.println("The vehicle is moving");
	}

}

//Inheritance
class Car extends Vehicle {

	public Car() {
		super(); // Calls the constructor of the Vehicle class
	}

	@Override
	public void move() {
		System.out.println("The car is moving");

		// If Vehicle class introduces another method called peddle(), then object
		// created
		// for Car class can access this new method peddle() which might be unintended
		// behavior at child class.
	}
}

//Composition
class Car1 {
	private Vehicle vehicle; // Composition

	public Car1() {
		this.vehicle = new Vehicle(); // Car has a Vehicle
	}

	public void move() {
		System.out.println("The car1 is moving");
		vehicle.move(); // Delegating to Vehicle
	}

	public String getType() {
		return vehicle.getType(); // Delegating to Vehicle
	}
}

public class _01_01_Inheritence_Composition {

	public static void main(String[] args) {

//		Vehicle vehicle = new Vehicle();
//		vehicle.move(); // The vehicle is moving

		System.out.println();

		Car car = new Car(); // Here car object is created that contains all the instance variables and
								// methods of Vehicle as it inherits
		car.move(); // This method is called from car obj created
		System.out.println(car.getType()); // If any change to Vehicle class, the same is reflected in Car object as
											// they get inherited directly. If property or method is added or removed
											// from Vehicle, the same reflects in Car object as it directly inherits

		System.out.println();

		Car1 car1 = new Car1(); // Here Car1 obj is created that creates Vehicle obj in Car1's constructor. Car1
								// manages lifecycle of Vehicle object. Hence all the attributes of Vehicle
								// remains in Vehicle.

		car1.move(); // The car1 is moving + The vehicle is moving

		System.out.println(car1.getType()); // This method call to car1 object delegates call to Vehicle object.

		// In composition, changes to the injected object's behavior are often
		// encapsulated within the injected object, not propagated to the composed class

	}

}

/*
 * In the code you provided, the behavior of `getType()` in both the `Car`
 * (which uses inheritance) and `Car1` (which uses composition) classes is
 * indeed interesting. The key issue here revolves around how inheritance and
 * composition affect object state, specifically the `type` field in the
 * `Vehicle` class.
 * 
 * Let's break this down:
 * 
 * ### **Inheritance in the `Car` Class** - **Vehicle Class**: The `Vehicle`
 * class has a `type` field, initialized to `"Generic Vehicle"`. - **Car
 * Class**: The `Car` class extends `Vehicle` and inherits all properties and
 * methods from the `Vehicle` class. The `move()` method is overridden to print
 * `"The car is moving"`, but the `type` field remains inherited from the
 * `Vehicle` class. Therefore, when you call `getType()` on an instance of
 * `Car`, it returns the `type` value from the `Vehicle` class, which is
 * `"Generic Vehicle"`, unless modified.
 * 
 * 
 * So, when you do `car.getType()`, it will give `"Generic Vehicle"` because
 * `Car` does not change the `type` field. It's using the same field as the
 * `Vehicle` class, which was initialized to `"Generic Vehicle"` in the
 * constructor of `Vehicle`.
 * 
 * ### **Composition in the `Car1` Class** Now let's look at the `Car1` class,
 * which uses composition.
 * 
 * - **Vehicle Field**: In `Car1`, the `vehicle` field is an instance of
 * `Vehicle`, not a subclass. This means that `Car1` has an **aggregate**
 * `Vehicle` object, and it does not inherit from `Vehicle`. - When you create a
 * new `Vehicle` instance in the constructor of `Car1`, it uses the constructor
 * of `Vehicle`, which sets the `type` field to `"Generic Vehicle"`.
 * 
 * 
 * When you call `getType()` on `Car1`, it delegates the call to the `Vehicle`
 * instance it holds in the `vehicle` field. The `vehicle` object itself is
 * created independently of any changes in the `Car1` class, and its `type`
 * field is still `"Generic Vehicle"` because that’s how it was initialized in
 * the `Vehicle` constructor.
 * 
 * ### **Addressing the Question: Why Doesn't `Car1` Reflect Changes to
 * `Vehicle`?** In composition, the `Car1` class holds an **independent
 * instance** of `Vehicle`. The `Car1` object can delegate actions (like
 * `move()` or `getType()`) to the `Vehicle` instance, but it doesn’t directly
 * affect or inherit the state of `Vehicle`.
 * 
 * - The `Car1` object has its own methods and logic but delegates some actions
 * to the `Vehicle` object, which is a separate object. - The `Vehicle` object
 * in `Car1` will always hold the value of `type` as `"Generic Vehicle"` unless
 * you explicitly change it within the `Car1` class (e.g., by adding methods to
 * modify the `type` in `Car1`).
 * 
 * ### **Why `getType()` Returns the Updated Value in Both Cases** The behavior
 * of `getType()` is actually controlled by the instance of `Vehicle` (or its
 * subclass, like `Car`) that is being referenced. So when you call
 * `car.getType()`, it calls the `getType()` method on the `Car` object, which
 * will return the value of the `type` field in the `Vehicle` class (because
 * `Car` inherits from `Vehicle`).
 * 
 * In the `Car1` example, the `getType()` method calls `vehicle.getType()`,
 * which refers to the `Vehicle` instance that `Car1` holds. Since that
 * `Vehicle` instance still holds `"Generic Vehicle"`, it returns
 * `"Generic Vehicle"`.
 * 
 * If the parent `Vehicle` class is modified (i.e., if the `type` field in the
 * parent `Vehicle` is updated), then the `getType()` method in both `Car` and
 * `Car1` will reflect those changes because they both refer to the same
 * `Vehicle` object.
 * 
 * However, the `Car1` class does not track changes to the `Vehicle` object
 * unless you explicitly update it. Composition does not automatically reflect
 * changes in the parent class; it only delegates actions to the contained
 * `Vehicle` object.
 * 
 * ### **Summary** - **Inheritance (`Car`)**: The `Car` class inherits the
 * `type` field from `Vehicle`, so changes to `Vehicle` will automatically
 * reflect in `Car` objects. - **Composition (`Car1`)**: The `Car1` class
 * contains an instance of `Vehicle`, and it delegates some actions to this
 * instance. However, changes to the `Vehicle` class (or an external change to
 * the `vehicle` instance) do not automatically propagate unless the `Vehicle`
 * instance itself is updated or replaced.
 * 
 * To preserve the `type` field independently of any changes in the parent class
 * (`Vehicle`), you would need to manage the state of `type` within `Car1`
 * itself, possibly by adding setters or other methods that control its state.
 */
