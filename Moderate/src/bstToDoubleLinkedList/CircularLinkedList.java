package bstToDoubleLinkedList;
// 为了节省遍历的次数，可以将链打造成环状，不需要进行遍历，只需要在第一个node 的node1 就指向了最后一个node
// 然后有了最后一个node 就可以将这个node 和后面的node 进行连接。
// 最后结束的时候需要考虑断开首尾连接，一般是先断开尾部与头的连接，然后再断开头部与尾的链接。反之无法到达尾部
public class CircularLinkedList {
	public static BiNode convertToCircular(BiNode root) {
		if (root == null) {
			return null;
		}

		BiNode part1 = convertToCircular(root.node1);
		BiNode part3 = convertToCircular(root.node2);

		if (part1 == null && part3 == null) {
			root.node1 = root;
			root.node2 = root;
			return root;
		}

		BiNode tail3 = (part3 == null) ? null : part3.node1;

		if (part1 == null) {
			concat(part3.node1, root);
		} else {
			concat(part1.node1, root);
		}

		if (part3 == null) {
			concat(root, part1);
		} else {
			concat(root, part3);
		}

		if (part1 != null && part3 != null) {
			concat(tail3, part1);
		}

		return part1 == null ? root : part1;
	}

	public static BiNode convert(BiNode root) {
		BiNode head = convertToCircular(root);
		head.node1.node2 = null;
		head.node1 = null;
		return head;
	}

	public static void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}
}
