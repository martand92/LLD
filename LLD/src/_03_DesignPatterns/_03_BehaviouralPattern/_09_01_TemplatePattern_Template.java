package _03_DesignPatterns._03_BehaviouralPattern;

//Step 1: Define an Abstract Class with a Template Method
abstract class AbstractTemplate {

	// Template method defining the structure of the algorithm
	public final void templateMethod() {
		stepOne();
		stepTwo();
		stepThree();
	}

	// Common step with a default implementation
	protected void stepOne() {
		System.out.println("Step 1: Common implementation.");
	}

	// Steps that must be implemented by subclasses
	protected abstract void stepTwo();

	protected abstract void stepThree();
}

//Step 2: Concrete Implementation 1
class ConcreteClassA extends AbstractTemplate {
	@Override
	protected void stepTwo() {
		System.out.println("ConcreteClassA: Step 2 implementation.");
	}

	@Override
	protected void stepThree() {
		System.out.println("ConcreteClassA: Step 3 implementation.");
	}
}

//Step 3: Concrete Implementation 2
class ConcreteClassB extends AbstractTemplate {
	@Override
	protected void stepTwo() {
		System.out.println("ConcreteClassB: Different Step 2 implementation.");
	}

	@Override
	protected void stepThree() {
		System.out.println("ConcreteClassB: Different Step 3 implementation.");
	}
}

//Step 4: Client Code Using the Template Method
public class _09_01_TemplatePattern_Template {

	public static void main(String[] args) {
		AbstractTemplate obj1 = new ConcreteClassA();
		AbstractTemplate obj2 = new ConcreteClassB();

		System.out.println("Executing Template for ConcreteClassA:");
		obj1.templateMethod();

		System.out.println("\nExecuting Template for ConcreteClassB:");
		obj2.templateMethod();
	}

}
