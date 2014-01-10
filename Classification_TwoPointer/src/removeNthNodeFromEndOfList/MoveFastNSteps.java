package removeNthNodeFromEndOfList;
// II
//要删去倒数第n个数，需要有至少两个指针来指位置。
//一个先遍历，走n 步和后走的拉开n 步差距。
//然后两个同时走走到最后。
//最后删除后走的所在的元素。 这时候引进一个慢一拍的指针，作用是找到前一个的node 让前一个和后一个直接相连。
//方法是前一个在走的慢的指针变化之前赋值。
//最后删除的时候要注意，如果直接是head，返回后面一个的node
//如果不是开头的情况，删除node 之后返回的还是返回head

// 在这里多用了一个dummy这样prev 就可以直接赋值给dummy 自己独立next 而不需要slow 先赋值给他。而且也不需要单独考虑删除head 的问题。
public class MoveFastNSteps {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = dummy;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
			prev = prev.next;
		}

		prev.next = slow.next;

		return dummy.next;
	}
}
