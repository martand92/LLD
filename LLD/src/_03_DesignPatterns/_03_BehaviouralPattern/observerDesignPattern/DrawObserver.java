package _03_DesignPatterns._03_BehaviouralPattern.observerDesignPattern;

public class DrawObserver implements ShapeObserver {

	@Override
	public void update(ShapeSubject subject) {
		System.out.println("DrawObserver: Shape is ready to be drawn.");
	}

}
