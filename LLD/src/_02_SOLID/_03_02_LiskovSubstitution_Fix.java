package _02_SOLID;

/* To fix this, have only relevant methods in abstraction and remove all other irrelevant methods. 
 * Then have another abstraction that contains removed method from previous abstraction and have respective specific subclasses inherit this abstraction */

interface Bike1 {

	// void turnOnEngine();// removing this as its irrelevant to all subclass
	void accelerate();
}

interface BikeWithEngine extends Bike1 { // removed method could either be abstracted to another interface or directly
											// added to resp subclass if not used by multiple classes
	void turnOnEngine();
}

class Motorcycle1 implements BikeWithEngine { // Now Motorcycle inherits from more specific abstraction than generic
												// abstraction. This way we can avoid downcasting
	boolean isEngineOn;
	int speed;

	@Override
	public void turnOnEngine() {
		isEngineOn = true;

	}

	@Override
	public void accelerate() {
		speed += 10;
	}

}

// As Bicycle doesn't have an engine it inherits from Bike1 interface and avoid the need to override unnecessary methods
class Bicycle1 implements Bike1 {

	int speed;

	@Override
	public void accelerate() {
		speed += 5;
	}

}

public class _03_02_LiskovSubstitution_Fix {

	public static void main(String[] args) {

		BikeWithEngine motorCycle = new Motorcycle1();
		motorCycle.turnOnEngine();

		Bike1 cycle = new Bicycle1();
		cycle.accelerate();
	}
}
