package swapNodesInPairs;
// II
//pair 交换要注意的是要考虑next 和 next next 是否都有值，不然就算结束
//开始要单独处理的是头部，因为之前没有要考虑的元素，所以1的next 是2 的next， 2的next 是1  head 变成 2
//因为后面要和前面连在一起所以要多留一个前一个的最后一个node 的信息。
//然后进行处理 最后返回的 似乎head


//  这里多加了一个dummy head 就不需要单独处理head 的问题。 然后因为是pair 所以是两个两个span 进行解决问题。
public class DummyHead {
	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode next = prev.next;
            ListNode nNext = prev.next.next;
            
            next.next = nNext.next;
            nNext.next = next;
            prev.next = nNext;
            
            prev = prev.next.next;
        }
        
        return dummy.next;
    }
}
