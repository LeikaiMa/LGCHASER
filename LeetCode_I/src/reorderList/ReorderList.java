package reorderList;

public class ReorderList {

	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode runner = head;
		ListNode walker = head;
		while (runner.next != null) {
			runner = runner.next;
		}
		linkHeadTail(walker, runner);

	}

	private static void linkHeadTail(ListNode walker, ListNode runner) {
		if ((walker == runner) || (walker.next == runner)) {
			runner.next = null;
			return;
		}
		ListNode leader = walker.next;
		ListNode chaser = leader;
		while (chaser.next != runner) {
			chaser = chaser.next;
		}
		walker.next = runner;
		runner.next = leader;
		linkHeadTail(leader, chaser);

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
		l5.next = null;
		l6.next = null;

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
