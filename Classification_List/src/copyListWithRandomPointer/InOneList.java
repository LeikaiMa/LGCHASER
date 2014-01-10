package copyListWithRandomPointer;
// 这个使用一个list 进行操作，将copy 放在现在这个list node 的后面，然后要找random 
// 也就是p.next.random = p.random.next
// 然后要将这个list断开，同时因为check 的时候要保证原来的list 不变。
// 要一点一点的断，都是两个pointer 前面一个的next 应该是后面的next，
// 然后要往后移动一个，这个时候就不是next 移动，而是用之前储存过的next 进行保证。
// 因为这一步一步都是两条链子在操作，所以既要保证现在这个node 不是null 也要保证下面一个node 的不是null
// 比较费脑子，如果可以用map 还是用map 比较好。
public class InOneList {
	public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }
        
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;   
            }
            p = p.next.next;
        }
        
        p = head;
        RandomListNode newHead = p.next;
        
        while (p != null && p.next != null) {
            RandomListNode tmp = p.next;
            p.next = tmp.next;
            p = tmp;
        }
        
        return newHead;
    }
	
	public static void main(String[] args) {
		RandomListNode l1 = new RandomListNode(1);
		l1.random = l1;
		System.out.println(copyRandomList(l1));
	}
}
