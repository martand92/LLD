package _03_DesignPatterns._03_BehaviouralPattern;

/*
 * Here new states are introduced without modifying existing states 
 * When new State is introduced, need to add flow condition to Simple factory which refrain from modifying existing states 
 * 
 */

class Context2 {
	private State1 state;

	public Context2(State1 initialState) {
		this.state = initialState;
	}

	public void setState(State1 state) {
		this.state = state;
	}

	public State1 getContextState() {
		return this.state;
	}

	public void request(String input) {
		state.handle(this, input);
	}
}

interface State1 {
	void handle(Context2 context, String input);
}

class StateA implements State1 {
	@Override
	public void handle(Context2 context, String input) {
		System.out.println("State A handling request.");
		context.setState(StateFactory.getNextState(input)); // Delegating transition decision to factory
	}
}

class StateB implements State1 {
	@Override
	public void handle(Context2 context, String input) {
		System.out.println("State B handling request.");
		context.setState(StateFactory.getNextState(input));
	}
}

//New state is introduced
class StateC implements State1 {
	@Override
	public void handle(Context2 context, String input) {
		System.out.println("State C handling request.");
		context.setState(StateFactory.getNextState(input));
	}
}

class StateFactory {

	public static State1 getNextState(String input) {

		switch (input) {

		case "goA":
			return new StateA();

		case "goB":
			return new StateB();

		case "goC":
			return new StateC(); // New state introduced here without modifying StateA or StateB

		default:
			throw new IllegalArgumentException("Invalid State Transition");

		}
	}
}

public class _10_02_StatePattern_Template {

	public static void main(String[] args) {

		Context2 context = new Context2(new StateA()); // Setting initial state as StateA

		// Trigger state transitions
		context.request("goB"); // State A -> Transition to State B
		context.request("goC"); // State B -> Transition to State C

		// Check current state in context now. As B is transitioned to C, context should
		// be pointing at C
		System.out.println(context.getContextState().getClass());
	}
}

/*
 * The State Pattern can be improved by removing hardcoded transitions inside
 * state classes.
 * 
 * Delegating transitions to a centralized place (Factory, Context, Transition
 * Map) ensures new states can be added without modifying existing states.
 */
