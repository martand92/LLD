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

abstract class BeverageDecorator extends Beverage {// Decorator extends Beverage to add/modify original
													// beverage obj
	Beverage beverage;

	BeverageDecorator(Beverage beverage) { // Decorator is expecting created object to decorate
		this.beverage = beverage;
	}
}

class Mocha extends BeverageDecorator {

	Mocha(Beverage beverage) {
		super(beverage);
		this.name = "Mocha"; // Adding new name to the decorated object of type Beverage
	}

	@Override
	public int getCost() {
		return 1 + beverage.getCost(); // Accessing original object's property and updating decorated obj's cost
	}
}

public class _01_DecoratorPattern {

	public static void main(String[] args) {

		Beverage espresso = new Espresso("Espresso");
		System.out.println(espresso.name + " costs " + espresso.getCost());

		Beverage mocha = new Mocha(espresso); // Creating new decorated obj of type Beverage by passing original obj
		System.out.println(mocha.name + " costs " + mocha.getCost());
	}
}