package convertSortedListToBST;
// 如果只用list 的形式，就只能用in order 的方式，先求出左边的，然后中间最后右边。
// 但是要返回两个参量一个是treenode 为了之后parent 的链接使用，还有一个是listnode 给parent 找下一个listnode 用的。
// 所以用了一个wrapper class 对他进行包装，整体输送， 要注意的是，为了达到移动listnode 的目的。返回的时候treenode 是parent listnode 应该是right 的node
// 因为listnode 要向前进。
// base case 是start > end 的情况，应该就是返回现在这个listnode 然后treenode 是null 因为什么都没有做。
// 这里省略掉了相等的情况，应该也是新建一个parent 不过返回的应该是parent 的list node 因为没有right child 的listnode
public class ListOnly {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}

		return (sortedListToBSTHelper(head, 0, len - 1)).treeNode;

	}

	private Element sortedListToBSTHelper(ListNode head, int start, int end) {
		if (start > end) {
			return new Element(head, null);
		}
		int mid = (start + end) / 2;
		Element left = sortedListToBSTHelper(head, start, mid - 1);
		ListNode p = left.listNode;
		TreeNode parent = new TreeNode(p.val);
		parent.left = left.treeNode;
		ListNode r = p.next;
		Element right = sortedListToBSTHelper(r, mid + 1, end);
		parent.right = right.treeNode;
		return new Element(right.listNode, parent);

	}

	public class Element {
		ListNode listNode;
		TreeNode treeNode;

		public Element(ListNode l, TreeNode t) {
			listNode = l;
			treeNode = t;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		l1.next = l2;
		System.out.println(new ListOnly().sortedListToBST(l1));
	}

}
