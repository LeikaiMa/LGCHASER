package convertSortedListToBinarySearchTree;
//VI
//如果只用list 的形式，就只能用in order 的方式，先求出左边的，然后中间最后右边。
//但是要返回两个参量一个是treenode 为了之后parent 的链接使用，还有一个是listnode 给parent 找下一个listnode 用的。
//所以用了一个wrapper class 对他进行包装，整体输送， 要注意的是，为了达到移动listnode 的目的。返回的时候treenode 是parent listnode 应该是right 的node
//因为listnode 要向前进。
//base case 是start > end 的情况，应该就是返回现在这个listnode 然后treenode 是null 因为什么都没有做。
//这里省略掉了相等的情况，应该也是新建一个parent 不过返回的应该是parent 的list node 因为没有right child 的listnode

//这里要注意的应该是parent 做完之后next 到下一个给right 而不是left next 给parent 用。这样就算到了leaf 也能next过去。
public class ReturnNextPointerAndParentTreeNode {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}

		return helper(head, 0, len - 1).t;
	}

	public class Element {
		public ListNode l;
		public TreeNode t;

		public Element(ListNode listNode, TreeNode treeNode) {
			l = listNode;
			t = treeNode;
		}
	}

	public Element helper(ListNode l, int start, int end) {
		if (start > end) {
			return new Element(l, null);
		}

		int mid = start + (end - start) / 2;
		Element left = helper(l, start, mid - 1);
		ListNode p = left.l;

		TreeNode parent = new TreeNode(p.val);
		parent.left = left.t;

		p = p.next;

		Element right = helper(p, mid + 1, end);
		parent.right = right.t;

		return new Element(right.l, parent);

	}
}
