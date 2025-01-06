package _03_BehaviouralPattern.commandDesignPattern;

public class Sender {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}

}
