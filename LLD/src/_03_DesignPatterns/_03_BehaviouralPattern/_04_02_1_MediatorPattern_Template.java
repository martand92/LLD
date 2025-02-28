package _03_DesignPatterns._03_BehaviouralPattern;

//Step 1: Define the Mediator Interface
interface Mediator2 {
	void send(String message, Colleague sender);
}

//Step 2: Define Abstract Colleague/Component Class
abstract class Colleague {

	protected Mediator2 mediator;

	// Attach Mediator with Colleague
	public Colleague(Mediator2 mediator) {
		this.mediator = mediator;
	}

	public abstract void receive(String message);
}

//Step 3: Implement Concrete Colleague Classes
class ConcreteColleagueA extends Colleague {

	public ConcreteColleagueA(Mediator2 mediator) {
		super(mediator);
	}

	public void send(String message) {
		System.out.println("ColleagueA sending: " + message);
		mediator.send(message, this);
	}

	public void receive(String message) {
		System.out.println("ColleagueA received: " + message);
	}
}

class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator2 mediator) {
		super(mediator);
	}

	public void send(String message) {
		System.out.println("ColleagueB sending: " + message);
		mediator.send(message, this);
	}

	public void receive(String message) {
		System.out.println("ColleagueB received: " + message);
	}
}

//Step 4: Implement Concrete Mediator
class ConcreteMediator implements Mediator2 {

	private Colleague colleagueA;
	private Colleague colleagueB;

	// Register Colleague with Mediator
	public void registerColleagueA(Colleague colleague) {
		this.colleagueA = colleague;
	}

	public void registerColleagueB(Colleague colleague) {
		this.colleagueB = colleague;
	}

	public void send(String message, Colleague sender) {
		if (sender == colleagueA)
			colleagueB.receive(message);

		else if (sender == colleagueB)
			colleagueA.receive(message);

	}
}

//Step 5 : Client Code
public class _04_02_1_MediatorPattern_Template {

	public static void main(String[] args) {

		ConcreteMediator mediator = new ConcreteMediator();

		ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
		ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);

		mediator.registerColleagueA(colleagueA);
		mediator.registerColleagueB(colleagueB);

		colleagueA.send("Hello from A!");
		colleagueB.send("Hey A, this is B!");
	}
}