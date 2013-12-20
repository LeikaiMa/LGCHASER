package linkedListCycleI;
// 这个本质就是同时跑的情况下，跑的快的会不会和跑的慢再次相遇
public class Cycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode runner = head;
		ListNode walker = head;

		while (runner != null && runner.next != null) {
			runner = runner.next.next;
			walker = walker.next;
			if (walker == runner) {
				break;
			}
		}

		if (runner == null || runner.next == null) {
			return false;
		} else {
			return true;
		}

	}
}
