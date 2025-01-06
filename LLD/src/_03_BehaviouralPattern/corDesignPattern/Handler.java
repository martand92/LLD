package _03_BehaviouralPattern.corDesignPattern;

public abstract class Handler {
	Handler first;
	Handler next;
	
	//chain will have objects starting from userExist 
	public static Handler link(Handler first, Handler... chain) {

		Handler head = first;

		for (Handler nextInChain : chain) {
			head.next = nextInChain;
			head = nextInChain;
		}

		return first;
	}

	public abstract boolean check(String email, String password);

	public boolean checkNext(String email, String password) {

		if (next == null)
			return true;

		return next.check(email, password);
	}
	
}
