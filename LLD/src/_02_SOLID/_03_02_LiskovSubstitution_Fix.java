package _02_SOLID;

/* To fix this, have only relevant methods in abstraction and remove all other irrelevant methods. 
 * Then have another abstraction that contains removed method from previous abstraction and have respective specific subclasses inherit this abstraction */

interface Bike1 {
	// void turnOnEngine(); // removing this method from super class as this method
	// is irrelevant to a subclass

	void accelerate();
}

interface BikeWithEngine extends Bike1 { // previous removed method is added abstracted to this interface as its
											// irrelevant to all subclasses
	void turnOnEngine();
}

class Motorcycle1 implements BikeWithEngine {

	boolean isEngineOn;
	int speed;

	@Override
	public void turnOnEngine() {
		// TODO Auto-generated method stub
		isEngineOn = true;

	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		speed += 10;
	}

}

// As Bicycle doesn't have an engine it inherits from Bike1 interface to
// accelerate
class Bicycle1 implements Bike1 {

	// Belos method which was causing issue previously is resolved when this child
	// will now behave like parent (Bike1)
//	@Override
//	public void turnOnEngine() {
//		// TODO Auto-generated method stub
//		throw new AssertionError("there is no engine");
//	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub

	}

}

public class _03_02_LiskovSubstitution_Fix {

	public static void main(String[] args) {

		BikeWithEngine motorCycle = new Motorcycle1();
		motorCycle.turnOnEngine();

		Bike1 cycle = new Bicycle1();
		cycle.accelerate();
		// cycle.turnOnEngine(); -> Throws compile time error as this method is no more
		// available for client

	}

}
