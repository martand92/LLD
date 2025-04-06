package _03_DesignPatterns._01_CreationalPattern;

import java.util.Arrays;
import java.util.Objects;

class Shape3 implements Cloneable {
	private String type;
	private String color;

	int[] arr = { 1, 2, 3 };

	public Shape3(String type, String color) {
		this.type = type;
		this.color = color;

	}

	public void setType(String type) {
		this.type = type;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Deep copy
	@Override
	public Shape3 clone() throws CloneNotSupportedException {

		Shape3 clonedShape = (Shape3) super.clone();

		clonedShape.type = new String(this.type);
		clonedShape.color = new String(this.color);
		// above is unnecessary as String is immutable and super.clone() will create new
		// copy of them

		clonedShape.arr = arr.clone();// for non-primitive, new copy is created and assigned to new cloned obj

		return clonedShape;
	}

	@Override
	public String toString() {
		return "type:" + this.type + " color:" + this.color + " arr:" + Arrays.toString(this.arr);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, color);
	}
}

public class _05_02_PrototypePattern_DeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {

		Shape3 circle = new Shape3("Circle", "Red");
		Shape3 clonedCircle = circle.clone();

		System.out.println(circle);
		System.out.println(clonedCircle);

		// the hash-codes of the original and cloned objects should be equal
		System.out.println();
		System.out.println("hash of original : " + circle.hashCode());
		System.out.println("hash of original : " + clonedCircle.hashCode());

		// Updating non-primitive type in Original object will not affect Clonedobj
		circle.arr[0] = 4;
		System.out.println(circle);
		System.out.println(clonedCircle);
	}
}
