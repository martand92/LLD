package _03_DesignPatterns._02_StructuralPattern;

/* Scenario : Company currently have old remote and old TV which works together. 
 * Now company decide to launch new TV that work's with old remote (for existing users) but also launches new remote(for new users) 
 * 
 * Hence, it requires below implementations,
 * Old remote should work with Old TV
 * Old remote should work with New TV
 * New remote should work with New TV
 * */

abstract class Device1 {
	public abstract void switchOn();

	public abstract void switchOff();
}

abstract class Remote1 {

	public abstract void powerOn();

	public abstract void powerOff();
}

//Old remote working with Old TV
class OldRemote_OldTV extends Remote1 {

	OldTV oldTV = new OldTV();

	@Override
	public void powerOn() {
		System.out.println("Switching on Old TV with Old remote");
		oldTV.switchOn();
	}

	@Override
	public void powerOff() {
		System.out.println("Switching off Old TV with Old remote");
		oldTV.switchOff();
	}
}

//Old remote working with New TV
class OldRemote_NewTV extends Remote1 {

	NewTV newTV = new NewTV();

	@Override
	public void powerOn() {
		System.out.println("Switching on New TV with Old remote");
		newTV.switchOn();
	}

	@Override
	public void powerOff() {
		System.out.println("Switching off New TV with Old remote");
		newTV.switchOff();
	}
}

//New remote working with New TV
class NewRemote_NewTV extends Remote1 {

	NewTV newTV = new NewTV();

	@Override
	public void powerOn() {
		System.out.println("Switching on New TV with New remote");
		newTV.switchOn();
	}

	@Override
	public void powerOff() {
		System.out.println("Switching off New TV with New remote");
		newTV.switchOff();
	}
}

class OldTV extends Device1 {

	@Override
	public void switchOn() {
		System.out.println("Switching on Old TV");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Old TV");
	}
}

class NewTV extends Device1 {

	@Override
	public void switchOn() {
		System.out.println("Switching on New TV");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off New TV");
	}
}

public class _04_01_WithoutBridgePattern {

	public static void main(String[] args) {

		OldRemote_OldTV oldremoteWithOldTV = new OldRemote_OldTV();
		oldremoteWithOldTV.powerOn();
		oldremoteWithOldTV.powerOff();

		OldRemote_NewTV oldremoteWithNewTV = new OldRemote_NewTV();
		oldremoteWithNewTV.powerOn();
		oldremoteWithNewTV.powerOff();

		NewRemote_NewTV newremoteWithNewTV = new NewRemote_NewTV();
		newremoteWithNewTV.powerOn();
		newremoteWithNewTV.powerOff();
	}
}

/*
 * Above implementations have following flaws: for every new concrete
 * implementation(either another TV or Remote), need to create new association
 * between Remote and TV. This results in explosion of classes for every new
 * addition of class
 * 
 * If anything changes in TV class then it affects Remote class. So both
 * Abstractor and implementor cannot vary independently
 * 
 * Duplication of code exist across classes which results in maintenance issues
 */