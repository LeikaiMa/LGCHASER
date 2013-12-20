package addTwoNumbers;
// 在list 里面求两个数的加法，因为这一题是反向，所以不需要padding 也不需要递归。
// 首先去掉基本的条件，如果两个都是null 就直接返回null 如果有一个是null 返回另外一个。
// 两个都不是null，可以求第一个，保证可以得到开始的head 最后可以用这个head 来进行返回。
// 两边同时进行向后移动一位。直到两个都是null 为止。中间的求sum 用的是 %10 求carry 是/10 
// 然后新建一个listnode 用来存后面的数据，每次存完之后向后移动一位。
// 最后看carry 有没有值，如果有值还要再结果里面新加一个1
public class Reverse {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		int carry = (l1.val + l2.val) / 10;
		ListNode head = new ListNode((l1.val + l2.val) % 10);
		l1 = l1.next;
		l2 = l2.next;
		ListNode l = head;
		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 == null) {
				sum = l2.val + carry;
				l2 = l2.next;
			} else if (l2 == null) {
				sum = l1.val + carry;
				l1 = l1.next;
			} else {
				sum = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			ListNode cur = new ListNode(sum % 10);
			carry = (sum / 10);
			l.next = cur;
			l = l.next;
		}

		if (carry != 0) {
			l.next = new ListNode(1);
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);
		ListNode l20 = new ListNode(5);
		ListNode l21 = new ListNode(9);
		ListNode l22 = new ListNode(6);
		
		l10.next = l11;
		l11.next = l12;
		l20.next = l21;
		l21.next = l22;
		
		printList(l10);
		printList(l20);
		ListNode l = addTwoNumbers(l10, l20);
		printList(l);
		
	}
	
	public static void printList(ListNode l) {
		while (l != null) {
			System.out.print(l.val + "=>");
			l = l.next;
		}
		System.out.println("NULL");
	}
}
