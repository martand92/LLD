package _03_DesignPatterns._03_BehaviouralPattern;

//Strategy
interface Sort {
	public void sort();
}

//Multiple implementations of Strategy
class BubbleSort implements Sort {
	@Override
	public void sort() {
		System.out.println("Sorting using BubbleSort");
	}
}

class QuickSort implements Sort {
	@Override
	public void sort() {
		System.out.println("Sorting using QuickSort");
	}
}

//Context or client to which any required Strategy can be added in runtime
class Strategy {

	Sort algo;

	public void setStrategy(Sort algo) {
		this.algo = algo;
	}

	public void sortArray() {
		algo.sort();
	}
}

public class _03_03_StrategyPattern {

	public static void main(String[] args) {

		Strategy strategy = new Strategy();

		// Adding Strategy to the application to sort using BubbleSort

		strategy.setStrategy(new BubbleSort());
		strategy.sortArray();
		strategy.setStrategy(new QuickSort());
		strategy.sortArray();
	}
}