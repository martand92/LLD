package _03_DesignPatterns._03_BehaviouralPattern;

import java.util.*;

//Step 1 : Define Iterator of Object type T
interface Iterator<T> {
	boolean hasNext();

	T next();
}

//Step 2: Concrete Iterator Implementation
class CustomIterator<T> implements Iterator<T> {

	List<T> items;
	private int index = 0;

	public CustomIterator(List<T> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		// add custom logic to check if next obj is available
		return index < items.size();
	}

	@Override
	public T next() {
		return hasNext() ? items.get(index++) : null;
	}
}

//Step 3 : Define Iterable Collection Interface
interface IterableCollection<T> {
	Iterator<T> getIterator();
}

//Step 4 : Create concrete Iterable collection
class CustomCollection<T> implements IterableCollection<T> {
	private List<T> items = new ArrayList<>();// Iterable holds collection of objects(can be of same or different type)

	public void addItem(T item) {
		items.add(item);
	}

	@Override
	public Iterator<T> getIterator() {
		return new CustomIterator<T>(items);
	}
}

public class _05_01_IteratorPattern {

	public static void main(String[] args) {

		CustomCollection<String> collection = new CustomCollection<>();

		collection.addItem("Item 1");
		collection.addItem("Item 2");
		collection.addItem("Item 3");

		Iterator<String> iterator = collection.getIterator();

		while (iterator.hasNext())
			System.out.println(iterator.next());
	}
}

// How iterable / iterator really helps?
// Collection need not be just list with random type, but can be any collection of any data structure
// With plain list while iterating, you cannot control flow (Ex: forward, backward, pause, resume) but wrapping with iterator you can
// you can define custom filtering logic while iterating to list only filtered objects