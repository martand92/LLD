package _03_DesignPatterns._01_CreationalPattern;

/* In the previous Factory example, client has to know how Factory is implemented(HTMLFactory & WindowsFactory) 
 * to be able to produce required objects of HTMLButton and WindowsButton*/

/* Below suggests more abstraction for client to not even dwell into Factory implementation
 * Use central point of decision—like a FactoryRegistry to provide correct concrete factory based on input
 * This way, the client would only need to know about the abstract layer of Factory and not the specific concrete subclass of Factory*/

interface Button1 {
	public void render();
}

class HTMLButton1 implements Button1 {
	@Override
	public void render() {
		System.out.println("Rendering HTML Button");
	}

}

class WindowsButton1 implements Button1 {
	@Override
	public void render() {
		System.out.println("Rendering Windows Button");
	}

}

interface Factory1 {
	public Button1 createButton();
}

class HTMLFactory1 implements Factory1 {
	@Override
	public Button1 createButton() {
		return new HTMLButton1();
	}
}

class WindowsFactory1 implements Factory1 {
	@Override
	public Button1 createButton() {
		return new WindowsButton1();
	}
}

//FactoryRegistry
class FactoryRegistry {

	public static Factory1 getFactory(String type) {

		switch (type) {

		case "HTML":
			return new HTMLFactory1();

		case "Windows":
			return new WindowsFactory1();

		default:
			throw new IllegalArgumentException();
		}
	}
}

//Client code
public class _01_02_FactoryPattern_FactoryRegister {

	public static void main(String[] args) {

		Factory1 htmlFactory = FactoryRegistry.getFactory("HTML");
		htmlFactory.createButton().render();

		Factory1 windowsFactory = FactoryRegistry.getFactory("Windows");
		windowsFactory.createButton().render();
	}
}
