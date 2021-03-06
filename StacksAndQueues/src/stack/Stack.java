package stack;


public class Stack {
	Node top;
	public Object pop(){
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	public void push(int item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	public int peek() {
		return top.data;
	}
 }
