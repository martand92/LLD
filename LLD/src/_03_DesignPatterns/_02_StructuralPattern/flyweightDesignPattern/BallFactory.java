package _03_DesignPatterns._02_StructuralPattern.flyweightDesignPattern;

import java.util.HashMap;

//This is Flyweight factory that stores intrinsic properties in flyweight object = cache(hashmap) 
public class BallFactory {

	// This is Flyweight object which is cache(hashmap)to store intrinsic properties
	// of a ball as cachekey(hashmap key)
	private static final HashMap<String, Ball> ballMap = new HashMap<>();

	// This function creates a ball object with mentioned intrinsic properties
	// colour and url.
	// Other extrinsic properties for created ball object are added in Flyweight
	// pattern class
	// Here ball object is created but with only intrinsic properties
	public static Ball getBall(String colour, String url) {

		// for given intrinsic properties(colour & url, return associated ball object if
		// found in hashmap)
		Ball ball = ballMap.get(colour + url);

		// If ball object is not found in hashmap, then create new ball object and for
		// this intrinsic properties and return this ball instance
		if (ball == null) {
			ball = new Ball(colour, url);
			ballMap.put(colour + url, ball);
			System.out.println("Created a new ball object for given colour and url and added it to cache(hashmap)");
		}

		return ball;
	}
}