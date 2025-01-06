package _02_StructuralPattern.bridgeDesignPattern;

public class RadioRemoteControl extends RemoteControl {
	
	public RadioRemoteControl(Device device) {
		super(device);
	}

	// Additional methods specific to Radio remote control
	public void setFrequency(double frequency) {
		System.out.println("Setting radio frequency to " + frequency);
	}

}
