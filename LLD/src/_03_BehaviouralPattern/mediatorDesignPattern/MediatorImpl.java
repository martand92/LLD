package _03_BehaviouralPattern.mediatorDesignPattern;

import java.util.*;

public class MediatorImpl implements Mediator {

	List<User> users = new ArrayList<User>();

	// Store all the components inside Mediator
	public void addUserToMediator(User user) {
		users.add(user);
	}

	@Override
	public void sendMessage(String message, User user) {
		for (User u : users)
			u.receiveMessage(message, u);
	}

}
