package stackSets;

import java.util.ArrayList;
// 关键点是在给号stack 来进行pop，这时候要leftShift， 将右边的移到左边。
// 因为要看移动头部和移动底部两种不同情况，这样传入一个boolean参量来进行区分。
// 这时候要用到递归，要取到下一个stack 的bottom。
// base case 就是最后一个set 也就是stack.size 要大于 index + 1
// 同时要注意如果remove bottom之后stack 空了，需要手动删掉这个stack。
// 依次递归填满原先的top 就可以算完成。
public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<>();
	public int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}

	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(v);
		} else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int v = last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return v;
	}

	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if (removeTop) {
			removed_item = stack.pop();
		} else {
			removed_item = stack.removeBottom();
		}

		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
}
