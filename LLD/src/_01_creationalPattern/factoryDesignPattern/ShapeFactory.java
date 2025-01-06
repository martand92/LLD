package _01_creationalPattern.factoryDesignPattern;

public class ShapeFactory {

	public Shape createShape(String shapeType) {

		if ("Circle".equalsIgnoreCase(shapeType))
			return new Circle();

		else if ("Square".equalsIgnoreCase(shapeType))
			return new Square();

		else
			return null;
	}
}
