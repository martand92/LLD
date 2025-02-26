package _03_DesignPatterns._03_BehaviouralPattern;

/*
 * Handler (Abstract Class/Interface) → Defines a method to handle requests and maintain a reference to the next handler.
 * Concrete Handlers → Implement request processing and decide whether to pass the request.
 * Client → Builds the chain and initiates the request.
*/

//Handler (Abstract Class / Interface)
abstract class Logger {

	// Holding reference to next handler
	Logger nextLogger;

	int level;

	// linking current handler to next handler
	public void setNextLogger(Logger logger) {
		this.nextLogger = logger;
	}

	// handler method to handle request & pass it to next handler
	public void logMessage(int level, String message) {

		// Check if message to be logged matches required level of specific handler
		if (this.level == level)
			write(message); // Specific to Concrete handler

		if (this.nextLogger != null) {
			this.nextLogger.logMessage(level, message);// passing req to next handler
		}
	}

	public abstract void write(String message);

}

class InfoLogger extends Logger {

	InfoLogger(int level) {
		this.level = level;
	}

	@Override
	public void write(String message) {
		System.out.println("Info :" + message);
	}
}

class DebugLogger extends Logger {

	DebugLogger(int level) {
		this.level = level;
	}

	@Override
	public void write(String message) {
		System.out.println("Debug :" + message);
	}
}

class ErrorLogger extends Logger {

	ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	public void write(String message) {
		System.out.println("Error :" + message);
	}
}

//Client that builds the chain and sends different requests to first handler
public class _01_03_ChainOfResponsibility {

	// Client that builds the chain and initiates different requests to handlers
	public static void main(String[] args) {

		// Create concrete handlers to handle the request
		Logger infoLogger = new InfoLogger(1);
		Logger debugLogger = new DebugLogger(2);
		Logger errorLogger = new ErrorLogger(3);

		// Chaining handlers : Build handler(logger) chain in an order(Info → Debug →
		// Error)
		infoLogger.setNextLogger(debugLogger);
		debugLogger.setNextLogger(errorLogger);

		// Send request to first handler from chain. A client sends log messages
		// with a specific severity level, and the message
		// propagates through the chain until it's handled by appropriate logger
		infoLogger.logMessage(1, "This is Info message");
		infoLogger.logMessage(2, "This is Debug message");
		infoLogger.logMessage(3, "This is Error message");
	}
}