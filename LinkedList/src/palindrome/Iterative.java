package palindrome;

import java.util.Stack;
// 如果是直接iterative 需要将前一部分存起来，因为和后一部分反向比较，所以想到用的是stack
// 因为是一半一半进行比较，所以仍然可以用的是slow和fast 的两个指针，然后一起向前走，慢的边走边存，快的到头说明慢的存了一半。
// 但是如果是奇数个，慢的少跑一个，需要将这一个跳开，奇数个检查的技巧不在于直接去计数，而是看快的是不是null 如果快的不是null
// 说明指直接fast。next 为null跳出上面的循环。
// 最后边取stack 的值边比较。
import removeDuplicate.LinkedListNode;

public class Iterative {
	public boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();

			if (top != slow.data) {
				return false;
			}

			slow = slow.next;
		}
		return true;
	}
}
