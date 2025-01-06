package _03_DesignPatterns._02_StructuralPattern.facadeDesignPattern;

public class BookingFacade {
	
	public void createBooking(User user){
		TicketSystem ts = new TicketSystem();
		PaymentSystem ps = new PaymentSystem();
		NotificationSystem ns = new NotificationSystem();
		
		ts.createTicket(100, user, "movieName");
		ps.chargeCard();
		ns.sendEmail(user, ts.getTicketNumber());
		ns.sendSMS(user, ts.getTicketNumber());
	}

}
