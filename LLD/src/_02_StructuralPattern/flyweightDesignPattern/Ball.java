package _02_StructuralPattern.flyweightDesignPattern;

public class Ball {
	
	@SuppressWarnings("unused")
	private String colour;
	
	@SuppressWarnings("unused")
	private String imageURL;
	
	@SuppressWarnings("unused")
	private int coordx;
	
	@SuppressWarnings("unused")
	private int coordy;
	
	@SuppressWarnings("unused")
	private int radius;

	// intrinsic attributes of ball are passed as constructor as it will be
	// initialized first during object creation and will be stored and shared with
	// other objects
	public Ball(String colour, String imageURL) {
		this.colour = colour;
		this.imageURL = imageURL;
	}

	// All other objects properties (extrinsic) are allowed to explicitly set for
	// each new object getting created
	public void setCoordx(int coordx) {
		this.coordx = coordx;
	}

	public void setCoordy(int coordy) {
		this.coordy = coordy;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void draw() {

	}
}
