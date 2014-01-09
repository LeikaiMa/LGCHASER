package addTwoNumbers;
// II
//在list 里面求两个数的加法，因为这一题是反向，所以不需要padding 也不需要递归。
//首先去掉基本的条件，如果两个都是null 就直接返回null 如果有一个是null 返回另外一个。
//两个都不是null，可以求第一个，保证可以得到开始的head 最后可以用这个head 来进行返回。
//两边同时进行向后移动一位。直到两个都是null 为止。中间的求sum 用的是 %10 求carry 是/10 
//然后新建一个listnode 用来存后面的数据，每次存完之后向后移动一位。
//最后看carry 有没有值，如果有值还要再结果里面新加一个1


// 这里用到了dummy head 省的自己担心哪个是head
// 然后还是看l1 l2 c 都要不是0 或者null 的情况，这里要注意的是只有l1 或者l2 不是null 的情况，才next
public class DummyHead {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int c = 0;
        
        while (l1 != null || l2 != null || c > 0) {
            int v = c;
            if (l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                v += l2.val;
                l2 = l2.next;
            }
            
            ListNode l = new ListNode(v % 10);
            c = v / 10;
            prev.next = l;
            prev = prev.next;
        }
        
        return dummy.next;
    }
}
