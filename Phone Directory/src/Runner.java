import data.Contact;
import data.DataHandler;

public class Runner {

	private static DataHandler dataHandler = new DataHandler();
	public static void main(String[] args) {
		
		String s = "1- Add new contact\n"
				+ "2- Edit an existing contact\n"
				+ "3- Deleting an existing contact\n"
				+ "4- Ordering ascending\n"
				+ "5- Ordering descending\n"
				+ "6- Search\n";
		System.out.println(s);
		int x=0;
		switch (x) {
		case 1:
			
			dataHandler.addContact(new Contact(01, "Ahmed", "A01Ahmed@gmail.com", 89743562, 974));
			break;
		case 2:
			//dataHandler.getContanct("").
			break;
		case 3:

			break;

		default:
			break;
		}
	}

}
