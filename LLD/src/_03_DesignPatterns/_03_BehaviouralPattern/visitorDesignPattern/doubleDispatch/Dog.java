package _03_DesignPatterns._03_BehaviouralPattern.visitorDesignPattern.doubleDispatch;

public class Dog extends Animal {

	@Override
	public void printName() {
		System.out.println("Dog");
	}
	
	
	@Override
	public void accept(PrintReport report) {
		report.printName(this);

	}
}
