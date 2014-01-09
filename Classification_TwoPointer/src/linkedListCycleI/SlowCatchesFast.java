package linkedListCycleI;
// II
//这个本质就是同时跑的情况下，跑的快的会不会和跑的慢再次相遇
public class SlowCatchesFast {
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
