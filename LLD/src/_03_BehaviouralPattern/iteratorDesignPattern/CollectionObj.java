package _03_BehaviouralPattern.iteratorDesignPattern;

public class CollectionObj implements Collection {

	private Shape[] shapes;

	CollectionObj(Shape[] shapes) {
		this.shapes = shapes;
	}

	public Iterator createIterator() {
		return new IteratorObj(shapes);
	}
}
