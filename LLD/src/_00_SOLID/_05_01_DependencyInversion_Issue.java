package _00_SOLID;

/* Class should depend on interface rather than concrete class */

/* Scenario : You have a Keyboard and Mouse as interfaces.
 * Keyboard(interface) contains WiredKeyboard(concrete class) and BluetoothKeyboard(concrete class)
 * Mouse(interface) contains WiredMouse(concrete class) and BluetoothMouse(concrete class)
 * 
 * Now you are constructing a MacBook using keyboard and mouse.
 * You decide to select WiredKeyboard and WiredMouse to construct MacBook
 * 
 *  In future, you want to have option of adding Bluetooth Keyboard and Mouse to your Macbook but you cannot
 *  As you have used concrete classes (WiredKeyboard & WiredMouse) to construct MacBook
 *  
 *  Instead if you have used Interface / Abstract i.e, Keyboard and Mouse interfaces, 
 *  you could have swapped Wired Keyboard and mouse with Bluetooth keyboard and mouse
 */

interface Keyboard {
	public void usingKeyboard();
}

interface Mouse {
	public void usingMouse();

}

class WiredKeyboard implements Keyboard {

	@Override
	public void usingKeyboard() {
		// TODO Auto-generated method stub
		System.out.println("Using wired keyboard");

	}

}

class WiredMouse implements Mouse {

	@Override
	public void usingMouse() {
		// TODO Auto-generated method stub
		System.out.println("Using wired mouse");
	}

}

class BluetoothKeyboard implements Keyboard {

	@Override
	public void usingKeyboard() {
		// TODO Auto-generated method stub
		System.out.println("Using bluetooth keyboard");

	}

}

class BluetoothMouse implements Mouse {

	@Override
	public void usingMouse() {
		// TODO Auto-generated method stub
		System.out.println("Using bluetooth mouse");
	}
}

class MacBook {
	private final WiredKeyboard keyboard;
	private final WiredMouse mouse;

	public MacBook(WiredKeyboard keyboard, WiredMouse mouse) { // macbook accepting keyboard and mouse of only
																// Wired(concrete) type
		this.keyboard = keyboard;
		this.mouse = mouse;
	}

	public void useWiredKeyboard() {// this Macbook uses only wired keyboard
		keyboard.usingKeyboard();
	}

	public void useWiredMouse() {// this Macbook uses only wired mouse
		mouse.usingMouse();
	}
}

public class _05_01_DependencyInversion_Issue {

	public static void main(String[] args) {

		MacBook macbook = new MacBook(new WiredKeyboard(), new WiredMouse());// This MacBook tightly accepts only
																				// WiredKeyboard

		// If in future you want to have a Macbook with Bluetooth keyboard and mouse
		// though they are available then this fails
		// MacBook macbookNew = new MacBook(new BluetoothKeyboard(), new
		// BluetoothMouse()); <- Compile time error as macbook cannot be created using
		// bluetooth keyboard /mouse
	}

}

//Here Macbook is high level class
//WiredKeyboard and WiredMouse are low level classes.

/*
 * So high level class is dependent on low level modules / classes. This
 * principle says, high level classes should not depend on low level modules but
 * should depend on Abstraction of low level modules. And low level classes /
 * modules should implement this Abstraction
 */
