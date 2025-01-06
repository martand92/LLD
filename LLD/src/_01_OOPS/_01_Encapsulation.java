package _01_OOPS;

class BankAccount {

	private double balance; // private variable

	// Constructor
	public BankAccount(double initialBalance) {
		if (initialBalance >= 0) {
			balance = initialBalance;
		} else {
			balance = 0;
		}
	}

	// Public getter method
	public double getBalance() {
		return balance;
	}

	// Public setter method with validation
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
		}
	}
}

public class _01_Encapsulation {

	public static void main(String[] args) {

		BankAccount bankAccount = new BankAccount(0);
		// bankAccount.balance; This is not possible as balance of an account in real
		// world cannot be directly accessed

		// Hence these kind of sensitive properties / data need to be hidden and only
		// through specific ways can be accessed. Here through getBalance()
		bankAccount.getBalance();
	}
}

/*
 * Real use of Encapsulation :
 * 
 * Hiding Internal Details: Encapsulation allows you to hide the internal
 * implementation details of a class from the outside world, exposing only the
 * necessary functionality (through public methods)
 * 
 * Control over data access : Encapsulation provides a way to validate or apply
 * business logic whenever data is set or retrieved
 * 
 * Maintainability, Extensibility : Since the internal implementation is hidden,
 * changes to how the class works can be made without impacting clients until
 * public interface (methods) remains the same
 */