package removeNthNodeEnd;
// 要删去倒数第n个数，需要有至少两个指针来指位置。
// 一个先遍历，走n 步和后走的拉开n 步差距。
// 然后两个同时走走到最后。
// 最后删除后走的所在的元素。 这时候引进一个慢一拍的指针，作用是找到前一个的node 让前一个和后一个直接相连。
// 方法是前一个在走的慢的指针变化之前赋值。
// 最后删除的时候要注意，如果直接是head，返回后面一个的node
// 如果不是开头的情况，删除node 之后返回的还是返回head
public class RemoveNthNodeFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode runner = head;
		ListNode walker = head;
		ListNode slower = null;
		for (int i = 0; i < n; i++) {
			runner = runner.next;
		}
		while (runner != null) {
			slower = walker;
			runner = runner.next;
			walker = walker.next;
		}
		if (walker == head) {
			head = head.next;
		} else {
			slower.next = walker.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		printList(l1);
		ListNode head = removeNthFromEnd(l1, 1);
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
