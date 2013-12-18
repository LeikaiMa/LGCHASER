package rotateList;
// 因为是要旋转，所以先让他直接收尾相连，这样旋转就不需要考虑是不是会到尾巴，
// 在第一遍走的时候可以顺便把所有的个数算出来，这样可以为后面来使用。
// 右旋转多少个实际上是从开头往后数到哪个截开作为尾巴，
// 因为之前便利的时候已经到了尾巴，所以可以顺便用一下
// 可以进行优化的地方在于如果只有一个可以直接返回
// 如果转了很多圈，可以用% 把他放到一圈当中。
// 还有在截出尾巴的前，跳到下一个上去作为头返回。这样比较方便
public class Rotate {
	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		int count = 1;
		ListNode runner = head;
		while (runner.next != null) {
			count++;
			runner = runner.next;
		}
		runner.next = head;
		int move = n % count;
		for (int i = 0; i < count -move; i++) {
			runner = runner.next;
		}
		head = runner.next;
		runner.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = rotateRight(l1, 2);
		printList(head);
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "=>");
			head=head.next;
		}
		System.out.println("NULL");
	}
}
