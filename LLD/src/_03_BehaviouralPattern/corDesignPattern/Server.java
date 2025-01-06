package _03_BehaviouralPattern.corDesignPattern;

public class Server {
	
	private Handler handler;
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public boolean login(String email, String password) {
		if(handler.check(email, password))
			return true;
		
		return false;
	}

}
