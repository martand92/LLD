package _03_DesignPatterns._02_StructuralPattern;

interface Component1 {
	void operation();
}

class ConcreteComponent implements Component1 {
	@Override
	public void operation() {
		System.out.println("Base Operation");
	}
}

//Decorator that decorates / wraps  base object using composition
class Decorator implements Component1 {
	protected Component1 component; // Holds reference to the base object

	public Decorator(Component1 component) {
		this.component = component;
	}

	@Override
	public void operation() {
		component.operation(); // Delegating to base object method
	}
}

//Second Decorator that decorates / wraps inner decorator using composition
class SecondDecorator extends Decorator {

	public SecondDecorator(Component1 component) {
		super(component);//Calling inner decorator constructor
	}

	@Override
	public void operation() {
		super.operation(); // Delegate call to inner decorator which calls object's method 
		System.out.println("Extra behavior added by decorator");
	}
}

public class _01_01_Decorator_Template {

	public static void main(String[] args) {
		Component1 decorated = new SecondDecorator(new ConcreteComponent());
		decorated.operation();
	}
}