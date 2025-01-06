package _03_DesignPatterns._02_StructuralPattern.decoratorDesignPattern;

//Secondly add behavior or attributes (here color) to this decorator class 
//This essentially decorates (adds color) original Shape object 
public class ColoredShapeDecorator extends ShapeDecorator {
	private String color;

	public ColoredShapeDecorator(Shape decoratedShape, String color) {
		super(decoratedShape);
		this.color = color;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		System.out.println("Color: " + color);
	}

}
