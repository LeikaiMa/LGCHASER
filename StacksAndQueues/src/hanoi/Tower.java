package hanoi;

import java.util.Stack;

// 这里面先检查是否为empty 可以保证peek 没有错。
// 看到这些需要很多步形成的，而且需要从简单开始的，很多情况下可以是数学归纳法。
// 从最简单的开始，可以看出，当n <= 0 的时候，不需要做什么。
// 而在1 以后，通常的步骤是先将n-1利用目的地全部移到buffer 上面，然后将本身移到目的地上，最后将buffer 上的东西利用最开始的柱子移到目的地。
// 因为本身n-1 移动也是要调用n-2 所以是递归里套用递归。
public class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<>();
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk" + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to "
				+ t.index());
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}
