package _00_SOLID;

//Below class that violates SRP
class Marker {

	String name;
	String color;
	int year;
	int price;

	public Marker(String name, String color, int year, int price) {
		this.name = name;
		this.color = color;
		this.year = year;
		this.price = price;
	}

}

class Invoice {

	private Marker marker; // Added Marker class
	private int quantity;

	public Invoice(Marker marker, int quantity) {
		this.marker = marker;
		this.quantity = quantity;
	}

	// Below are the 3 reasons to modify this class :
	public int calculatorTotal() {// 1st reason : If logic to calculate total price of marker changes
		int price = (marker.price) * this.quantity;
		return price;
	}

	public void printInvoice() { // 2nd reason : If printing logic changes

	}

	public void saveToDB() { // 3rd reason : if logic to save to DB changes, say a new DB is needed later or
								// connection param to DB changes

	}
}

public class _01_01_SingleResponsibility_Issue {

	public static void main(String[] args) {

		Marker marker = new Marker("markername", "markerColor", 2015, 10);
		Invoice invoice = new Invoice(marker, 5);
		invoice.calculatorTotal();

	}

}
