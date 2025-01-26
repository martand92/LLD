package _03_DesignPatterns._03_BehaviouralPattern;

//Handler
abstract class Logger {

	// Holding reference to next handler
	Logger nextLogger;
	int level;

	// linking current handler to next handler
	public void nextLogger(Logger logger) {
		this.nextLogger = logger;
	}

	// Each handler executes checks on request
	public void logMessage(int level, String message) {

		// Check if message to be logged matches required level of specific handler
		if (this.level == level) {
			write(message);
		}

		if (this.nextLogger != null) {
			this.nextLogger.logMessage(level, message);
		}
	}

	public abstract void write(String message);

}

class InfoLogger extends Logger {

	// Set level of each logger
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

class ChainingResponsibilities {

	public static Logger getLogger() {

		// Create concrete handlers to handle the request
		Logger infoLogger = new InfoLogger(1);
		Logger debugLogger = new DebugLogger(2);
		Logger errorLogger = new ErrorLogger(3);

		// Chain handlers in an order. The loggers are chained in the desired order
		// (Info → Debug → Error)
		infoLogger.nextLogger(debugLogger);
		debugLogger.nextLogger(errorLogger);

		return infoLogger;
	}
}

public class _01_02_ChainOfResponsibility {

	public static void main(String[] args) {

		// Get first handler from the chain
		Logger infoLogger = ChainingResponsibilities.getLogger();

		// A client sends log messages with a specific severity level, and the message
		// propagates through the chain until it's handled by appropriate logger
		infoLogger.logMessage(1, "This is Info message");
		infoLogger.logMessage(2, "This is Debug message");
		infoLogger.logMessage(3, "This is Error message");// Though it starts from head, request is propagated
															// throughout the chain
	}
}