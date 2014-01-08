package reorderList;
//方法是首先通过两个指针找到中点（需要记住）
//然后是将后面进行倒序（方法也同样需要记住）
//最后是将两个list 进行相互嵌套，（同样是需要记住）
public class O1ReorderList {
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode runner = head;
		ListNode walker = head;
		
		while (runner != null && runner.next != null) {
			runner = runner.next.next;
			walker = walker.next;
		}
//		本身和next 不能为空，然后两个一起跑，walker 的那个是偶数正好为前一个，奇数为中间一个
		
		ListNode reverseHead = walker.next; //拆成两条list
		walker.next = null;
		reverseHead = reverseList(reverseHead);
		
		ListNode cur = head;
//		由于前面一个list 的个数要多所以以后面一个结束位结束。
//		同样是先把next 存起来然后指针从后向前赋值。
		while (reverseHead != null) {
			ListNode tmp = reverseHead.next;
			reverseHead.next = cur.next;
			cur.next = reverseHead;
			cur = cur.next.next;
			reverseHead = tmp;
		}
	}

	private static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		ListNode newHead = cur;
//		倒转的时候需要用中间变量来进行过度，指针转换也同样是从后往前。
//		
		while (cur.next != null) {
			ListNode tmp = cur.next;
			cur.next = cur.next.next;
			tmp.next = newHead;
			newHead = tmp;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(5);
//		ListNode l6 = new ListNode(6);
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = null;

		printList(l1);
		reorderList(l1);
		printList(l1);
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("------------");
	}
}
