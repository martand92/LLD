package _03_DesignPatterns._03_BehaviouralPattern.observerDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteShapeSubject implements ShapeSubject {

	private List<ShapeObserver> observers = new ArrayList<>();
	private String color;

	@Override
	public void addObserver(ShapeObserver observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(ShapeObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ShapeObserver observer : observers) {
			observer.update(this);
		}
	}

	// Method being called to change the Subject's state (color)
	public void setColor(String color) {

		// Changes state of the Subject
		this.color = color;

		// Then all observers are notified by sending this Subject with updated colour
		// to all observers
		notifyObservers();
	}

	@Override
	public String getColor() {
		return color;
	}

}
