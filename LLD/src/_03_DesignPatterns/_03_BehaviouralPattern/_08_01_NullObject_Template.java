package _03_DesignPatterns._03_BehaviouralPattern;

//Step 1: Define an Interface or Abstract Class
interface SomeInterface {
	void doSomething();
}

//Step 2: Create a Real Object Implementation
class RealObject implements SomeInterface {
	@Override
	public void doSomething() {
		System.out.println("RealObject: Performing an action.");
	}
}

//Step 3: Create a Null Object Implementation
class NullObject implements SomeInterface {
	@Override
	public void doSomething() {
		// Do nothing or provide a default message
		System.out.println("NullObject: Doing nothing.");
	}
}

//Step 4: Factory Method to Return Real or Null Object
class ObjectFactory {
	public static SomeInterface getObject(boolean returnRealObject) {
		if (returnRealObject) {
			return new RealObject();
		}
		// Instead of returning null, return a Null Object
		return new NullObject();
	}
}

public class _08_01_NullObject_Template {

	public static void main(String[] args) {
		SomeInterface obj1 = ObjectFactory.getObject(true); // Returns RealObject
		SomeInterface obj2 = ObjectFactory.getObject(false); // Returns NullObject

		obj1.doSomething(); // Output: "RealObject: Performing an action."
		obj2.doSomething(); // Output: "NullObject: Doing nothing."
	}

}
