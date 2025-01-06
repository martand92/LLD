package _03_DesignPatterns._03_BehaviouralPattern.corDesignPattern;

public class UserExist extends Handler{

	@Override
	public boolean check(String email, String password) {
		// TODO Auto-generated method stub
		return checkNext(email,password);
	}
		
}
