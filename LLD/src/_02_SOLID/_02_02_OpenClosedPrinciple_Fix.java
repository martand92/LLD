package _02_SOLID;

interface saveInvoice {
	public void save();
}

/*
 * When new requirement came to save invoice to file, with initial structure new
 * method to save invoice to file was added to existing class i.e, existing
 * class was modified.
 * 
 * 
 * To fix this issue, there is a need to have an interface that implements
 * existing responsibility(savetoDB) and also implements new responsibilities
 * with new concrete classes by extending interface and not by modifying
 * existing concrete classes
 */
class saveInvoiceToDB implements saveInvoice {

	String invoice;

	public saveInvoiceToDB(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public void save() {
		System.out.println("Saving invoice to DB : " + invoice);
	}

}

class saveInvoiceToFile implements saveInvoice {

	String invoice;

	public saveInvoiceToFile(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public void save() {
		System.out.println("Saving invoice to File : " + invoice);
	}

}

/*
 * In future if there is a need to save invoice to another persistent layer then
 * implement a new class with required responsibility
 */

public class _02_02_OpenClosedPrinciple_Fix {

	public static void main(String[] args) {

		saveInvoiceToDB dbObj = new saveInvoiceToDB("invoice");
		dbObj.save();

		saveInvoiceToFile fileObj = new saveInvoiceToFile("invoice");
		fileObj.save();
	}

}
