package _03_BehaviouralPattern.visitorDesignPattern.doubleDispatch;

public class Client {

	public static void main(String[] args) {

		Animal animal = new Animal();
		animal.printName(); // overriding works without issue

		animal = new Dog();
		animal.printName(); // overriding works without issue

		animal = new Cat();
		animal.printName(); // overriding works without issue

		PrintReport printReport = new PrintReport();
		// as animal stores cat object, expected OP of below should be "Cat" but we see
		// "Animal"
		System.out.println();
		System.out.println("Overloaded method not working as expected, Calling Animal class obj instead of Cat's class");
		printReport.printName(animal);
		// cz overloading happens in compile time. As type to animal obj is Animal, this
		// association happens in compile time

		// Obj references such as animal = new Dog() can happens in runtime, hence
		// overriding understands this new update but not overloading

		// If you declare reference as below then overloading works as expected
		Dog dog = new Dog();
		System.out.println();
		System.out.println("Overloaded method working as expected when obj is created with Dog class reference");
		dog.printName();// Prints as "Dog"

		// Now to overcome above overloading / compile time issue,
		// we create a intermediate visitor class that accepts obj having overloaded
		// methods (report)

		// Then implement Visitor in Animal that accepts report obj

		// Then call accept method now with animal reference but of Cat obj
		System.out.println();
		System.out.println("Below is using visitor that accepts Cat as obj for Animal reference for overloaded method");
		animal.accept(printReport);

	}

}
