package swapNodePairs;
// pair 交换要注意的是要考虑next 和 next next 是否都有值，不然就算结束
// 开始要单独处理的是头部，因为之前没有要考虑的元素，所以1的next 是2 的next， 2的next 是1  head 变成 2
// 因为后面要和前面连在一起所以要多留一个前一个的最后一个node 的信息。
// 然后进行处理 最后返回的 似乎head
public class SwapPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode second = head.next;
		ListNode previous;
		first.next = second.next;
		second.next = first;
		previous = first;
		head = second;
		while (first.next != null && first.next.next != null) {
			first = first.next;
			second = first.next;
			first.next = second.next;
			second.next = first;
			previous.next = second;
			previous = first;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		printList(l1);
		ListNode head = swapPairs(l1);
		printList(head);

	}

	private static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "=>");
			head = head.next;
		}

		System.out.println("Null");
	}
}
