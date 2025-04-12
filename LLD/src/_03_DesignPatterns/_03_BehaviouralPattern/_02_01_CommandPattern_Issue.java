package _03_DesignPatterns._03_BehaviouralPattern;

//Receiver
interface Device1 {
	public void switchOn();

	public void switchOff();
}

class Light1 implements Device1 {

	@Override
	public void switchOn() {
		System.out.println("Switching on Light");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Light");
	}
}

class Remote1 {

	private Device1 device;

	public void setDevice(Device1 device) {
		this.device = device;
	}

	public void switchOn() {
		device.switchOn();
	}

	public void switchOff() {
		device.switchOff();
	}
}

public class _02_01_CommandPattern_Issue {

	public static void main(String[] args) {

		Device1 light = new Light1();

		// Sender directly controls receivers
		Remote1 remote = new Remote1();

		// Set the device and perform actions
		remote.setDevice(light);
		remote.switchOn();
		remote.switchOff();

	}
}

/*
 * Issues :
 * 
 * The Remote interacts directly with the Device implementations (Light or Fan),
 * without an intermediate abstraction for actions. This creates tight coupling
 * between Remote and Device classes.
 * 
 * 
 * Adding new actions (e.g., DimLight or IncreaseFanSpeed) would require
 * modifying the Remote class to include new methods for each action. This
 * violates the Open/Closed Principle as changes in behavior necessitate
 * modifying the Remote class
 * 
 * 
 * Each method in Remote directly calls the respective action (switchOn or
 * switchOff) on the Device. This makes it harder to reuse or modify the actions
 * independently of the Remote
 * 
 * 
 * No Support for Undo
 * 
 * 
 * No Encapsulation of Requests makes it harder to queue, log, or execute
 * actions in a flexible way
 */

/*
 * Here issue resembles bridge pattern where Remote and Device are still loosely
 * coupled with composition but both are still aware of each other. Goal of
 * Bridge is to evolve independently
 * 
 * But what we want is invoker to not know anything about receiver. Invoker
 * should talk to middleware which then communicates with intended receiver
 */
