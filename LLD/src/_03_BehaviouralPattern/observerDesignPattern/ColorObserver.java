package _03_BehaviouralPattern.observerDesignPattern;

public class ColorObserver implements ShapeObserver {

	@Override
	public void update(ShapeSubject subject) {
		System.out.println("ColorObserver: Shape color has changed to " + subject.getColor());
	}

}
