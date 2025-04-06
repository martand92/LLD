package _03_DesignPatterns._01_CreationalPattern;

interface Button {
	public void render();
}

class HTMLButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering HTML Button");
	}

}

class WindowsButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering Windows Button");
	}

}

//Sole purpose of factory is to only produce and return concrete objects. Single responsibility principle
interface Factory {
	public Button createButton();
}

class HTMLFactory implements Factory {
	@Override
	public Button createButton() {
		return new HTMLButton();
		// button.render(); commenting cz its not responsibility of factory to interact
		// with concrete classes
	}
}

class WindowsFactory implements Factory {
	@Override
	public Button createButton() {
		return new WindowsButton();
		// button.render();
	}
}

//Below code enables runtime polymorphism making Factory pattern more extensible
class FactoryImpl implements Factory {

	Factory factory;

	FactoryImpl(Factory factory) {
		this.factory = factory;
	}

	public Button createButton() {
		return this.factory.createButton();
	}
}

public class _01_01_FactoryMethodPattern {

	public static void main(String[] args) {

		// Below implementation provides runtime polymorphism with FactoryImpl class
		// where client in runtime decides which factory to call to get required
		// concrete obj

		// Also this is Factory Method Pattern where required object is created by
		// calling factory method()

		Factory htmlFactory = new FactoryImpl(new HTMLFactory());
		Button htmlButton = htmlFactory.createButton();
		htmlButton.render();

		Factory windowsFactory = new FactoryImpl(new WindowsFactory());
		Button windowsButton = windowsFactory.createButton();
		windowsButton.render();

		// Without polymorphism, defining factory classes statically
		htmlFactory = new HTMLFactory();
		htmlButton = htmlFactory.createButton();
		htmlButton.render();

		windowsFactory = new WindowsFactory();
		windowsButton = windowsFactory.createButton();
		windowsButton.render();
	}
}

/*
 * Key Takeaways: The Factory Method pattern allows the client to create objects
 * without knowing the exact class of object that will be created.
 * 
 * The client just calls the createButton() method, which is implemented by
 * concrete subclasses of Factory.
 * 
 * The client can work with the Factory Abstraction without needing to know the
 * specific subclass (e.g., HTMLFactory, WindowsFactory). This allows open to
 * extension
 * 
 * Factory pattern is based on inheritance where you have a common interface or
 * abstract class, and subclasses implement the creation logic
 * 
 */
