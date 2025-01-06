package _03_DesignPatterns._03_BehaviouralPattern.mediatorDesignPattern;

//Component
public class UserImpl implements User {
	
	//Stores reference to Mediator
	Mediator mediator;
	
	//Connection between Component and Mediator is established here
	UserImpl(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void sendMessage(String message) {
		mediator.sendMessage(message, this);
	}

	@Override
	public void receiveMessage(String message, User u) {
		System.out.println("Received message : " + message + " from user : " + u);
	}

}
