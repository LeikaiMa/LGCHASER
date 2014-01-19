package sortList;
//VII
//看到了要求是sort list ，而且要求是O(nlogn) 的复杂度，所以基本就锁定是merge sort 或者是 quick sort ，quick sort 一般是 双向链表
//所以用的是merge sort 来sort 单向链表。
//merge sort 的关键是拆成一半，一直拆，拆到最小的一个或者没有，就返回，这个作为头，如果是两个或者是两个以上，就要继续拆分，
//然后拆好的两个，将这两个merge 到一起，然后返回head 这个作为新的head 返回，这个过程是top 到 bottom 然后bottom 回到 top
//拆分的时候要注意的是，用两个指针一个快指针，一个慢指针，慢的在head 快是head.next 然后慢的一步一格，快的一步两格，直到，快的不能往后走了
//注意的是，快的先看自己是不是空的，然后再看后面是不是空的。
//关键点是分开的第一条链是head 第二条链是 慢指针的后面一个。
//要将两个链分开来，就是要将慢指针的next 指向 null
//然后merge 时候，不要考虑头的问题，直接用一个dummy 的head 然后用prev 来进行解决， 每次都是插在prev 的next 上，然后prev 和插入的那个head 往后移动。
//然后返回的是dummy 的next 就是头

//这里面要注意的就是因为要截成一半，所以开始的时候fast 应该是在head next 而不是head，不然就要用fast.next 和 fast.next.next
public class CutOneListIntoHalves {
	public ListNode sortList(ListNode head) {
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

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				l1 = l1.next;
				prev = prev.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
				prev = prev.next;
			}
		}

		if (l1 != null) {
			prev.next = l1;
		} else {
			prev.next = l2;
		}

		return dummy.next;
	}
}
