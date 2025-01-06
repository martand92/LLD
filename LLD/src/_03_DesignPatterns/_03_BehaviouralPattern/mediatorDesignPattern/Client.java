package _03_DesignPatterns._03_BehaviouralPattern.mediatorDesignPattern;

public class Client {

	public static void main(String[] args) {

		MediatorImpl mediator = new MediatorImpl();

		User user1 = new UserImpl(mediator);
		User user2 = new UserImpl(mediator);
		User user3 = new UserImpl(mediator);

		mediator.addUserToMediator(user1);
		mediator.addUserToMediator(user2);
		mediator.addUserToMediator(user3);

		user1.sendMessage("Hi");

	}

}
