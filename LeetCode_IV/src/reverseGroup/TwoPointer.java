package reverseGroup;

// 这个方法是将head 和其他进行单独处理，比较繁琐，容易出错，虽然通过了。
public class TwoPointer {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1 || k == 0) {
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		int i = 0;
		for (i = 0; i < k - 1; i++) {
			if (fast == null) {
				break;
			}
			slow = fast;
			fast = fast.next;
		}

		if (i < k - 1) {
			return head;
		}

		ListNode runner = head.next;
		ListNode walker = head;
		head.next = fast;
		ListNode newHead = slow;
		while (runner != fast) {
			ListNode tmp = runner;
			runner = runner.next;
			tmp.next = walker;
			walker = tmp;
		}
		ListNode tmpSlow = head;

		while (fast != null) {
			ListNode tmpHead = fast;
			ListNode tmpFast = fast;
			fast = tmpHead.next;
			slow = tmpHead;

			for (i = 0; i < k - 1; i++) {
				if (fast == null) {
					break;
				}
				slow = fast;
				fast = fast.next;
			}

			if (i < k - 1) {
				break;
			}

			runner = tmpHead.next;
			walker = tmpHead;
			tmpHead.next = fast;
			tmpHead = slow;
			while (runner != fast) {
				ListNode tmp = runner;
				runner = runner.next;
				tmp.next = walker;
				walker = tmp;
			}

			tmpSlow.next = tmpHead;
			tmpSlow = tmpFast;
		}
		return newHead;

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
