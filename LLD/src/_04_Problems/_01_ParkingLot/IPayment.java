package _04_Problems._01_ParkingLot;

public interface IPayment {

	public boolean processPayment(int amount);

}

class CardPayment implements IPayment {

	@Override
	public boolean processPayment(int amount) {
		System.out.println("Processed payment through Card");
		return true;
	}
}

class CashPayment implements IPayment {
	@Override
	public boolean processPayment(int amount) {
		System.out.println("Processed payment through Cash");
		return true;
	}
}

class UPIPayment implements IPayment {
	@Override
	public boolean processPayment(int amount) {
		System.out.println("Processed paument through UPI");
		return true;
	}
}

//context
class PaymentStrategy {

	IPayment payment;

	PaymentStrategy(IPayment payment) {
		this.payment = payment;
	}

	public boolean processPayment(int amount) {
		payment.processPayment(amount);
		return true;
	}
}

//User facing
class PaymentService {

	PaymentStrategy paymentStrategy;

	PaymentService(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public PaymentStrategy choosePaymentStrategy(String type) {

		if (type.equals("Card"))
			return new PaymentStrategy(new CardPayment());

		else if (type.equals("Cash"))
			return new PaymentStrategy(new CashPayment());

		else if (type.equals("UPI"))
			return new PaymentStrategy(new UPIPayment());

		else
			return null;

	}

	// Process payment using user's choice of payment
	public boolean processPayment(int amount) {
		paymentStrategy.processPayment(amount);
		return true;
	}

}