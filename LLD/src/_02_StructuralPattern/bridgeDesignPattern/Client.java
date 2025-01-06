package _02_StructuralPattern.bridgeDesignPattern;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Device tvDevice = new TV();
		TVRemoteControl tvRemote = new TVRemoteControl(tvDevice);

		tvRemote.powerOn(); // Turns on the TV
		tvRemote.changeChannel(5); // Changes the TV channel
		tvRemote.powerOff(); // Turns off the TV

		Device radioDevice = new Radio();
		RadioRemoteControl radioRemote = new RadioRemoteControl(radioDevice);

		radioRemote.powerOn(); // Turns on the radio
		radioRemote.setFrequency(96.5); // Sets the radio frequency
		radioRemote.powerOff(); // Turns off the radio

	}

}
