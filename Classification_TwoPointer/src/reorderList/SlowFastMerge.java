package reorderList;
// I - 13
//方法是首先通过两个指针找到中点（需要记住）
//然后是将后面进行倒序（方法也同样需要记住）
//最后是将两个list 进行相互嵌套，（同样是需要记住）
//本身和next 不能为空，然后两个一起跑，walker 的那个是偶数正好为前一个，奇数为中间一个
//由于前面一个list 的个数要多所以以后面一个结束位结束。
//同样是先把next 存起来然后指针从后向前赋值。

// 要注意的是同时出发，慢的比快的最后多一个，然后将少的往多的里面进行插，这样注意。
// 犯错就犯在这里。可以加一个tmp 作为中间值过渡会消掉的next
public class SlowFastMerge {
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = slow.next;

		slow.next = null;

		ListNode last = dummy.next;
		if (last != null) {
			while (last.next != null) {
				ListNode cur = last.next;
				last.next = cur.next;
				cur.next = dummy.next;
				dummy.next = cur;
			}
		}

		ListNode head2 = dummy.next;
		ListNode head1 = head;
		while (head2 != null) {
			ListNode tmp = head2;
			head2 = head2.next;
			tmp.next = head1.next;
			head1.next = tmp;
			head1 = head1.next.next;
		}

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(3);
		// ListNode l4 = new ListNode(4);
		// ListNode l5 = new ListNode(5);
		// ListNode l6 = new ListNode(6);
		l1.next = l2;
//		l2.next = l3;
		// l3.next = l4;
		// l4.next = l5;
		// l5.next = l6;
		// l6.next = null;

		printList(l1);
		reorderList(l1);
		printList(l1);
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("------------");
	}
}
