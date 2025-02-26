package _03_DesignPatterns._03_BehaviouralPattern;

//Receiver
interface Device {
	public void switchOn();

	public void switchOff();
}

class Light implements Device {

	@Override
	public void switchOn() {
		System.out.println("Switching on Light");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Light");
	}
}

class Fan implements Device {

	@Override
	public void switchOn() {
		System.out.println("Switching on Fan");
	}

	@Override
	public void switchOff() {
		System.out.println("Switching off Fan");
	}

}

//Command should be an interface, so that any command can be attached to Sender
interface Command {
	public void execute();

	public void undo();
}

//Actions performed on invoker are converted as commands and each command holds receiver to perform operations on receiver
class LightOnCommand implements Command {

	Device light;

	LightOnCommand(Device light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.switchOn();
	}

	@Override
	public void undo() {
		light.switchOff();
	}
}

class LightOffCommand implements Command {

	Device light;

	LightOffCommand(Device light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.switchOff();
	}

	@Override
	public void undo() {
		light.switchOn();
	}

}

//Sender holds command as abstraction to which any concrete command is passed in runtime
class Remote {

	Command command;

	// Recommendation is to use constructor injection and not parameter injection as
	// it allows this invoker to always stick to mentioned command(s) for its entire
	// lifecycle
	public void setCommand(Command command) {
		this.command = command;
	}

	// Perform actions on command which will inturn perform actions on receiver
	public void executeAction() {
		command.execute();
	}

	public void undoAction() {
		command.undo();
	}
}

public class _02_03_CommandPattern {

	public static void main(String[] args) {

		// First create end receivers
		Device light = new Light();

		// Create commands to perform actions on end receivers
		Command lightOn = new LightOnCommand(light);
		Command lightOff = new LightOffCommand(light);

		// On Sender, set required command to execute operations
		Remote remote = new Remote();
		remote.setCommand(lightOn);
		remote.executeAction();
		remote.undoAction();

		System.out.println();

		remote.setCommand(lightOff);
		remote.executeAction();
		remote.undoAction();
	}

}
