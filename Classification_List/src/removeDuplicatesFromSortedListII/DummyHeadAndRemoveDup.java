package removeDuplicatesFromSortedListII;
//III
// 同样是dummy 来解决头的问题。
// 这里要注意的是，如果和下面一个不同，就可以直接将prev 的next 放在这个上面，然后两个同时往后移动一位
// 如果相同就要过滤掉相同的，这个时候就要之前有个边界条件，是next 不为0 比较如果有相同的，就往后移动一位，
// 因为最后是要完全相同的都过滤掉，所以出来不管怎么样还是要往后移动一位。
// 最后出来的时候不管怎么样都要将现在这个值连接到prev 的后面，如果是null 正好连接null
// 如果是剩下最后一个，就连接最后一个。然后最后一个本身自己也连接着null
public class DummyHeadAndRemoveDup {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode p = head;
        
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                prev.next = p;
                prev = prev.next;
                p = p.next;
            } else {
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                p = p.next;
            }
        }
        
        prev.next = p;
        return dummy.next;
    }
}
