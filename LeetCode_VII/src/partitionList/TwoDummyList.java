package partitionList;
// 这里要按照某个数值将一个list 进行分开，用两个dummy 作为两条链子的头，然后用prev 往后进行移动连接新的node
// 原来的head 在里面进行遍历，如果小就连接到1 如果大于等于就连接到2
// 到最后，记住要给这两个链子最后设置断，设为null
// 不然可能会和其他的node 还保持着联系，会形成circle
// 然后将两条链子连接到一起，要注意的是如果小的链子没有就直接返回大于等于的链子，如果存在就将小的链子的最后面连接上大于等于的链子。
public class TwoDummyList {
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode prev1 = dummy1;
		ListNode prev2 = dummy2;

		while (head != null) {
			if (head.val < x) {
				prev1.next = head;
				head = head.next;
				prev1 = prev1.next;
			} else {
				prev2.next = head;
				head = head.next;
				prev2 = prev2.next;
			}
		}
		prev1.next = null;
		prev2.next = null;
		if (dummy1.next == null) {
			return dummy2.next;
		} else {
			prev1.next = dummy2.next;
			return dummy1.next;
		}
	}
	
	public static void  printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "=>");
			head = head.next;
		}
		System.out.println("Null");
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		int x = 2;
		ListNode head = partition(l1, x) ;
		printList(head);
		
	}
}
