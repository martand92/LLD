package _01_OOPS;

abstract class Vehicle2 {
	public void start() {
		System.out.println("Vehicle started");
	}

	public void stop() {
		System.out.println("Vehicle stopped");
	}
}

class Refuelable {
	public void refuel() {
		System.out.println("Refueling vehicle");
	}
}

class Kickstand {
	public void deploy() {
		System.out.println("Kick stand deployed");
	}
}

/*
 * Car uses composition to have Refuelable, meaning object with type Car
 * supports specific behavior like refueling
 * 
 * Bike uses composition to have Kickstand, meaning object with type Bike
 * supports specific behavior like deploying kickstand
 * 
 * Hence no need to specifically downcast to subclasses to make use of
 * subclass's behavior
 */
class Car2 extends Vehicle2 {

	private Refuelable refuelable;

	public Car2() {
		refuelable = new Refuelable(); // Car can refuel
	}

	public void refuel() {
		refuelable.refuel(); // Delegate to Refuelable
	}
}

// 
class Bike2 extends Vehicle2 {

	private Kickstand kickstand;

	public Bike2() {
		kickstand = new Kickstand(); // Bike can deploy a kickstand
	}

	public void deployKickstand() {
		kickstand.deploy(); // Delegate to Kickstand
	}
}

public class _04_03_AvoidDownCasting_Composition {

	public static void main(String[] args) {

		Car2 car = new Car2();
		car.start();
		car.refuel();

		Bike2 bike = new Bike2();
		bike.start();
		bike.deployKickstand();

	}
}
