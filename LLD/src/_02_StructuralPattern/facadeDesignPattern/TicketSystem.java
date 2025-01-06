package _02_StructuralPattern.facadeDesignPattern;

public class TicketSystem {

	public void createTicket(int ticketNumber, User user, String movieName) {
		System.out.println("Created ticket");
	}

	public int getTicketNumber() {
		return (int) Math.random();
	}
}
