package stack;
// 最简单的linked list 是直接一个data 的内容和一个指针
// 如果是要在尾部加数据，就应该先移到尾部，然后在尾部插入。
public class Node {
	public Node next = null;
	public int data;
	public Node above;
	public Node below;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
