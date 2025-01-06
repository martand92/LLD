package _03_DesignPatterns._02_StructuralPattern.compositeDesignPattern;

import java.util.*;

public class CompositeShape implements ComponentShape {

	private List<ComponentShape> shapes = new ArrayList<>();

	public void addShape(ComponentShape shape) {
		shapes.add(shape);
	}

	public void removeShape(ComponentShape shape) {
		shapes.remove(shape);
	}
	
	//If this method delegates call to children of composite object.
    // If child is a leaf it executes this method for given leaf
    // if child is another composite object, then it further delegates call to its children

	
	//Hence, the operations propagate through the entire tree structure due to the recursive nature of the calls
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Composite operation");

		for (ComponentShape shape : shapes) {
			shape.draw();
		}

	}

}
