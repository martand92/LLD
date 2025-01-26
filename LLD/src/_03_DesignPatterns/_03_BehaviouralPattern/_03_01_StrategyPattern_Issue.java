package _03_DesignPatterns._03_BehaviouralPattern;

class Application1 {

	// Sorting method directly implemented within the Application class
	public void sortArray(String algorithm) {

		if (algorithm.equalsIgnoreCase("BubbleSort"))
			bubbleSort();

		else if (algorithm.equalsIgnoreCase("QuickSort"))
			quickSort();

		else
			System.out.println("Invalid sorting algorithm specified.");

	}

	// BubbleSort logic
	private void bubbleSort() {
		System.out.println("Sorting using BubbleSort");
	}

	// QuickSort logic
	private void quickSort() {
		System.out.println("Sorting using QuickSort");
	}
}

public class _03_01_StrategyPattern_Issue {

	public static void main(String[] args) {

		Application1 app = new Application1();

		app.sortArray("BubbleSort");
		app.sortArray("QuickSort");

	}
}

/*
 * Issues:
 * 
 * The Application class contains direct logic for determining and invoking
 * specific sorting algorithms This makes the code harder to extend when a new
 * sorting algorithm is introduced (e.g., MergeSort)
 * 
 * The Application class is tightly coupled to the implementations of all
 * sorting algorithms. Any changes to the algorithms require changes to the
 * Application class
 * 
 * To add a new sorting algorithm, you must modify the Application class by
 * adding new conditions (e.g., an else if block). This violates the Open/Closed
 * Principle, which states that a class should be open for extension but closed
 * for modification
 * 
 * The decision of which sorting algorithm to use is tied to a string-based
 * condition in the sortArray method. This limits runtime flexibility and
 * increases the chances of runtime errors due to invalid input
 * 
 * 
 * The sorting logic is embedded in the Application class, making it difficult
 * to reuse the sorting algorithms independently in other parts of the
 * application
 */