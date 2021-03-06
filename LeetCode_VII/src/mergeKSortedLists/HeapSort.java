package mergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
// 这里用的heapsort 将元素塞进一个heap 当中，然后从heap 中取顶上的值，就是目前为止最小的。
// 因为是sort 过的，所以就不用全部塞进去，而是一个一个塞，这样也会省掉排序的时间。
// Comparator 是要自己写，里面的参数类型就是你想要的，然后还需要override 一个method
// 告诉这个heap如何比较。 然后heap 开始生成的时候定下了大小和Comparator。
// 然后将所有list 的node 先塞进去。
// 然后开始取，直到全部取出来，开始还要设置一个head ，如果head 是null 时候就要将刚刚出来的这个设置为head 然后还要设置一个随时移动的node
// 每次都是将node 放在这个的next 上，然后这个node也会后移一位始终在最后面。
// 然后负责将这个list 的node 塞进heap
// 如果这个后面的没有node 了就不塞，但是这个也要考虑到
// 最后要返回haed， 这个是一个比较好的heapsort 的方法。
// http://n00tc0d3r.blogspot.com/2013/04/merge-k-sorted-lists.html
public class HeapSort {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}

		Comparator<ListNode> comparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val < n2.val) {
					return -1;
				}
				if (n1.val > n2.val) {
					return 1;
				}
				return 0;

			}
		};

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);

		for (ListNode node : lists) {
			if (node != null) {
				heap.add(node);
			}
		}

		ListNode head = null, cur = null;
		while (!heap.isEmpty()) {
			if (head == null) {
				head = heap.poll();
				cur = head;
			} else {
				cur.next = heap.poll();
				cur = cur.next;
			}
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}

		return head;
	}

}
