package _03_DesignPatterns._02_StructuralPattern;

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

		// Coding for abstraction
		Remote tvRemote = new TVRemote(new TV());
		tvRemote.powerOn();
		tvRemote.powerOff();
	}
}

/*
 * By using the Bridge Pattern, you can create different types of remotes (e.g.,
 * RadioRemote, ACRemote) that can control different types of devices (e.g.,
 * Radio, AC) without modifying the Remote class itself.
 */