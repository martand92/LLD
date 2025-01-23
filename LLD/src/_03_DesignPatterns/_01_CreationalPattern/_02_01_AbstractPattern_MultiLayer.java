package _03_DesignPatterns._01_CreationalPattern;


//Abstract factory with factory layer (Multi layer)
interface Dialog {
	public void renderDialog();
}

class MacDialog implements Dialog {
	@Override
	public void renderDialog() {
		System.out.println("Renedering Mac Dialog");
	}
}

class WindowsDialog implements Dialog {
	@Override
	public void renderDialog() {
		System.out.println("Renedering Windows Dialog");
	}
}

interface Button2 {
	public void renderButton();
}

class MacButton implements Button2 {
	@Override
	public void renderButton() {
		System.out.println("Rendering Mac Button");
	}
}

class WindowsButton2 implements Button2 {
	@Override
	public void renderButton() {
		System.out.println("Rendering Windows Button");
	}
}

//Have factory for both dialog and button to return specific dialog and button objects
interface DialogFactory {
	public Dialog createDialog();
}

class MacDialogFactory implements DialogFactory {
	@Override
	public Dialog createDialog() {
		return new MacDialog();
	}
}

class WindowsDialogFactory implements DialogFactory {
	@Override
	public Dialog createDialog() {
		return new WindowsDialog();
	}
}

interface ButtonFactory {
	public Button2 createButton();
}

class MacButtonFactory implements ButtonFactory {
	@Override
	public Button2 createButton() {
		return new MacButton();
	}
}

class WindowsButtonFactory implements ButtonFactory {
	@Override
	public Button2 createButton() {
		return new WindowsButton2();
	}
}

//Abstract Factory to return Factory of associated objects
interface AbstractFactory {

	public DialogFactory getDialogFactory();

	public ButtonFactory getButtonFactory();
}

class MacAbstractFactory implements AbstractFactory {

	@Override
	public DialogFactory getDialogFactory() {
		return new MacDialogFactory(); //Returns factory
	}

	@Override
	public ButtonFactory getButtonFactory() {
		return new MacButtonFactory();
	}
}

class WindowsAbstractFactory implements AbstractFactory {

	@Override
	public DialogFactory getDialogFactory() {
		return new WindowsDialogFactory();
	}

	@Override
	public ButtonFactory getButtonFactory() {
		return new WindowsButtonFactory();
	}
}

class AbstractFactoryRegistry {

	public static AbstractFactory getAbstractFactory(String type) {

		switch (type) {

		case "Mac":
			return new MacAbstractFactory();
		case "Windows":
			return new WindowsAbstractFactory();
		default:
			throw new IllegalArgumentException();
		}
	}
}

//Client code
public class _02_01_AbstractPattern_MultiLayer {

	public static void main(String[] args) {

		// Client First calls abstract factory for Mac to get Mac's Dialog factory and
		// Button factory as they are associated
		AbstractFactory macAbstractFactory = AbstractFactoryRegistry.getAbstractFactory("Mac");

		DialogFactory macDialogFactory = macAbstractFactory.getDialogFactory();
		ButtonFactory macButtonFactory = macAbstractFactory.getButtonFactory();

		// Using Mac's Dialog & Button factories, create Mac specific Dialog
		// and Button objects and render them
		Dialog macDialog = macDialogFactory.createDialog();
		Button2 macButton = macButtonFactory.createButton();

		macDialog.renderDialog();
		macButton.renderButton();
	}
}