package reverseLinkedListII;
//主要的步骤还是reverse 的小模块
//m = n  的时候可以优化直接返回
//如果不是从开头，就需要考虑将前面一段没有倒序的list 的最后一个和reverse 的开头连接到一起。
//需要判断 m 是否为1

// 开始的时候还是用dummy 作为头，这样就不需要单独考虑头的问题。
// 然后开始先走m-1 步，这样这些前面不用过滤的可以直接走过。然后将后面的reverse n-m 次。
// 返回的是dummy 后面的
public class DummyHead {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;

		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}

		ListNode last = prev.next;
		for (int i = m; i < n; i++) {
			ListNode cur = last.next;
			last.next = cur.next;
			cur.next = prev.next;
			prev.next = cur;
		}

		return dummy.next;
	}
}
