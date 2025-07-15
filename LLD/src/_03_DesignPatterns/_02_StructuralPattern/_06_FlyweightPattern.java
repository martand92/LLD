package _03_DesignPatterns._02_StructuralPattern;

import java.util.*;

interface Game {
	public void build();
}

class Ball implements Game {

	String color;
	int size;
	String coordinates;

	// Only intrinsic properties are added to constructor
	Ball(String color) {
		this.color = color;
	}

	public Ball setSize(int size) {
		this.size = size;
		return this;
	}

	public Ball setCoordinates(String coordinates) {
		this.coordinates = coordinates;
		return this;

	}

	@Override
	public void build() {
		System.out.println("Built ball of Color : " + this.color + ", of Size : " + this.size + ", of Coordinates : "
				+ this.coordinates);
	}
}

//Factory that creates Ball objects if not cached and cache them
class BallFactory {

	private static final HashMap<String, Ball> ballMap = new HashMap<String, Ball>();

	// Create balls with required colors and cache them, if already present then
	// return. No new objects are created
	public static Ball getBall(String color) {

		// this ensures no duplicate instance of same obj is created, hence no 2 objects
		// exist with same color are created
		if (!ballMap.containsKey(color))
			ballMap.put(color, new Ball(color));

		return ballMap.get(color);
	}
}

public class _06_FlyweightPattern {

	public static void main(String[] args) {

		// Flyweight object. Receive required ball from factory if present else create
		// new ball, add it to factory & return
		Ball greenBall = BallFactory.getBall("Green"); // Client is required to specify intrinsic properties

		// then add additional properties to received ball
		greenBall.setSize(5).setCoordinates("x=4, y=5").build();

		Ball purpleBall = BallFactory.getBall("Purple");
		purpleBall.setSize(10).setCoordinates("x=2, y=3").build();

		// Now if you want another greenBall, it wont create new green ball object but
		// returns from the cached
		Ball greenBall1 = BallFactory.getBall("Green");
		System.out.println(greenBall.hashCode() == greenBall1.hashCode());

	}

}
