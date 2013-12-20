package palindrome;

// palindrome 也可以用递归的方法来进行比较，base case 是在最中间，可以是null 也可以是已经存在但是length 的长度是0
// 这两种情况都是没有node 但是 可以算作是对称的。
// 如果是length 是1, 同样目前为止是对称，需要返回的是后面一个node
// 如果是length 是2， 这时候要进行比较的是这两个node 后面的 node，是否是对称就要判断这两个是否相同。
// 这里面递归的本质是通过里面的node 的参量依次向后移动，达到遍历后面的node 的目的。 而递归也就是返回，达到从中间向前的逆向遍历的目的。
// 这里面要注意的是每次进去的时候是后面一个node 而且length 也减少2
// 而且返回的时候比较，如果已经是false 可以直接返回。或者里面本来就没有node
// 如果正常的比较就要把result 比较出来，比较的双方是目前的node还有是返回的的后面的node 然后后半部分的node也会向后移动一位。
// 递归的实质一部分和stack 一样。是为了反向。
import removeDuplicate.LinkedListNode;

public class Recursive {
	public Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length == 0) {
			return new Result(null, true);
		} else if (length == 1) {
			return new Result(head.next, true);
		} else if (length == 2) {
			return new Result(head.next.next, head.data == head.next.data);
		}

		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null) {
			return res;
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	public boolean isPalindrome(LinkedListNode head) {
		Result p = isPalindromeRecurse(head, listSize(head));
		return p.result;
	}

	private int listSize(LinkedListNode head) {
		// TODO Auto-generated method stub
		return 0;
	}
}
