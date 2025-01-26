package _03_DesignPatterns._03_BehaviouralPattern;

//Receiver
interface Receiver1 {
	public void displayMessage(String message);
}

class ReceiverImpl1 implements Receiver1 {

	@Override
	public void displayMessage(String message) {
		System.out.println("Receiver received Message as: " + message);
	}
}

//Sender directly communicates with Receiver
class Sender1 {

	Receiver1 receiver;

	Sender1(Receiver1 receiver) {
		this.receiver = receiver;
	}

	public void sendMessage(String message) {
		System.out.println("Sender sending message as: " + message);
		receiver.displayMessage(message);
	}
}

public class _04_01_MediatorPattern_Issue {

	public static void main(String[] args) {

		// Create receiver
		Receiver1 receiver = new ReceiverImpl1();

		// Sender communicates directly with receiver
		Sender1 sender = new Sender1(receiver);
		sender.sendMessage("Message1");
	}

}

/*
 * Issues :
 * 
 * The Sender directly calls the displayMessage method of the Receiver, leading
 * to a tight coupling between these two classes. If additional receivers are
 * introduced, the Sender would need to handle the logic of deciding which
 * receiver to communicate with
 * 
 * 
 * Any change in the communication logic (e.g., logging, transformations, or
 * additional coordination) would require modifying the Sender class. This
 * violates the Open/Closed Principle, as the Sender class needs to be changed
 * for any new communication requirements
 * 
 * 
 * Without a Mediator, introducing multiple receivers or additional senders
 * increases the complexity of managing the communication flow. For example, if
 * you need to broadcast a message to multiple receivers, you would have to
 * modify the Sender to handle a collection of receivers
 * 
 * 
 * The lack of a Mediator means there’s no single place to manage or coordinate
 * the communication between Sender and Receiver. This can lead to scattered
 * logic and duplication.
 */