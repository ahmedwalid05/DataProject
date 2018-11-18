package structure;

public class DoublyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	public DoublyLinkedList() {

	}
	public void add(T data) {
		if(tail== null) {
			head = new Node<T>(data, null,null);
			tail=head;
		}else {
			tail.setNext(new Node<T>(data, null,tail));
			tail = tail.getNext();
		}		
	}
	public void insert(T data, int postion) {
		if(postion==0)
			head=new Node<T>(data, head, null);
		else {
			Node<T> node = get(postion);
			System.out.println();
			node.getPrevious().setNext(new Node<T>(data, node, node.getPrevious()));
			node.getNext().setPrevious(node);

		}
	}
	public T delete(int postion){
		Node<T> node = get(postion);
		if(postion==0)
			head=node.getNext();
		else
			node.getPrevious().setNext(node.getNext());		
		return node.getData();
	}
	public int count() {
		Node<T> e = head;
		int counter=0;
		while(e!=null) {
			counter++;
			e=e.getNext();
		}
		return counter;
	}
	
	 public int sumElement() {
		 Node<T> e =head;
		 int sum=0;
		 while(e!=null) {
			sum+=(int)e.getData();
			e=e.getNext();
		 }			 
		 return sum;
	 }	



	public Node<T> get(int postion) {
		boolean found =false;

		Node<T> e=head;
		int counter=0;

		while(e!=null) {
			if(counter ==postion) { 
				found = true;
				break;
			}
			counter++;
			e=e.getNext();		
		}

		return (found)?e:null;
	}


	public void print() {
		Node<T> e=head;
		while(e!=null) {
			System.out.println(e.getData());
			e=e.getNext();

		}
	}

}