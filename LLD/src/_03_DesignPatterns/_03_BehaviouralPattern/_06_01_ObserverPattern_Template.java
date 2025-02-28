package _03_DesignPatterns._03_BehaviouralPattern;

import java.util.*;

//Step 1: Define the Observer/Subscriber interface that receives notification from publisher
interface Observer {
	void update(String message);
}

//Step 2: Define the Subject(Publisher) interface
interface Subject {
	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers(String message);
}

//Step 3: Implement Concrete Subject (Publisher)
class ConcreteSubject implements Subject {
	private List<Observer> observers = new ArrayList<>();

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}

	// Some business logic that triggers notifications
	public void newEvent(String event) {
		System.out.println("Subject: New event occurred - " + event);
		notifyObservers(event);
	}
}

//Step 4: Implement Concrete Observers (Subscribers)
class ConcreteObserverA implements Observer {
	@Override
	public void update(String message) {
		System.out.println("Observer A received: " + message);
	}
}

class ConcreteObserverB implements Observer {
	@Override
	public void update(String message) {
		System.out.println("Observer B received: " + message);
	}
}

public class _06_01_ObserverPattern_Template {

	public static void main(String[] args) {

		// Declare concrete publisher as newEvent() is only in concrete
		ConcreteSubject subject = new ConcreteSubject();

		// Concrete subscribers
		Observer observer1 = new ConcreteObserverA();
		Observer observer2 = new ConcreteObserverB();

		// Registering subscribers with publishers
		subject.registerObserver(observer1);
		subject.registerObserver(observer2);

		// Trigger an event to publisher to publish to subscribers
		subject.newEvent("Breaking News: Observer Pattern in Action!");

		System.out.println();
		System.out.println();

		// Remove an observer(subscriber) and trigger another event
		subject.removeObserver(observer1);
		subject.newEvent("Second Event: Observer A will not receive this.");
	}
}