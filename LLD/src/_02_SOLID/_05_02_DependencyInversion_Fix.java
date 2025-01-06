package _02_SOLID;

interface Keyboard1 {
	public void usingKeyboard();
}

interface Mouse1 {
	public void usingMouse();

}

class WiredKeyboard1 implements Keyboard1 {

	@Override
	public void usingKeyboard() {
		// TODO Auto-generated method stub
		System.out.println("Using wired keyboard");

	}

}

class WiredMouse1 implements Mouse1 {

	@Override
	public void usingMouse() {
		// TODO Auto-generated method stub
		System.out.println("Using wired mouse");
	}

}

class BluetoothKeyboard1 implements Keyboard1 {

	@Override
	public void usingKeyboard() {
		// TODO Auto-generated method stub
		System.out.println("Using bluetooth keyboard");
	}
}

class BluetoothMouse1 implements Mouse1 {

	@Override
	public void usingMouse() {
		// TODO Auto-generated method stub
		System.out.println("Using bluetooth mouse");
	}
}

class MacBook1 {

	private final Keyboard1 keyboard; // Instead of accepting concrete classes, now dependent on abstraction
	private final Mouse1 mouse;

	public MacBook1(Keyboard1 keyboard, Mouse1 mouse) { // Macbook accepting keyboard and mouse as abstraction
		this.keyboard = keyboard;
		this.mouse = mouse;
	}

	public void useKeyboard() {// this Macbook uses generic keyboard, you can pass either wired or bluetooth
								// keyboard
		keyboard.usingKeyboard();
	}

	public void useMouse() {// this Macbook uses only generic mouse, you can pass either wired or bluetooth
							// mouse
		mouse.usingMouse();
	}
}

public class _05_02_DependencyInversion_Fix {

	public static void main(String[] args) {

		// Macbook initially constructed using wired
		MacBook1 macbook = new MacBook1(new WiredKeyboard1(), new WiredMouse1());
		macbook.useKeyboard();
		macbook.useMouse();

		// But later extended to use bluetooth as it depends on Abstractions (Keyboard &
		// Mouse)
		MacBook1 macbook1 = new MacBook1(new BluetoothKeyboard1(), new BluetoothMouse1());
		macbook1.useKeyboard();
		macbook1.useMouse();

	}

}

/*
 * High level class MacBook is now not dependent on low level modules but on
 * Abstraction (Keyboard and Mouse interface) Low level modules (WiredKeyboard ,
 * WiredMouse, BluetoothKeyboard, BluetoothMouse) are also dependent on
 * Abstraction
 */
