package _03_DesignPatterns._03_BehaviouralPattern;

//Strategy
interface Strategy {
	public void sort();
}

//Multiple implementations of Strategy
class BubbleSort implements Strategy {
	@Override
	public void sort() {
		System.out.println("Sorting using BubbleSort");
	}
}

class QuickSort implements Strategy {
	@Override
	public void sort() {
		System.out.println("Sorting using QuickSort");
	}
}

//Context or client to which any required Strategy can be added in runtime
class Application {

	Strategy algo;

	public void setStrategy(Strategy algo) {
		this.algo = algo;
	}

	public void sortArray() {
		algo.sort();
	}
}

public class _03_StrategyPattern {

	public static void main(String[] args) {

		Application app = new Application();

		// Adding Strategy to the application to sort using BubbleSort
		Strategy strategy = new BubbleSort();
		app.setStrategy(strategy);
		app.sortArray();

		strategy = new QuickSort();
		app.setStrategy(strategy);
		app.sortArray();
	}
}