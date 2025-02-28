package _03_DesignPatterns._03_BehaviouralPattern;

import java.util.*;

//Step 1 : Define Iterator of Object type T
interface Iterator<T> {
	boolean hasNext();

	T next();
}

//Step 2 : Define Iterable Collection Interface
interface IterableCollection<T> {
	Iterator<T> getIterator();
}

//Step 3 : Create concrete Iterable collection
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

//Step 4: Concrete Iterator Implementation
class CustomIterator<T> implements Iterator<T> {

	List<T> items;
	private int index = 0;

	public CustomIterator(List<T> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		return index < items.size();
	}

	@Override
	public T next() {
		return hasNext() ? items.get(index++) : null;
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
