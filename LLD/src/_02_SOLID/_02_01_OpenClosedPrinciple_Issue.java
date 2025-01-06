package _02_SOLID;

class SaveToDB1 {

	String invoice;

	public SaveToDB1(String invoice) {
		this.invoice = invoice;
	}

	public void saveToDB() {
		System.out.println("Saving invoice to DB : " + invoice);
	}

	/*
	 * Now you have requirement to save invoice to file as well. If you go ahead and
	 * modify existing SaveToDB1 class then you are adding below method and
	 * essentially modifying already live code
	 * 
	 * Hence fails this principle which essentially is asking not to modify already
	 * existing code
	 */
	public void saveToFile() {
		System.out.println("Saving invoice to File : " + invoice);
	}

}

public class _02_01_OpenClosedPrinciple_Issue {

	public static void main(String[] args) {

		SaveToDB1 daoObj = new SaveToDB1("invoice");
		daoObj.saveToDB();
		daoObj.saveToFile();
	}

}
