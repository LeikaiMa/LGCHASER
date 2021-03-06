package sortList;
// 看到了要求是sort list ，而且要求是O(nlogn) 的复杂度，所以基本就锁定是merge sort 或者是 quick sort ，quick sort 一般是 双向链表
// 所以用的是merge sort 来sort 单向链表。
// merge sort 的关键是拆成一半，一直拆，拆到最小的一个或者没有，就返回，这个作为头，如果是两个或者是两个以上，就要继续拆分，
// 然后拆好的两个，将这两个merge 到一起，然后返回head 这个作为新的head 返回，这个过程是top 到 bottom 然后bottom 回到 top
// 拆分的时候要注意的是，用两个指针一个快指针，一个慢指针，慢的在head 快是head.next 然后慢的一步一格，快的一步两格，直到，快的不能往后走了
// 注意的是，快的先看自己是不是空的，然后再看后面是不是空的。
// 关键点是分开的第一条链是head 第二条链是 慢指针的后面一个。
// 要将两个链分开来，就是要将慢指针的next 指向 null
// 然后merge 时候，不要考虑头的问题，直接用一个dummy 的head 然后用prev 来进行解决， 每次都是插在prev 的next 上，然后prev 和插入的那个head 往后移动。
// 然后返回的是dummy 的next 就是头
public class MergeSort {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head1 = head;
		ListNode head2 = slow.next;
		slow.next = null;

		head1 = sortList(head1);
		head2 = sortList(head2);

		return merge(head1, head2);
	}

	private static ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;

		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				prev.next = head1;
				head1 = head1.next;
			} else {
				prev.next = head2;
				head2 = head2.next;
			}
			prev = prev.next;
		}

		if (head1 == null) {
			prev.next = head2;
		} else {
			prev.next = head1;
		}
		return dummy.next;

	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "=>");
			head = head.next;
		}

		System.out.println("NULL");
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(2);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		ListNode head = sortList(l1);
		printList(head);

	}

}
