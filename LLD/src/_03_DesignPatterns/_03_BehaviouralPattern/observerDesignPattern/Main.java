package _03_DesignPatterns._03_BehaviouralPattern.observerDesignPattern;

public class Main {

	public static void main(String[] args) {
		// Creating Subject
		ConcreteShapeSubject circle = new ConcreteShapeSubject();

		// Creating observers
		ColorObserver colorObserver = new ColorObserver();
		DrawObserver drawObserver = new DrawObserver();

		// Adding observers to Subject
		circle.addObserver(colorObserver);
		circle.addObserver(drawObserver);

		// Simulate a change in the Subject's state which is notified to all the
		// observers in Subject class
		circle.setColor("Red");

	}

}
