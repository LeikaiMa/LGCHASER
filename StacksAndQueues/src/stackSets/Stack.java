package stackSets;

import stack.Node;
// 因为是算作很多stack 组成的set， 所以如果是在其中一个进行pop， 需要将其右边的bottom 移到头部
// 这个时候remove bottom 就比较重要，而对于node 之类的linkedlist 只需要将其删掉，然后前后链接连好，size 变小就可以了。
public class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() {
		return capacity == size;
	}
	
	public void join(Node above, Node below) {
		if (below != null) {
			below.above = above;
		}
		if (above != null) {
			above.below = below;
		}
	}
	
	public boolean push(int v) {
		if (size >= capacity) {
			return false;
		}
		size++;
		
		Node n= new Node(v);
		if (size == 1) {
			bottom = n;
		}
		
		join(n, top);
		top = n;
		return true;
	}
	
	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null) {
			bottom.below = null;
		}
		size--;
		return b.data;
	}
}
