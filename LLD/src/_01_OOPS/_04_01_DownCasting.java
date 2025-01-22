package _01_OOPS;

class Animal1 {

	public void sound() {
		System.out.println("Some generic animal sound");
	}

}

class Dog1 extends Animal1 {
	@Override
	public void sound() {
		System.out.println("Dog sound");
	}

	public void bark() {
		System.out.println("Dog barks");
	}
}

class Cat1 extends Animal1 {
	@Override
	public void sound() {
		System.out.println("Cat sound");
	}

	public void whispers() {
		System.out.println("Cat whispers");
	}
}

public class _04_01_DownCasting {

	public static void main(String[] args) {

		Animal1 dog = new Dog1();
		Animal1 cat = new Cat1();

		dog.sound();
		cat.sound();

		// dog.bark();Compilation error

		// Downcast dog to respective subclass
		((Dog1) dog).bark();

	}
}

/*
 * Downcasting introduces a few potential issues:
 * 
 * Code smell : With downcasting in your code, you initially say you accept
 * object of parent class but internally you make this object more specific to
 * child class to access specific methods to this child class.
 * 
 * Breaking Encapsulation: By downcasting, you're effectively bypassing the
 * abstraction provided by the parent class (Ex: Animal). Now instead of working
 * with parent class/interface you are directly interacting with child-specific
 * methods. This breaks the design principle of abstraction, where you should
 * ideally only need to work with the parent class interface if you're dealing
 * with polymorphism.
 * 
 * Loss of Flexibility: If you downcast to a specific subclass, your code
 * becomes tightly coupled to that subclass. Now your code that says it accepts
 * Parent class's objects will necessarily only work on specific subclass cz of
 * downcasting. This causes ambiguity and looses flexibility and extensibility
 * 
 * Ambiguity : Say this class has constructor that instantiates object with
 * Abstract reference (Ex: Animal) but downcasts to specific class. Now client
 * sends an concrete object of different subclass but referring to same
 * abstract. Your class throws error as internally you have downcasted to
 * specific subclass(say Dog) but you received another subclass object (say Cat)
 * and causes Ambiguity
 */
