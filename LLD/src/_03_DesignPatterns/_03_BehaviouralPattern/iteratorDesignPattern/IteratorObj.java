package _03_DesignPatterns._03_BehaviouralPattern.iteratorDesignPattern;

public class IteratorObj implements Iterator {

	// Here collection is shape
	private Shape[] collection;
	private int pos = 0;

	IteratorObj(Shape[] shapes) {
		this.collection = shapes;
	}

	@Override
	public boolean hasNext() {
		return pos < collection.length;
	}

	@Override
	public Object next() {
		if (hasNext())
			return collection[pos++];

		return null;
	}
}
