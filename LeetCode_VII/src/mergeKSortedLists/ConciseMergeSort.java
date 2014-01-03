package mergeKSortedLists;

import java.util.ArrayList;
// 这个就是按照顺序来merge
// 但里面用了一点小技巧是为了防止整个list 太长，就是从两边开始向中间靠拢进行两两merge 全部存到左边，然后重新左边界回到0 开始往中间进行merge
// 直到右边界为0 就剩下一个list 
// 最后返回这个listnode
public class ConciseMergeSort {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}

		int last = lists.size() - 1;

		while (last > 0) {
			int cur = 0;
			while (cur < last) {
				lists.set(cur, merge(lists.get(cur++), lists.get(last--)));
			}
		}
		return lists.get(0);
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;

		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				prev.next = head1;
				head1 = head1.next;
				prev = prev.next;
			} else {
				prev.next = head2;
				head2 = head2.next;
				prev = prev.next;
			}
		}

		if (head1 == null) {
			prev.next = head2;
		} else {
			prev.next = head1;
		}
		return dummy.next;
	}
}
