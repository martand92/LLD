package _01_creationalPattern.prototypeDesignPattern;

public class Shape implements Cloneable {

	private String color;

	Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public Shape clone() {

		try {
			return (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
