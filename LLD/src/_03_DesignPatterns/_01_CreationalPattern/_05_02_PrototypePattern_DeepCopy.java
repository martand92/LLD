package _03_DesignPatterns._01_CreationalPattern;

import java.util.Arrays;
import java.util.Objects;

class Shape3 implements Cloneable {
	private String type;
	private String color;
	private double size;

	int[] arr = { 1, 2, 3 };

	public Shape3(String type, String color, double size) {
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

	// Deep copy
	@Override
	public Shape3 clone() throws CloneNotSupportedException {

		Shape3 clone = (Shape3) super.clone();

		// Deep copy
		clone.type = new String(this.type);
		clone.color = new String(this.color); // Deep copy of color (String)
		clone.arr = arr.clone();// for non-primitive elements, new copy is created and assigned to new cloned
								// obj
		return clone;
	}

	@Override
	public String toString() {
		return "type:" + this.type + " color:" + this.color + " size:" + this.size + " arr:"
				+ Arrays.toString(this.arr);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, color, size);
	}
}

public class _05_02_PrototypePattern_DeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {

		Shape3 circle = new Shape3("Circle", "Red", 10.0);
		Shape3 clonedCircle = circle.clone();

		System.out.println(circle);
		System.out.println(clonedCircle);

		// the hash-codes of the original and cloned objects should be equal
		System.out.println();
		System.out.println("hash of original : " + circle.hashCode());
		System.out.println("hash of original : " + clonedCircle.hashCode());

		// Updating non-primitive type in Original object will only affect Clonedobj
		circle.arr[0] = 4;
		System.out.println(circle);
		System.out.println(clonedCircle);
	}
}
