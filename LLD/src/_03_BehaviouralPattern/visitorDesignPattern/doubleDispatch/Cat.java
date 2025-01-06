package _03_BehaviouralPattern.visitorDesignPattern.doubleDispatch;

public class Cat extends Animal {

	@Override
	public void printName() {
		System.out.println("Cat");
	}
	
	@Override
	public void accept(PrintReport report) {
		report.printName(this);

	}
}
