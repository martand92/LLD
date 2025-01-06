package _03_BehaviouralPattern.iteratorDesignPattern;

public class Client {

	public static void main(String[] args) {
		Shape[] shapes = { new Circle(), new Square() };

		// Encapsulate above array collection within collection object
		Collection collectionObj = new CollectionObj(shapes);

		// Then associate iterator with above collection obj
		// i.e, when this iterator is used then it runs on above collection obj which
		// holds array of shapes
		Iterator iterator = collectionObj.createIterator();

		while (iterator.hasNext()) {
			Shape shape = (Shape) iterator.next();
			shape.draw();
		}
	}

}
