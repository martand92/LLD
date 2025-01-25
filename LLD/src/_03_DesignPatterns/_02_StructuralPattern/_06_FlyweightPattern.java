package _03_DesignPatterns._02_StructuralPattern;

import java.util.*;

interface Game {
	public void build();
}

class Ball implements Game {

	String color;
	int size;
	String coordinates;

	// Only intrinsic properties are added to construction
	Ball(String color) {
		this.color = color;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public void build() {
		System.out.println("Built ball of Color : " + this.color + ", of Size : " + this.size + ", of Coordinates : "
				+ this.coordinates);
	}
}

class FlyweightFactory {

	private static final HashMap<String, Ball> ballMap = new HashMap<String, Ball>();

	// Create balls with required colors and cache them, if already present then
	// return
	public static Ball getBall(String color) {

		return ballMap.getOrDefault(color, new Ball(color));
	}
}

public class _06_FlyweightPattern {

	public static void main(String[] args) {

		// Flyweight object. Receive required ball from factory if present else create
		// and add to factory
		Ball greenBall = FlyweightFactory.getBall("Green"); // Client is required to specify intrinsic properties
		greenBall.setSize(5);// then add additional properties to received ball
		greenBall.setCoordinates("x=4, y=5");
		greenBall.build();

		Ball purpleBall = FlyweightFactory.getBall("Purple");
		purpleBall.setSize(10);
		purpleBall.setCoordinates("x=2, y=3");
		purpleBall.build();
	}

}
