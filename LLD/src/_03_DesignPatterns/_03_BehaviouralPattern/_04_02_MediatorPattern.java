package _03_DesignPatterns._03_BehaviouralPattern;

import java.util.*;

interface Receiver { // Component
	public void displayMessage(String message);
}

//End object with which original object is trying to communicate
class ReceiverImpl implements Receiver {

	String name;

	ReceiverImpl(String name) {
		this.name = name;
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(name + " received Message as : " + message);
	}
}

interface Mediator {
	public void sendMessage(String message);
}

class MediatorImpl implements Mediator {

	List<Receiver> receivers = new ArrayList<Receiver>(); // Mediator can also help with publish-subscribe

	public void addReceivers(Receiver receiver) {
		receivers.add(receiver);
	}

	@Override
	public void sendMessage(String message) {
		for (Receiver receiver : receivers)
			receiver.displayMessage(message);
	}
}

class Sender { // Component

	Mediator mediator; // As long as the component works with its mediator via the generic interface,
						// you can link the component with a different implementation of the mediator

	Sender(Mediator mediator) {
		this.mediator = mediator;
	}

	public void sendMessage(String message) {
		this.mediator.sendMessage(message);
	}
}

public class _04_02_MediatorPattern {

	public static void main(String[] args) {

		MediatorImpl mediator = new MediatorImpl();
		mediator.addReceivers(new ReceiverImpl("Receiver1"));
		mediator.addReceivers(new ReceiverImpl("Receiver2"));

		Sender sender = new Sender(mediator);
		sender.sendMessage("Message1");
	}

}

/*
 * Advantages :
 * 
 * The Sender and Receiver are decoupled. They only depend on the Mediator, not
 * on each other. This makes the system more flexible and easier to maintain
 * 
 * The Mediator acts as the central hub for all communication, making it easier
 * to control, extend, and manage the communication flow.
 * 
 * New receivers or sender can be added without modifying the existing Sender or
 * Receiver classes. Only the Mediator needs to be updated to handle the new
 * components
 * 
 * 
 * The Sender is only responsible for sending messages, and the Receiver is only
 * responsible for processing messages. The Mediator handles the coordination,
 * adhering to the Single Responsibility Principle
 * 
 * If communication between multiple receivers and senders becomes more complex
 * (e.g., group messaging, broadcasting), the Mediator can handle this logic
 * without affecting the Sender or Receiver
 * 
 */