package _03_BehaviouralPattern.corDesignPattern;

public class Throttling extends Handler{

	@Override
	public boolean check(String email, String password) {
		// TODO Auto-generated method stub
		
		return checkNext(email,password);
		
	}
	
	

}
