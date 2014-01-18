package insertionSortList;
//VII
//首先要了解insertion sort 是怎么运行的工作原理，是将一个无序的数组或者list ，从第二个开始，或者是从第一个开始，看怎么在前面的list 插进去，
//因为前面是已经排好序的，所以插在合适的位置，那么插完之后的也是一个sorted 的顺序。
//因为这个是list 所以是可以直接插的，所以只需要从头开始找，第一个比他大的，那么就插在他的前面。但是单链表，不能往前插，所以node 要提前预判，所以一直用的是这个的next 来进行比较
//这样一直是第一个比他大的node 的前面一个。
//如果next 的val 一直到了现在这个，说明已经是排好序的，所以就直接到下面一个。而每次都是从第一个的前面一个开始，所以用了一个dummy 来表示 头前面的一个。最后返回头的时候就只要返回dummy.next
//然后关键是在插的时候，首先因为next 的都在变，所以先把next 都存起来，这样以后就能找的到。
//让prev 的next 连新的node 然后让新的 node 的next 连上原来保存下来的prev 的next 也就是第一个比他大的，然后是后面的这个node 要连接新的node 的后面一个。
//这个时候要注意的是可能是要插到一个list 的中间，所以要找到这个list 的最尾部，同样是用next 来进行比较。
//用一个while 循环一直往后面进行查找。
//最后将这个连上之前保存的新node 的next 
//最后将新的node 移到下一个，不能直接next ，因为这个已经插到list 的中间。 所以直接将之前保存过的复制给他。
//这样就可以sort 结束。
//如果是数组，因为是不可以直接插进去，所以是要进行平移，所以是从新的node 往前开始比较，如果后面的比前面小，那么两个交换，同时往前移动一位，再进行比较。看是不是后面比前面要小。直到最开始
//所以要理解透各种数据结构的本质，根据这些本质来进行使用。

//这里主要要注意的是每次比较的时候用next 来进行比较，因为移动的时候要将前面的和后面相连，所以要时刻保留前面一个node 的reference。
public class DummyHeadAndPrevNodeToStorePrev {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy.next;

		while (prev.next != null) {
			ListNode compare = dummy;

			while (compare != prev && compare.next.val <= prev.next.val) {
				compare = compare.next;
			}

			if (compare != prev) {
				insert(compare, prev);
			} else {
				prev = prev.next;
			}
		}

		return dummy.next;
	}

	private void insert(ListNode compare, ListNode prev) {
		ListNode cur = prev.next;
		prev.next = cur.next;
		cur.next = compare.next;
		compare.next = cur;
	}
}
