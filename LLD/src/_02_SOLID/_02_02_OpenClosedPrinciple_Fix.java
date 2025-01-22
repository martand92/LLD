package _02_SOLID;

interface SaveInvoice {
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
class SaveInvoiceToDB implements SaveInvoice {

	String invoice;

	public SaveInvoiceToDB(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public void save() {
		System.out.println(invoice);
	}

}

/*
 * If new requirement is to save to file then create another implementation of
 * SaveInvoice abstraction and implement logic to save to file
 */
class SaveInvoiceToFile implements SaveInvoice {

	String invoice;

	public SaveInvoiceToFile(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public void save() {
		System.out.println(invoice);
	}

}

class SaveMechanism {

	SaveInvoice saveInvoice;

	SaveMechanism(SaveInvoice saveInvoice) {
		this.saveInvoice = saveInvoice;
	}

	public void saveInvoice() {
		saveInvoice.save();
	}
}

/*
 * In future if there is a need to save invoice to another persistent layer then
 * implement a new class with required responsibility
 */

public class _02_02_OpenClosedPrinciple_Fix {

	public static void main(String[] args) {

		// Now if you want to save invoice to DB
		SaveMechanism saveMechanismObj = new SaveMechanism(new SaveInvoiceToFile("invoice saving to DB"));
		saveMechanismObj.saveInvoice();

		// Now if you want to save invoice to File
		saveMechanismObj = new SaveMechanism(new SaveInvoiceToFile("invoice saving to File"));
		saveMechanismObj.saveInvoice();

		// In future if you want to save invoice to any other persistence, then another
		// implementation for same SaveInvoice Abstraction can be created and
		// passed as object to save invoice to new persistence
	}

}
