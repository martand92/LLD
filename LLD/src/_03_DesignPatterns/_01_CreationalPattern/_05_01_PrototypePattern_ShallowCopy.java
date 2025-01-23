package _03_DesignPatterns._01_CreationalPattern;

class Shape2 implements Cloneable {
	private String type;
	private String color;
	private double size;

	public Shape2(String type, String color, double size) {
		this.type = type;
		this.color = color;
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public Shape2 clone() throws CloneNotSupportedException {
		return (Shape2) super.clone();
	}

	@Override
	public String toString() {
		return "type:" + this.type + " color:" + this.color + " size:" + this.size;
	}
}

public class _05_01_PrototypePattern_ShallowCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Shape2 circle = new Shape2("Circle", "Red", 10.0);
		Shape2 clonedCircle = circle.clone();

		System.out.println(circle);
		System.out.println(clonedCircle);

		System.out.println();

		// Now updating properties of initial object's primitive type : String
		circle.setType("Circle1");
		System.out.println("Updating Circle : " + circle);
		System.out.println("Cloned Circle : " + clonedCircle);// Will continue to hold original val as String is
																// primitive
	}
}
