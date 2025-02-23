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

//Decorator extends the same type
class Decorator implements Component1 {
	protected Component1 component; // Holds reference to the base object

	public Decorator(Component1 component) {
		this.component = component;
	}

	@Override
	public void operation() {
		component.operation(); // Delegation
	}
}

//Concrete decorator adds behavior
class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component1 component) {
		super(component);
	}

	@Override
	public void operation() {
		super.operation(); // Delegate to base
		System.out.println("Extra behavior added by decorator");
	}
}

public class _01_01_Decorator_Template {
	public static void main(String[] args) {
		Component1 decorated = new ConcreteDecorator(new ConcreteComponent());
		decorated.operation();
	}
}