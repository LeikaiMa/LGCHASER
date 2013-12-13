package stackWithMin;

import java.util.Stack;
// 为了避免过多的占用stack node 的空间，在建stack的时候可以重新开辟一个stack 用来存放min 如果有重复的就可以不比放进去，如果没有就要放进去。
// 这样的好处是可以节省空间。
// 对于stack 的函数比较有用的是isEmpty 来查看是否为空， pop 是取出， push 是存入，peek 是看最顶层的。
public class StackWithMin2 extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Stack<Integer> s2;

	public StackWithMin2() {
		s2 = new Stack<>();
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}

}
