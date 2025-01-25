package _03_DesignPatterns._02_StructuralPattern;

import java.util.*;

interface Component {
	public void draw();
}

//Leaf
class Circle implements Component {
	@Override
	public void draw() {
		System.out.println("Drawing circle");
	}
}

//Leaf
class Square implements Component {
	@Override
	public void draw() {
		System.out.println("Drawing square");
	}
}

class Composite implements Component {

	List<Component> compositeList = new ArrayList<Component>();

	public void addComponent(Component component) {
		compositeList.add(component);
	}

	public void removeComponent(Component component) {
		compositeList.remove(component);
	}

	@Override
	public void draw() {
		for (Component component : compositeList) {
			component.draw();
		}
	}
}

public class _05_01_CompositePattern {

	public static void main(String[] args) {

		Component circle = new Circle();
		Component square = new Square();

		Composite composite = new Composite();
		composite.addComponent(circle);
		composite.addComponent(square);

		// operations of component uniform across leaf and composite
		circle.draw();
		System.out.println();
		composite.draw();
	}
}
