package _03_DesignPatterns._02_StructuralPattern;

abstract class Beverage {
	String name;

	abstract public int getCost();
}

class Espresso extends Beverage {

	Espresso(String name) {
		this.name = name;
	}

	@Override
	public int getCost() {
		return 1;
	}
}

/*
 * Decorator is added to abstraction. This ensures that the decorator
 * and the base object are interchangeable, adhering to the Liskov Substitution
 * Principle
 */
abstract class BeverageDecorator extends Beverage {

	Beverage beverage;

	BeverageDecorator(Beverage beverage) { // Composition where decorator excepts base obj
		this.beverage = beverage;
	}
}

class Mocha extends BeverageDecorator {

	Mocha(Beverage beverage) {
		super(beverage);// Delegating call to decorator's constructor by sending base obj
		this.name = "Mocha"; // updating current decorated obj
	}

	@Override
	public int getCost() {
		return 1 + beverage.getCost(); // delegating call to base obj & returning updated cost of decorated obj
	}
}

class XYZ extends BeverageDecorator {

	XYZ(Beverage beverage) {
		super(beverage);
		this.name = "XYZ";
	}

	@Override
	public int getCost() {
		return 1 + beverage.getCost();
	}
}

public class _01_02_DecoratorPattern {

	public static void main(String[] args) {

		// Base obj
		Beverage espresso = new Espresso("Espresso");
		System.out.println(espresso.name + " costs " + espresso.getCost());

		// Decorating base obj (espresso)
		Beverage mocha = new Mocha(espresso); // Decorating espresso to form Mocha
		System.out.println(mocha.name + " costs " + mocha.getCost());

		// Decorating already available decorator(Mocha)
		Beverage xyz = new XYZ(mocha);
		System.out.println(xyz.name + " costs " + xyz.getCost());

		System.out.println(espresso.name);
	}
}