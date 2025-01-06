package _02_StructuralPattern.bridgeDesignPattern;

public abstract class RemoteControl {
	
	protected Device device; // Reference to the low-level implementation
	
	public RemoteControl(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.turnOn();
    }

    public void powerOff() {
        device.turnOff();
    }


}
