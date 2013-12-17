package reverseLinkedList;
//	主要的步骤还是reverse 的小模块
//	m = n  的时候可以优化直接返回
//	如果不是从开头，就需要考虑将前面一段没有倒序的list 的最后一个和reverse 的开头连接到一起。
//	需要判断 m 是否为1
public class ReverseLinkedList {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n) {
			return head;
		}
		int count = 1;
		ListNode reverseHead = head;
		ListNode tail = head;
		if (m > 1) {
			reverseHead = reverseHead.next;
			count++;
		}
		while (count < m) {
			reverseHead = reverseHead.next;
			tail = tail.next;
			count++;
		}
		
		ListNode cur = reverseHead;
		
		while (count < n) {
			ListNode tmp = cur.next;
			cur.next = cur.next.next;
			tmp.next = reverseHead;
			reverseHead = tmp;
			count++;
		}
		if  (m == 1) {
			return reverseHead;
		} else {
			tail.next = reverseHead;
			return head;
		}
		
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = null;

		printList(l1);
		ListNode head = reverseBetween(l1, 1, 6);
		printList(head);
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
