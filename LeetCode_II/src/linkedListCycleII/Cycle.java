package linkedListCycleII;
// 检查loop 的起点首先要检查是否是有loop 也就是跑的快的会不会和跑的慢的相遇。
// 如果有loop 相遇的地点距离入口和最开始距离相同，两个再同时从两个地点用相同的速度跑就会相遇。
public class Cycle {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode runner = head;
		ListNode walker = head;

		while (runner != null && runner.next != null) {
			runner = runner.next.next;
			walker = walker.next;
			if (runner == walker) {
				break;
			}
		}

		if (runner == null || runner.next == null) {
			return null;
		} else {
			walker = head;
			while (walker != runner) {
				walker = walker.next;
				runner = runner.next;
			}
			return runner;
		}
	}
}
