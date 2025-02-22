package _01_OOPS;

class Animal {
	public void sound() {
		System.out.println("Some generic animal sound");
	}
}

// Subclass (Derived Class) - Inherits Animal
class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("Bark");
	}
}

// Subclass (Derived Class) - Inherits Animal
class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("Meow");
	}
}

public class _03_ObjPolymorphism {

	public static void main(String[] args) {
		// Polymorphic behavior: Reference of type Animal but object is created specific
		// to subclasses
		Animal animal;

		animal = new Dog();
		animal.sound(); // Though ref is of parent class, method() calling specific to subclass is
						// resolved during runtime. Dynamic method dispatch

		animal = new Cat();
		animal.sound();
	}
}
