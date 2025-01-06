package _03_DesignPatterns._03_BehaviouralPattern.observerDesignPattern;

public interface ShapeSubject {

	void addObserver(ShapeObserver observer);

	void removeObserver(ShapeObserver observer);

	void notifyObservers();
	
	String getColor();

}
