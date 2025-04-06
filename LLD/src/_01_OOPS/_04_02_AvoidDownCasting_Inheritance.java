package _01_OOPS;

interface Animal2 {
	public void sound();
}

interface Bark extends Animal2 {
	public void bark();
}

interface Whisper extends Animal2 {
	public void whisper();
}

//As Dog implements Bark which extends Animal, This forces Dog concretion refer to Bark and not Animal  
class Dog2 implements Bark {

	@Override
	public void sound() {
		System.out.println("Dog sound");
	}

	@Override
	public void bark() {
		System.out.println("Dog barks");
	}
}

class Cat2 implements Whisper {

	@Override
	public void sound() {
		System.out.println("Cat sound");
	}

	@Override
	public void whisper() {
		System.out.println("Cat whispers");
	}
}

public class _04_02_AvoidDownCasting_Inheritance {

	public static void main(String[] args) {

		Bark dog = new Dog2(); // Now asking objects to be of more specific. If ref is Animal again, then
								// throws compilation error while calling bark()
		Whisper cat = new Cat2();

		dog.sound();
		cat.sound();

		dog.bark();
	}
}