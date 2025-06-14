package _03_DesignPatterns._01_CreationalPattern;

interface Button0 {
	public void render();
}

class HTMLButton0 implements Button0 {
	@Override
	public void render() {
		System.out.println("Rendering HTML Button");
	}
}

class WindowsButton0 implements Button0 {
	@Override
	public void render() {
		System.out.println("Rendering Windows Button");
	}
}

class ButtonFactory1 {

	public static Button0 getButton(String type) {

		if (type == "HTML")
			return new HTMLButton0();
		else
			return new WindowsButton0();
	}
}

public class _01_00_SimpleFactoryPattern_Centralized {

	public static void main(String[] args) {
		Button0 htmlButton = ButtonFactory1.getButton("HTML");
		htmlButton.render();
	}
}

/*
 * Key Takeaways:
 * 
 * Who creates the object? : A single centralized class
 * 
 * Extensibility : Less flexible (requires changes in factory class) Design
 * 
 * Principle Used : Encapsulates object creation
 */
