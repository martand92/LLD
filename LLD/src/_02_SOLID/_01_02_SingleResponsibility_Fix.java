package _02_SOLID;

//Below is a class that violates SRP

class Marker1 {

	String name;
	String color;
	int year;
	int price;

	public Marker1(String name, String color, int year, int price) {
		this.name = name;
		this.color = color;
		this.year = year;
		this.price = price;
	}

}

/*
 * To adhere to Single responsibility, restricted the original Invoice class to
 * have single responsibility of calculating invoice. Moved responsibility of
 * saving to DB and printing invoices to 2 separate classes
 */
class Invoice1 {

	private Marker1 marker; // Added Marker class
	private int quantity;

	public Invoice1(Marker1 marker, int quantity) {
		this.marker = marker;
		this.quantity = quantity;
	}

	public int calculatorTotal() {
		int price = (marker.price) * this.quantity;
		return price;
	}
}

//Even below class has single responsibility of saving invoice to DB
class SaveToDB {

	Invoice1 invoice;

	public SaveToDB(Invoice1 invoice) {
		this.invoice = invoice;
	}

	public void saveToDB() {
		System.out.println("Saving invoice to DB : " + invoice);
	}
}

class PrintInvoice {

	Invoice1 invoice;

	public PrintInvoice(Invoice1 invoice) {
		this.invoice = invoice;
	}

	public void printInvoice() {
		System.out.println("Printing Invoice : " + invoice);
	}
}

public class _01_02_SingleResponsibility_Fix {

	public static void main(String[] args) {

		Marker1 marker = new Marker1("markername", "markerColor", 2015, 10);

		Invoice1 invoice = new Invoice1(marker, 5);
		invoice.calculatorTotal();

		SaveToDB db = new SaveToDB(invoice);
		db.saveToDB();

		PrintInvoice print = new PrintInvoice(invoice);
		print.printInvoice();
	}
}

//Advantages : Easy to maintain : As only single respective class need to be updated to maintain
