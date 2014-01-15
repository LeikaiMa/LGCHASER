package mergeTwoSortedLists;
//V
//用了dummy head 这个list node 然后真正的head 就可以直接返回dummy.next 作为返回值。
//里面进行的时候用prev的参量，这样可以类似于在字符串中间，有利于统一操作。
//要注意是从小到大，小的先插。别弄反了。
public class DummyHead {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }
        
        if (l1 != null) {
            prev.next = l1;
        } else {
            prev.next = l2;
        }
        
        return dummy.next;
    }
}
