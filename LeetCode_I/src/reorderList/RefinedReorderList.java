package reorderList;

public class RefinedReorderList {
	public static void reorderList(ListNode head) {
		if ((head == null) || (head.next == null) || (head.next.next == null)) {
			return;
		}
		ListNode walker = head;
		ListNode runner = head;
		while (true) {
			if (runner.next == null) {
				break;
			}
			if (runner.next.next == null) {
				break;
			}

			runner = runner.next.next;
			walker = walker.next;
		}
		if (runner.next != null) {
			runner = runner.next;
		}

		if (walker.next.next != null) {
			reverseList(walker.next, walker.next.next);
			walker.next.next = null;
		}

		walker.next = null;
		mergeTwoList(head, runner);
	}

	private static void mergeTwoList(ListNode firstListNode,
			ListNode secondListNode) {

		ListNode tmp1 = firstListNode.next;
		ListNode tmp2 = secondListNode.next;
		firstListNode.next = secondListNode;
		secondListNode.next = tmp1;
		while (tmp2 != null) {

			firstListNode = tmp1;
			secondListNode = tmp2;
			tmp1 = firstListNode.next;
			tmp2 = secondListNode.next;
			firstListNode.next = secondListNode;
			secondListNode.next = tmp1;
		}

	}

	private static void reverseList(ListNode firstNode, ListNode secondNode) {
		if (secondNode.next == null) {
			secondNode.next = firstNode;
			return;
		}
		reverseList(firstNode.next, secondNode.next);
		secondNode.next = firstNode;

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
