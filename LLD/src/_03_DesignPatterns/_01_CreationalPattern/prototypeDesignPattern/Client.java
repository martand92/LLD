package _03_DesignPatterns._01_CreationalPattern.prototypeDesignPattern;

public class Client {

	public static void main(String[] args) {

		Shape circle = new Shape("Red");

		Shape clonedCircle = circle.clone();
		System.out.println(clonedCircle.getColor());

	}

}
