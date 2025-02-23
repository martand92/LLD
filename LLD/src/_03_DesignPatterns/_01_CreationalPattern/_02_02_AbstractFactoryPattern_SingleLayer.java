package _03_DesignPatterns._01_CreationalPattern;

//In this example, implementing Abstract factory to return same family objects without having factory layer

//Button implemented as WindowsButton and MacButton
interface Button3 {
	void render();
}

class WindowsButton3 implements Button3 {
	public void render() {
		System.out.println("Rendering a Windows button");
	}
}

class MacButton2 implements Button3 {
	public void render() {
		System.out.println("Rendering a Mac button");
	}
}

//Checkbox implemented as WindowsCheckbox and MacCheckbox
interface Checkbox {
	void render();
}

class WindowsCheckbox implements Checkbox {
	public void render() {
		System.out.println("Rendering a Windows checkbox");
	}
}

class MacCheckbox implements Checkbox {
	public void render() {
		System.out.println("Rendering a Mac checkbox");
	}
}

//End goal of this Abstract Factory is to return final concrete objects Button and checkbox belonging to same family(Mac / Windows)
//Here simply returning 2 end objects directly without having another factory layer, as this abstract factory layer itself creates end objects 
interface GUIFactory {
	Button3 createButton();

	Checkbox createCheckbox();
}

//Concrete Factories for abstract layer
class WindowsFactory2 implements GUIFactory {
	public Button3 createButton() {
		return new WindowsButton3();
	}

	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}

class MacFactory implements GUIFactory {
	public Button3 createButton() {
		return new MacButton2();
	}

	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}

//Client accepts abstract factory instance and creates specific end object (button & checkbox) and renders
class Application {
	private Button3 button;
	private Checkbox checkbox;

	public Application(GUIFactory factory) {
		button = factory.createButton();
		checkbox = factory.createCheckbox();
	}

	public void renderUI() {
		button.render();
		checkbox.render();
	}
}

public class _02_02_AbstractFactoryPattern_SingleLayer {
	public static void main(String[] args) {
		Application app = new Application(new MacFactory());// Could switch to WindowsFactory dynamically
		app.renderUI();
	}
}

/*
 * Hence its not necessary to have another layer of Abstraction for concrete
 * objects with Factory when Abstract factory can directly help with creating
 * concrete instance
 * 
 * 
 * So when to use single Abstract Factory layer and 2 layer (Abstract factory +
 * factory) layers?
 * 
 * Single Layer Approach (Direct Abstract Factory): This is the most common
 * approach for simpler use cases where the creation of related products is not
 * complex.
 * 
 * It works well when the products are directly related and the factory doesn't
 * need to manage multiple levels of complexity.
 * 
 * 
 * 
 * Layered Approach (Abstract Factory + Product Factories): This approach is
 * useful when:
 * 
 * You have complex product creation logic or need to break down the product
 * creation into multiple sub-categories.
 * 
 * You want to separate the concerns of creating different families of products
 * into smaller, reusable components. You foresee adding more product categories
 * or variations in the future and want to keep the system modular and
 * extensible.
 * 
 * 
 * the single-layer abstract factory approach is perfectly valid and is more
 * common in simpler cases.
 */
