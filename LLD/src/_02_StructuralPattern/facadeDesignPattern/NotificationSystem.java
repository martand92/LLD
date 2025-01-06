package _02_StructuralPattern.facadeDesignPattern;

public class NotificationSystem {

	public void sendEmail(User user, int ticketNumber) {
		System.out.println("Sent email");
	}
	
	public void sendSMS(User user, int ticketNumber) {
		System.out.println("Sent SMS");
	}

}
