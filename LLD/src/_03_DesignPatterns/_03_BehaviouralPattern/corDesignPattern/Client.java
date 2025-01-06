package _03_DesignPatterns._03_BehaviouralPattern.corDesignPattern;

public class Client {

	private static Server server;

	private static void init() {
		server = new Server();
		Handler handler = Handler.link(new Throttling(), new UserExist());
		server.setHandler(handler);
	}

	public static void main(String[] args) {
		init();
		System.out.println(server.login("email", "password"));
	}

}
