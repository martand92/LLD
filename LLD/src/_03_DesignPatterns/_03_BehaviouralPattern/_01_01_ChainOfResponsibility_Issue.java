package _03_DesignPatterns._03_BehaviouralPattern;

//Abstract Logger
abstract class Logger1 {
	int level;

	public Logger1(int level) {
		this.level = level;
	}

	public abstract void write(String message);
}

class InfoLogger1 extends Logger1 {
	public InfoLogger1(int level) {
		super(level);
	}

	@Override
	public void write(String message) {
		System.out.println("Info: " + message);
	}
}

class DebugLogger1 extends Logger1 {
	public DebugLogger1(int level) {
		super(level);
	}

	@Override
	public void write(String message) {
		System.out.println("Debug: " + message);
	}
}

class ErrorLogger1 extends Logger1 {
	public ErrorLogger1(int level) {
		super(level);
	}

	@Override
	public void write(String message) {
		System.out.println("Error: " + message);
	}
}

public class _01_01_ChainOfResponsibility_Issue {

	public static void main(String[] args) {
		// Individual loggers
		Logger infoLogger = new InfoLogger(1);
		Logger debugLogger = new DebugLogger(2);
		Logger errorLogger = new ErrorLogger(3);

		// Client explicitly decides which logger to call
		logMessage(1, "This is an Info message", infoLogger, debugLogger, errorLogger);
		logMessage(2, "This is a Debug message", infoLogger, debugLogger, errorLogger);
		logMessage(3, "This is an Error message", infoLogger, debugLogger, errorLogger);
	}

	private static void logMessage(int level, String message, Logger infoLogger, Logger debugLogger,
			Logger errorLogger) {

		if (level == infoLogger.level)
			infoLogger.write(message);

		else if (level == debugLogger.level)
			debugLogger.write(message);

		else if (level == errorLogger.level)
			errorLogger.write(message);

	}
}

/*
 * Key Observations Without Chain of Responsibility :
 * 
 * The client (logMessage method in this case) is responsible for determining
 * the correct logger to call based on the severity level. This violates the
 * Single Responsibility Principle (SRP), as the client has to manage the
 * decision logic and logging.
 * 
 * The logMessage function explicitly checks for each severity level and
 * hardcodes the logger logic. If a new logger (e.g., WarningLogger) is
 * introduced, the client code needs to be updated
 * 
 * 
 * Adding new loggers or modifying the logging flow requires changes in the
 * client, breaking the Open/Closed Principle
 * 
 */
