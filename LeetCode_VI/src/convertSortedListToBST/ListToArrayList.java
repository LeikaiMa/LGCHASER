package convertSortedListToBST;
// 因为考虑到list 是单向的不能回去，就不能用preorder 的方式。
// 所以采用的是将list node 放进arraylist 里面。这样就能够知道index 就能得到值。
// 要注意的是while 循环里面要将head 的next写下来，这个已经忘记了好几次了。
import java.util.ArrayList;

public class ListToArrayList {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		ArrayList<Integer> sortedData = new ArrayList<Integer>();
		while (head != null) {
			sortedData.add(head.val);
			head = head.next;
		}

		TreeNode root = sortedListToBSTHelper(sortedData, 0,
				sortedData.size() - 1);
		return root;
	}

	private TreeNode sortedListToBSTHelper(ArrayList<Integer> sortedData,
			int start, int end) {
		if (start == end) {
			return new TreeNode(sortedData.get(start));
		} else if (start > end) {
			return null;
		} else {
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(sortedData.get(mid));
			root.left = sortedListToBSTHelper(sortedData, start, mid - 1);
			root.right = sortedListToBSTHelper(sortedData, mid + 1, end);
			return root;
		}

	}
}
