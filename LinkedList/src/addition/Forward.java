package addition;

import removeDuplicate.LinkedListNode;
// 因为是正向，所以是最后一位是相反的，要保证最后一位对应最后一位，所以要把短的前面补0，用到padList 这个方法
// 在头的前面加上一个node， 然后把指针指清楚，返回的是新的头，也就是新建的node
// 然后同样的是要进行递归，base case 是两个都变成null 也就是到了最尾部。
// 因为是要包括一个sum 和一个carry 所以用一个wrapper class 来进行，因为sum的 是一个node 每次也是要进行更新，作为头。
// 在add 里面也是同样的加数和被加数还有carry 相加，然后保存进去的是% 10，然后carry 里面保存的是/10 然后返回的是目前的 这个wrapper 
// 每次得到的结果也是前插，然后返回的是前插之后的head
// 最后看是否carry 是否有值，如果有1 就在最后的前面再前插一个node
public class Forward {
	public class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}

	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);

		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}

		PartialSum sum = addListsHelper(l1, l2);

		if (sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}

		PartialSum sum = addListsHelper(l1.next, l2.next);

		int val = sum.carry + l1.data + l2.data;

		LinkedListNode full_result = insertBefore(sum.sum, val % 10);

		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data, null, null);
		if (list != null) {
			list.prev = node;
			node.next = list;
		}
		return node;
	}

	LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			LinkedListNode n = new LinkedListNode(0, null, null);
			head.prev = n;
			n.next = head;
			head = n;
		}
		return head;
	}

	private int length(LinkedListNode l1) {
		int count = 0;
		while (l1 != null) {
			count++;
			l1 = l1.next;
		}
		return count;
	}
}
