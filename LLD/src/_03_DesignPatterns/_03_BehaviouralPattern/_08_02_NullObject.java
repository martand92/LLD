package _03_DesignPatterns._03_BehaviouralPattern;

//Step 1: Define an interface
interface Animal1 {
	void makeSound();
}

//Step 2: Real Object Implementation
class Dog1 implements Animal1 {
	@Override
	public void makeSound() {
		System.out.println("Woof!");
	}
}

//Step 3: Null Object Implementation
class NullAnimal implements Animal1 {
	@Override
	public void makeSound() {
		// Do nothing or provide a message
		System.out.println("No sound... it's a null animal.");
	}
}

//Step 4: Factory Method to Return Real or Null Object
class AnimalFactory {

	public static Animal1 getAnimal(String type) {

		if ("dog".equalsIgnoreCase(type))
			return new Dog1();

		// Instead of returning null, return a Null Object
		return new NullAnimal();
	}
}

//Step 5: Client Code Using the Factory
class _08_02_NullObject {

	public static void main(String[] args) {
		Animal1 myAnimal1 = AnimalFactory.getAnimal("dog");
		Animal1 myAnimal2 = AnimalFactory.getAnimal("cat"); // Not found, returns NullAnimal

		myAnimal1.makeSound(); // Output: Woof!
		myAnimal2.makeSound(); // Output: No sound... it's a null animal.
	}
}