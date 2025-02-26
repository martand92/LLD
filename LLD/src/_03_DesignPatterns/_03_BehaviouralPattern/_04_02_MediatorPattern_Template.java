package _03_DesignPatterns._03_BehaviouralPattern;

//Step 1: Define the Mediator Interface
interface Mediator1 {

	void notify(Component sender, String event);
}

//Step 2: Define Abstract Component that interacts with Mediator
abstract class Component {

	protected Mediator1 mediator;

	public Component(Mediator1 mediator) {
		this.mediator = mediator;
	}

	public void sendEvent(String event) {
		mediator.notify(this, event);
	}
}

//Step 3: Create Concrete Components (both initiator / receiver)
class Button extends Component {

	public Button(Mediator1 mediator) {
		super(mediator);
	}

	public void click() {
		System.out.println("Button clicked!");
		sendEvent("click");
	}
}

class TextBox extends Component {

	public TextBox(Mediator1 mediator) {
		super(mediator);
	}

	public void setText(String text) {
		System.out.println("TextBox set text: " + text);
		sendEvent("textEntered");
	}
}

class Checkbox extends Component {

	public Checkbox(Mediator1 mediator) {
		super(mediator);
	}

	public void check() {
		System.out.println("Checkbox checked!");
		sendEvent("checked");
	}
}

//Step 4: Implement Concrete Mediator
class DialogMediator implements Mediator1 {

	private Button button;
	private TextBox textBox;
	private Checkbox checkbox;

	// registering Components with Mediator
	public void setComponents(Button button, TextBox textBox, Checkbox checkbox) {
		this.button = button;
		this.textBox = textBox;
		this.checkbox = checkbox;
	}

	@Override
	public void notify(Component sender, String event) {

		if (sender == button && event.equals("click")) {
			System.out.println("Mediator: Handling button click...");
			textBox.setText("Button Clicked!");

		} else if (sender == checkbox && event.equals("checked")) {
			System.out.println("Mediator: Handling checkbox check...");
			textBox.setText("Checkbox was checked!");
		}
	}
}

public class _04_02_MediatorPattern_Template {

	public static void main(String[] args) {

		DialogMediator mediator = new DialogMediator();

		Button button = new Button(mediator);
		TextBox textBox = new TextBox(mediator);
		Checkbox checkbox = new Checkbox(mediator);

		mediator.setComponents(button, textBox, checkbox);

		button.click(); // Clicking button updates text box
		checkbox.check(); // Checking checkbox updates text box

	}
}

/*
 * 
 * The Mediator interface defines a notify() method to handle component events.
 * 
 * Component is an abstract class that all UI components (Button, TextBox,
 * Checkbox) extend. Components don't interact directly but instead delegate
 * communication to the Mediator.
 * 
 * DialogMediator is a centralized mediator that contains logic for component
 * interactions.
 * 
 * The Client creates components and sets them up with the mediator. When a
 * Button is clicked, it updates the TextBox via the mediator. When a Checkbox
 * is checked, it modifies the TextBox.
 */
