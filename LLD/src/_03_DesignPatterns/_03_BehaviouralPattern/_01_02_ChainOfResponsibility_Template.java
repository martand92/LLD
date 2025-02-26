package _03_DesignPatterns._03_BehaviouralPattern;

/*
 * Handler (Abstract Class/Interface) → Defines a method to handle requests and maintain a reference to the next handler.
 * Concrete Handlers → Implement request processing and decide whether to pass the request.
 * Client → Builds the chain and initiates the request.
*/

//Handler (Abstract Class / Interface)
abstract class Handler {

	protected Handler nextHandler;

	public void setNextHandler(Handler handler) {
		this.nextHandler = handler;
	}

	public abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler {

	@Override
	public void handleRequest(String request) {

		/* If this handler handles request then process request and end */
		if (request == "1")
			System.out.println("Concretehandler1 handled request");

		// If this handler doesn't handle then forward request to next handler
		else if (this.nextHandler != null)
			nextHandler.handleRequest(request);

		else // if no next handler found to process this request
			System.out.println("No handler found for this requet");
	}

}

class ConcreteHandler2 extends Handler {

	@Override
	public void handleRequest(String request) {

		/* If this handler handles request then process request and end */
		if (request == "2")
			System.out.println("Concretehandler2 handled request");

		// If this handler doesn't handle then forward request to next handler
		else if (this.nextHandler != null)
			nextHandler.handleRequest(request);

		else // if no next handler found to process this request
			System.out.println("No handler found for this requet");
	}
}

//Client code
public class _01_02_ChainOfResponsibility_Template {

	public static void main(String[] args) {

		// Create handlers
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();

		// Chain handlers
		handler1.setNextHandler(handler2);

		// Send request always to 1st handler, if it processes then stops else passes
		// request to next handler

		// Sending request to process by 1st handler
		handler1.handleRequest("1");

		// Sending request to process by 2nd handler
		handler1.handleRequest("2");

		// Sending request to that couldn't be processed by any handler
		handler1.handleRequest("3");

	}

}
