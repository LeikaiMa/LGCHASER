package mergeKSortedLists;
// 考虑到要merge 多个list ，往往也是两条两条进行merge 所以这里做繁了，不需要考虑二分法的问题，只需要进行遍历就可以了。
// 然后就是普通的两条list 之间的merge 用dummy 做开头，两条进行merge。
import java.util.ArrayList;

public class MergeSort {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		return mergeKListsHelper(lists, 0, lists.size() - 1);
	}

	private ListNode mergeKListsHelper(ArrayList<ListNode> lists, int start,
			int end) {
		if (start == end) {
			return lists.get(start);
		} else if (end - start == 1) {
			return merge(lists.get(start), lists.get(end));
		} else {
			int mid = start + (end - start) / 2;
			ListNode head1 = mergeKListsHelper(lists, start, mid);
			ListNode head2 = mergeKListsHelper(lists, mid + 1, end);
			return merge(head1, head2);
		}
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		
		while (head1 != null && head2!= null) {
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
