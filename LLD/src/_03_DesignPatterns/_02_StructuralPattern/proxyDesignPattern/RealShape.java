package _03_DesignPatterns._02_StructuralPattern.proxyDesignPattern;

public class RealShape implements Shape {

	private String type;

	public RealShape(String type) {
		this.type = type;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing a " + type);
	}

}
