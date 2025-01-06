package _03_DesignPatterns._03_BehaviouralPattern.visitorDesignPattern.doubleDispatch;

public class PrintReport {

	public void printName(Animal animal) {
		System.out.println("Animal");
	}

	public void printName(Cat cat) {
		System.out.println("Cat");
	}

	public void printName(Dog dog) {
		System.out.println("Dog");
	}
}
