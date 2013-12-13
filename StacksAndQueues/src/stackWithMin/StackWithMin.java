package stackWithMin;

import java.util.Stack;
// 要想让min 也能够成为O（1），一种方法就是将其和node一起绑定，如果想知道 min 到底是什么，只要看peek 的min 是什么就可以了
// 如果stack 本身就是空的，就应该返回最大值。这样比较，被比较的值肯定小。
public class StackWithMin extends Stack<NodeWithMin> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}

}
