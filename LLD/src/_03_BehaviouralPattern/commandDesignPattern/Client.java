package _03_BehaviouralPattern.commandDesignPattern;

public class Client {

	public static void main(String[] args) {
		// Creating receivers
		Shape circle = new Circle();
		Shape square = new Square();
		
		// Creating Command classes and associating with receivers
		Command circleCommand = new CircleCommand(circle);
		Command squareCommand = new CircleCommand(square);
		
		
		
		// Creating Sender
		Sender sender = new Sender();

		// Associating Sender with command obj
		sender.setCommand(squareCommand);
		// Then executing command
		sender.executeCommand();

		sender.setCommand(circleCommand);
		sender.executeCommand();

	}
}
