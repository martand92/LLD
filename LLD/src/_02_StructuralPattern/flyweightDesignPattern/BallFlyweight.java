package _02_StructuralPattern.flyweightDesignPattern;

import java.util.*;

public class BallFlyweight {

	// This holds intrinsic properties shared across objects that are
	// eventually stored in cache and used while creating flyweight objects
	private static final HashMap<String, String> sharedProperties = new HashMap<String, String>();

	public static void main(String[] args) {

		sharedProperties.put("Green", "url1");
		sharedProperties.put("Yellow", "url2");
		sharedProperties.put("white", "url3");

		// Creating 10 ball objects which holds both above intrinsic attributes and
		// extrinsic attributes
		// Intrinsic attributes are read from cache if available in BallFactory class
		// Extrinsic attributes are explicitly assigned
		for (int i = 0; i < 10; i++) {

			List<String> sharedPropertiesKeys = new ArrayList<String>(sharedProperties.keySet());
			String colour = sharedPropertiesKeys.get((int) (Math.random() * sharedPropertiesKeys.size()));
			String url = sharedProperties.get(colour);

			// Above colour and url are randomly selected to create ball objects
			// These intrinsic properties are then sent to BallFactory class to provide ball
			// object with required colour and url properties

			Ball ball = BallFactory.getBall(colour, url);

			// above returned ball object now has only colour and url properties, other
			// properties should be explicitly set
			ball.setCoordx((int) Math.random() + 50);
			ball.setCoordy((int) Math.random() + 50);
			ball.setRadius(75);
			ball.draw();
		}

	}

}
