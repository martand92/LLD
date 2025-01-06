package _00_SOLID;

/*Interfaces should be such that client should not implement unnecessary functions that they don't need*/

interface RestaurantEmployee {
	void washDishes();

	void serverFood();

	void cookFood();
}

class Waiter implements RestaurantEmployee {

	@Override
	public void washDishes() { // unnecessary function that need to be implemented because of not well planned
								// interface
		// TODO Auto-generated method stub
		throw new Error("Not my job");

	}

	@Override
	public void serverFood() {
		// TODO Auto-generated method stub

		System.out.println("Food is served");

	}

	@Override
	public void cookFood() {
		// TODO Auto-generated method stub
		throw new Error("Not my job");

	}

}

public class _04_01_InterfaceSegregation_Issue {
	public static void main(String[] args) {
		RestaurantEmployee employee = new Waiter();
		employee.washDishes();
		employee.serverFood();
	}

}
