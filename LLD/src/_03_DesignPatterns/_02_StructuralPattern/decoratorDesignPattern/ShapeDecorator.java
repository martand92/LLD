package _03_DesignPatterns._02_StructuralPattern.decoratorDesignPattern;

//First Create decorator class that implement  original / initial Shape interface 
//This is same as basic shape class only which will be extended by a decorator class to decorate this class's object
//Original class Shape remains untouched
public class ShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	// Will continue using Basic class's attributes in addition to decorator class's
	// attributes
	@Override
	public void draw() {
		decoratedShape.draw();
	}

}
