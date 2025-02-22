package _02_SOLID;

interface Waiter1 {
	void serverFood();
}

interface Chef {
	void cookFood();
}

class WaiterImpl implements Waiter1 {
	@Override
	public void serverFood() {
		System.out.println("Food is served");
	}
}

class ChefImpl implements Chef {
	@Override
	public void cookFood() {
		System.out.println("Food is cooked");
	}
}

public class _04_02_InterfaceSegregation_Fix {

	public static void main(String[] args) {
		Chef chef = new ChefImpl();
		chef.cookFood();

		Waiter1 waiter = new WaiterImpl();
		waiter.serverFood();
	}
}