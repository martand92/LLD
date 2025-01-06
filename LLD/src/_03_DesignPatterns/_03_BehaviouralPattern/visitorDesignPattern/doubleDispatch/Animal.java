package _03_DesignPatterns._03_BehaviouralPattern.visitorDesignPattern.doubleDispatch;

public class Animal implements Visitor {

	public void printName() {
		System.out.println("Animal");
	}

	@Override
	public void accept(PrintReport report) {
		report.printName(this);

	}
}
