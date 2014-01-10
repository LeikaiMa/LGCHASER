package removeDuplicatesFromSortedList;
//III
//删除重复的留下一个还算比较简单，因为不需要考虑头是否要重新设置的问题。
//如果head 本身就没有或者链就只有1个node 就可以直接返回。
//如果不止一个，就可以让两个pointer 一个放在head 上一个放在head 后面
//让后面的一个先走，如果还是相同就继续前进等于而且slow 的next 的随时更新，到新的node 上，算是去重。
//直到 快的和慢的不是同一个的val 的时候，slow 和fast 同时前进一格。
//以此往复，直到快的到达终点。
//最后返回的是head本身

// 原来如果相等就接后面一个比较好，这样不要在最后多补充slow 的next 是null，但是可能连接会多一些。
public class SlowConnectDifferentFast {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                fast = fast.next;
                slow = slow.next;
            }
        }
        
        slow.next = null;
        return head;
    }
}
