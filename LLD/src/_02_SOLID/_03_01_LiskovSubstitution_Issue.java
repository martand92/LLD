package _02_SOLID;

/*Principle : Subclass object should be able to replace Parent Class object without breaking behavior of the program
 * Subclass should extend behavior of super class and shouldn't narrow it
 * Child should behave like parent */

interface Bike {

	void turnOnEngine();

	void accelerate();
}

class Motorcycle implements Bike {

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

/*
 * Bicycle doesn't have an engine. Hence the scope of parent narrowed down in
 * child. So cannot replace object of child with object of parent because parent
 * has the method thats not working for child
 */
class Bicycle implements Bike {

	@Override
	public void turnOnEngine() {
		// TODO Auto-generated method stub
		throw new AssertionError("there is no engine");
	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub

	}

}

public class _03_01_LiskovSubstitution_Issue {

	public static void main(String[] args) {

		Bike motorCycle = new Motorcycle();
		motorCycle.turnOnEngine();

		Bike cycle = new Bicycle();
		cycle.turnOnEngine();// Now if client calls turnOnEngine with Bicycle obj referencing Bike, this will
								// throw error. Hence, child class is not behaving as same as parent

	}

}
