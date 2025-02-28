package _03_DesignPatterns._03_BehaviouralPattern;

import java.util.*;

interface Publisher {

	public void addSubscriber(Subscriber subscriber);

	public void removeSubscriber(Subscriber subscriber);

	public void notifySubscribers();
}

class PublisherImpl implements Publisher {

	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	private String color;

	@Override
	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscribers() {
		for (Subscriber subscriber : subscribers)
			subscriber.update(this); // Publisher is passed to subscriber to allow subscriber to access state
	}

	public void setColor(String color) {
		this.color = color;
		notifySubscribers();
	}

	public String getColor() {
		return color;
	}

}

interface Subscriber {
	public void update(PublisherImpl publisher);
}

class ColorSubscriber implements Subscriber {

	@Override
	public void update(PublisherImpl publisher) {

		// using publisher's object to get updated state of the publisher. i.e,
		// publisher is initially pushing itself to all the subscribers using notify()
		// but then subscriber pulls the state /data from the publisher
		System.out.println("Color changed to : " + publisher.getColor());
	}
}

class DrawSubscriber implements Subscriber {

	@Override
	public void update(PublisherImpl publisher) {
		System.out.println("Subscriber shape is ready to be drawn");
	}
}

public class _06_02_ObserverPattern {

	public static void main(String[] args) {

		// Creating publisher
		PublisherImpl publisher = new PublisherImpl();

		// Creating 2 subscribers
		Subscriber colorSubscriber = new ColorSubscriber();
		Subscriber drawSubscriber = new DrawSubscriber();

		// Adding Subscribers to Publishers
		publisher.addSubscriber(colorSubscriber);
		publisher.addSubscriber(drawSubscriber);

		// An event occurred in Publisher
		publisher.setColor("Red");
	}
}
