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

class HomeTheaterFacade implements HomeTheater {

	@Override
	public void switchOn() {

		System.out.println("--Switching on Hometheater--");

		new Amplifier().switchOn();
		new Projector().switchOn();
		new DVDPalyer().switchOn();
		new Speaker().switchOn();
	}

	@Override
	public void switchOff() {

		System.out.println();
		System.out.println("--Switching off Hometheater--");

		new Amplifier().switchOff();
		new Projector().switchOff();
		new DVDPalyer().switchOff();
		new Speaker().switchOff();
	}

}

public class _02_FacadePattern {

	public static void main(String[] args) {
		HomeTheaterFacade facade = new HomeTheaterFacade();
		facade.switchOn();
		facade.switchOff();
	}

}
