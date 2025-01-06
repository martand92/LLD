package _03_BehaviouralPattern.mediatorDesignPattern;

public interface User {
	public void sendMessage(String message);
	public void receiveMessage(String message, User u);
}
