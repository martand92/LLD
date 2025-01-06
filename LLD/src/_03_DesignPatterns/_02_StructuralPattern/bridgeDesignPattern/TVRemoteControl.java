package _03_DesignPatterns._02_StructuralPattern.bridgeDesignPattern;

public class TVRemoteControl extends RemoteControl {
	
	public TVRemoteControl(Device device) {
		super(device);
	}
	
	// Additional methods specific to TV remote control
    public void changeChannel(int channel) {
        System.out.println("Changing TV channel to " + channel);
    }


}
