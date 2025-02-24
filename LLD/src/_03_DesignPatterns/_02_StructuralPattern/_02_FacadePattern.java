package _03_DesignPatterns._02_StructuralPattern;

interface HomeTheater {

	public void switchOn();

	public void switchOff();
}

class Amplifier implements HomeTheater {

	@Override
	public void switchOn() {
		System.out.println("Switching on Amplifier");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Amplifier");
	}
}

class Projector implements HomeTheater {

	@Override
	public void switchOn() {
		System.out.println("Switching on Projector");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Projector");
	}
}

class DVDPalyer implements HomeTheater {

	@Override
	public void switchOn() {
		System.out.println("Switching on DVDPlayer");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off DVDPlayer");
	}
}

class Speaker implements HomeTheater {

	@Override
	public void switchOn() {
		System.out.println("Switching on Speaker");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Speaker");
	}
}

//Facade need not implement or extend Component as Facade can be collection of heterogeneous operations
class HomeTheaterFacade implements HomeTheater {

	@Override
	public void switchOn() {

		System.out.println("--Switching on Hometheater--");
		new Amplifier().switchOn();
		new Projector().switchOn();
		new DVDPalyer().switchOn();
		new Speaker().switchOn();
		System.out.println();
	}

	@Override
	public void switchOff() {

		System.out.println("--Switching off Hometheater--");
		new Amplifier().switchOff();
		new Projector().switchOff();
		new DVDPalyer().switchOff();
		new Speaker().switchOff();
		System.out.println();
	}

}

public class _02_FacadePattern {

	public static void main(String[] args) {
		//Client only interacts with Facade
		HomeTheaterFacade facade = new HomeTheaterFacade();
		facade.switchOn();
		facade.switchOff();
	}

}
