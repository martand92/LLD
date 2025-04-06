package _03_DesignPatterns._01_CreationalPattern;

import java.util.Arrays;

// Shallow copy : Where primitive obj are copy by value & non-primitive obj are copy by reference
class Shape2 implements Cloneable {

	private String type;
	private String color;
	private double size;

	int[] arr = { 1, 2, 3 };

	public Shape2(String type, String color, double size) {
		this.type = type;
		this.color = color;
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Shape2 clone() throws CloneNotSupportedException {
		return (Shape2) super.clone(); // downcasting
	}

	@Override
	public String toString() {
		return "type:" + this.type + " color:" + this.color + " size:" + this.size + " arr:"
				+ Arrays.toString(this.arr);
	}
}

public class _05_01_PrototypePattern_ShallowCopy {

	public static void main(String[] args) throws CloneNotSupportedException {

		Shape2 circle = new Shape2("Circle", "Red", 10.0);
		Shape2 clonedCircle = circle.clone();

		System.out.println(circle);
		System.out.println(clonedCircle);

		System.out.println();

		// Updating primitive property of Original object wont affect clonedObj
		circle.setType("Circle1");
		System.out.println("After Updating Circle type(primitive) in only Original object");
		System.out.println("Orginl Obj -> " + circle);
		System.out.println("Cloned Obj -> " + clonedCircle);// ClonedObj will hold original primitive val

		// Updating non-primitive property of Original object also updates in Cloned Obj
		circle.arr[0] = 4;
		System.out.println();
		System.out.println("After Updating arr's element (non-primitive) in only Original object");
		System.out.println("Orginl Obj -> " + circle);
		System.out.println("Cloned Obj -> " + clonedCircle);
	}
}