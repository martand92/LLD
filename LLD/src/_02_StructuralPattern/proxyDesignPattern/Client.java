package _02_StructuralPattern.proxyDesignPattern;

public class Client {

	public static void main(String[] args) {
		
		// Proxy class that internally lazy loads realCircle class
		ProxyShape securedCircle = new ProxyShape("Circle", "12345");
		securedCircle.draw();

		// Access with an invalid access key
		ProxyShape invalidCircle = new ProxyShape("Circle", "54321");
		invalidCircle.draw();

	}

}
