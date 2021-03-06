package mergeKSortedLists;
//VII
//这个就是按照顺序来merge
//但里面用了一点小技巧是为了防止整个list 太长，就是从两边开始向中间靠拢进行两两merge 全部存到左边，然后重新左边界回到0 开始往中间进行merge
//直到右边界为0 就剩下一个list 
//最后返回这个listnode
import java.util.ArrayList;
//开始要判断里面有没有list 如果没有就直接返回null
public class ShrinkSizeToOne {
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

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				l1 = l1.next;
				prev = prev.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
				prev = prev.next;
			}
		}

		if (l1 != null) {
			prev.next = l1;
		} else {
			prev.next = l2;
		}

		return dummy.next;
	}
}
