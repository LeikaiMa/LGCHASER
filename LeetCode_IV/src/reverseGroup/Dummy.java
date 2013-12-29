package reverseGroup;
// 巧妙的运用dummy 来做头，这样后面的所有的操作都变成一样的了，然后返回的时候就是返回dummy.next
// 然后所有的反转操作都在一个模块里面。这个模块是在prev 和 next 之间夹着的模块。
// 因为是group 进行反转，所以有个计数器，每次统计到多少的倍数之后就调用函数进行反转，函数返回的值是反转后最后一个node 正好是可以做下一个prev
// next也就是这个数字后一个。
// 反转要领是将每个数字插到prev的后面，所以有last 这个参量，其实是prev 的next ，到了最后就成了last
// 每次是last 连到cur 的后面， cur 连到prev 的后面，然后cur 更新到last next 的那个。这样循环一直到cur 变成next 为止。
// cur 开始就是last 的next 
// 这个方法很巧妙，可以作为一个子模块记住。
 
public class Dummy {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				prev = reverse(prev, head.next);
				head = prev.next;
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	public static ListNode reverse(ListNode prev, ListNode next) {
		ListNode last = prev.next;
		ListNode cur = last.next;

		while (cur != next) {
			last.next = cur.next;
			cur.next = prev.next;
			prev.next = cur;
			cur = last.next;
		}
		return last;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "=>");
			head = head.next;
		}

		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		printList(l1);
		ListNode head = reverseKGroup(l1, 4);
		printList(head);

	}
}
