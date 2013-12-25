package removeDuplicateFromListII;
// 因为要去重去掉全部，首先就要考虑头部重新设置的问题。
// 这时候可以利用while true 的方法，直到头和头后面一个不是null 的node 的val 不同为止。这个时候就算是将头部的重全部去掉。
// 期间同样也是要保证头和头的next 不为空，如果为空就代表整个链子没有node 或者是只有一个node
// 在里面进行的时候设置一个遍历的值，让其跑到null 或者是不同的val 的时候停止。然后head 就可以转换为现在的node
// 然后接下来如果从循环里面跳出来后，说明这个链子至少有两个不同的node 在开头。
// 因为此时的head 肯定就不会变了，所以返回的值是head。
// 让一个指向head 另一个放在head 的后面，开始遍历，这时候也用的是while true 的方法。
// 返回的时候保证现在这个fast 或者fast 的下一个node 是null
// 相比较前面一个，这时候的slow 要放在去重的前面一个，保证自己不被去重掉。
// 如果fast 只有一个值，next 和自身不相等两个pointer 同时前进
// 如果相等，就要去重，让fast先跑到和自己不同的地方后，slow 再把next 指向fast 这样可以将里面的node 全部去掉。
public class WhileTrue {
	public ListNode deleteDuplicates(ListNode head) {
		while (true) {
			if (head == null || head.next == null) {
				return head;
			}
			if (head.val != head.next.val) {
				break;
			}
			ListNode p = head;
			while (p != null && p.val == head.val) {
				p = p.next;
			}
			head = p;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while (true) {
			if (fast == null || fast.next == null) {
				return head;
			} else if (fast.next.val != fast.val) {
				slow = slow.next;
				fast = fast.next;
			} else {
				while (fast != null && fast.val == slow.next.val) {
					fast = fast.next;
				}
				slow.next = fast;
			}
		}
	}
}
