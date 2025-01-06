package _02_StructuralPattern.facadeDesignPattern;

public class Client {
	public static void main(String[] args) {

		User user = new User("name", "email", "number");

		BookingFacade bookingFacade = new BookingFacade();
		bookingFacade.createBooking(user);
	}

}
