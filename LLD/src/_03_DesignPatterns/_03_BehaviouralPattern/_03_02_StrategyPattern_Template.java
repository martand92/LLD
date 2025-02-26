package _03_DesignPatterns._03_BehaviouralPattern;

//In strategy pattern, logic/algo used to carry operation is objectified

interface Strategy1 {

	public void executeAlgo();
}

class ConcreteStrategy1 implements Strategy1 {
	@Override
	public void executeAlgo() {
		System.out.println("Execute first algo");
	}
}

class ConcreteStrategy2 implements Strategy1 {
	@Override
	public void executeAlgo() {
		System.out.println("Execute second algo");
	}
}

//Delegates to Strategy
class Context {

	Strategy1 strategy;

	Context(Strategy1 strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy() {
		this.strategy.executeAlgo();
	}
}

public class _03_02_StrategyPattern_Template {

	public static void main(String[] args) {

		// Client switches algo in runtime
		Context client = new Context(new ConcreteStrategy1());
		client.executeStrategy();

		client = new Context(new ConcreteStrategy2());
		client.executeStrategy();
	}
}

/*
 * When you need to dynamically switch between multiple algorithms (e.g.,
 * sorting, payment processing, compression).
 * 
 * When you want to encapsulate behavior variations in different classes,
 * avoiding conditional logic.
 * 
 * When you need to decouple algorithm selection from the main class, improving
 * flexibility and maintainability.
 */