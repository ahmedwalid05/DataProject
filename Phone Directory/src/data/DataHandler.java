package data;
import structure.Stack;

import structure.DoublyLinkedList;

public class DataHandler {

	private DoublyLinkedList<Contact> contactList;
	public DataHandler() {
		contactList = new DoublyLinkedList<>();
	}

	public void addContact(Contact contact) {
		contactList.add(contact);



	}
	public Object[][] getDataAsTwoArray(){
		Object objects[][]= new Object[contactList.count()][4];
		for(int i=0;i<contactList.count();i++) {
			objects[i][0]= contactList.get(i).getData().getId();
			objects[i][1]= contactList.get(i).getData().getName();
			objects[i][2]= contactList.get(i).getData().getEmail();
			objects[i][3]= contactList.get(i).getData().getNumber();
		}
		return objects;
	}

	public int searchStack(String...data) {
		Stack<String> stack = new Stack<String>();		
		for (int i = 0; i < data.length; i++) {
			stack.push(data[i]);	
		}
		stack.print();
		String popedItem;
		while((popedItem = stack.pop())!=null) {
			//TODO Search function idk
		}

		return 0;
	}
	
	public void deleteContact(int postion) {
		contactList.delete(postion);
	}
	public Contact get(int postion) {
		return contactList.get(postion).getData();

	}
	public void print() {
		contactList.print();
	}
}
