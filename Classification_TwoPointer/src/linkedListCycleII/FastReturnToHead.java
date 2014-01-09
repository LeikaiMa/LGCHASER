package linkedListCycleII;
// II
//检查loop 的起点首先要检查是否是有loop 也就是跑的快的会不会和跑的慢的相遇。
//如果有loop 相遇的地点距离入口和最开始距离相同，两个再同时从两个地点用相同的速度跑就会相遇。
public class FastReturnToHead {
    public ListNode detectCycle(ListNode head) {
        if (head == null ||  head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        
        return null;
    }
}
