package structure;

public class Stack <T>{

	private int top;
	private T items[];

	public Stack() {
		items = (T[])new Object[10];
		top =-1;
	}
	public void push(T item) {
		if((top+1)==items.length) {
			T tempArr[] = (T[])new Object[items.length*2];
			for (int i = 0; i < items.length; i++) {
				tempArr[i]= items[i];
			}
			items=tempArr;

		}
		items[++top]=item;

	}
	public T pop() {
		return (top==-1)?null:items[top--];

	}
	public T peek() {
		if(top==-1)
			return null;
		else
			return items[top];
	}
	public void print() {
		System.out.print("[");
		for (int i = 0; i <= top; i++) 
			System.out.print(items[i]+",");
		System.out.print("]\n");

	}


}
