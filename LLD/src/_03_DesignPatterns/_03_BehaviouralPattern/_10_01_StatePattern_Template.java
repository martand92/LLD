package _03_DesignPatterns._03_BehaviouralPattern;

//Step 1: Define the State Interface
interface State {
	void handleRequest(Context1 context);
}

// Step 2: Implement Concrete States
class ConcreteStateA implements State {
	@Override
	public void handleRequest(Context1 context) {
		System.out.println("State A: Handling request and transitioning to State B.");
		// This object now changes to predefined stateB using context. Need not be
		// predefined
		context.setState(new ConcreteStateB());
	}
}

/*
 * Also when new state is introduced, need to link existing state's setState()
 * to get to new state. Ex: If State should change from ConcreteStateB to
 * ConcreteStateC, then need to update ConcreteStateB's state as setState(new
 * ConcreteStateC()). Violates OCP. Hence this template is not ideal, refer next
 * template
 */

class ConcreteStateB implements State {
	@Override
	public void handleRequest(Context1 context) {
		System.out.println("State B: Handling request and transitioning to State A.");
		context.setState(new ConcreteStateA()); // This object now changes state dynamically to stateA using context
	}
}

//Step 3: Create the Context Class that Manages State & transitions
class Context1 {
	private State currentState;

	public Context1() {
		// Initial state
		this.currentState = new ConcreteStateA();
	}

	public void setState(State state) {
		this.currentState = state;
	}

	public void request() {
		currentState.handleRequest(this);
	}
}

//Step 4: Client Code to Demonstrate State Transitions
//Here state change is not controlled by client unlike Strategy pattern
public class _10_01_StatePattern_Template {

	public static void main(String[] args) {

		Context1 context = new Context1();

		// Trigger state transitions
		context.request(); // Output: State A -> Transition to State B
		context.request(); // Output: State B -> Transition to State A

	}
}