package _03_DesignPatterns._03_BehaviouralPattern;

interface Receiver {

	public void executeRequest();

	public void unexecuteRequest();
}

interface Command1 {

	public void execute();

	public void undo();
}

class ConcreteReceiver1 implements Receiver {

	@Override
	public void executeRequest() {
		System.out.println("Receiver1 executing command");
	}

	@Override
	public void unexecuteRequest() {
		System.out.println("Receiver1 un-executing command");
	}
}

class ConcreteReceiver2 implements Receiver {

	@Override
	public void executeRequest() {
		System.out.println("Receiver2 executing command");
	}

	@Override
	public void unexecuteRequest() {
		System.out.println("Receiver2 un-executing command");
	}
}

class ExecuteCommand implements Command1 {

	Receiver receiver;

	ExecuteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.executeRequest();
	}

	@Override
	public void undo() {
		receiver.unexecuteRequest();
	}
}

class UnExecuteCommand implements Command1 {

	Receiver receiver;

	UnExecuteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.unexecuteRequest();
	}

	@Override
	public void undo() {
		receiver.executeRequest();
	}

}

class Invoker {

	Command1 command;

	Invoker(Command1 command) {
		this.command = command;
	}

	public void invokeExecute() {
		this.command.execute();
	}

	public void invokeUnexecute() {
		this.command.undo();
	}
}

public class _02_02_CommandPattern_Template {

	public static void main(String[] args) {

		System.out.println("-- Executing command on receiver1 --");
		Invoker invoker1 = new Invoker(new ExecuteCommand(new ConcreteReceiver1()));
		invoker1.invokeExecute();
		invoker1.invokeUnexecute();

		System.out.println();
		System.out.println("-- Unexecuting command on receiver1 --");
		invoker1 = new Invoker(new UnExecuteCommand(new ConcreteReceiver1()));
		invoker1.invokeExecute();
		invoker1.invokeUnexecute();

		System.out.println();
		System.out.println();
		System.out.println("-- Executing command on receiver2 --");
		Invoker invoker2 = new Invoker(new ExecuteCommand(new ConcreteReceiver2()));
		invoker2.invokeExecute();
		invoker2.invokeUnexecute();

		System.out.println();
		System.out.println("-- Unexecuting command on receiver2 --");
		invoker2 = new Invoker(new UnExecuteCommand(new ConcreteReceiver2()));
		invoker2.invokeExecute();
		invoker2.invokeUnexecute();

	}
}