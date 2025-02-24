package _03_DesignPatterns._02_StructuralPattern;

/* With Bridge pattern :
 * 
 * No need to create every combination of Abstraction and Implementor. 
 * Need to create 1 hierarchy of high-level Abstraction and 1 hierarchy of low-level Implementor
 * 
 *  Using composition, any combination of abstraction and implementor can be created in runtime
 *  
 *  Both Abstraction and Implementor can vary independently
 * */

//Abstraction
abstract class Remote {

	Device device;

	Remote(Device device) {
		this.device = device;
	}

	public void powerOn() {
		this.device.switchOn();
	}

	public void powerOff() {
		this.device.switchOff();
	}
}

class TVRemote extends Remote {

	TVRemote(Device device) {
		super(device);
	}
}

//Implementor
abstract class Device {
	public abstract void switchOn();

	public abstract void switchOff();
}

class TV extends Device {

	@Override
	public void switchOn() {
		System.out.println("Switching on TV");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off TV");
	}
}

public class _04_BridgePattern {

	public static void main(String[] args) {

		Remote tvRemote = new TVRemote(new TV());// Coding to Abstraction
		tvRemote.powerOn();
		tvRemote.powerOff();
	}
}

/*
 * Here, you can create different types of remote (e.g., RadioRemote, ACRemote)
 * that can control different types of devices (e.g., Radio, AC) without
 * modifying the Remote class itself.
 */