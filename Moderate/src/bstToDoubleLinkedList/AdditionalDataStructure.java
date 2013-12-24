package bstToDoubleLinkedList;
// 将BST转换为双向链表，其实也就是用postorder 将left child root 和 right child 进行相连，其中就是将right child 连到右边的node left child 连到左边的child
// 这个期间用到了递归，一层一层连好了，向上进行传递。
// 里面关键的一点是连接的时候root 和right 还是比较好连，root 的node2 和right 的 node1 直接相连。
// 但是left 和root 就不太好连了。因为返回的不一定就是只有一个的left，所以这里面加上一个一个结构参量，每次返回的时候都是将已经相连的包起来，包括头和尾。
// 这里面就要进行判断到底root 是不是null left 和right 返回的是不是null 不同的要不同的进行处理。
public class AdditionalDataStructure {
	private class NodePair {
		BiNode head;
		BiNode tail;

		public NodePair(BiNode head, BiNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	public NodePair convert(BiNode root) {
		if (root == null) {
			return null;
		}

		NodePair part1 = convert(root.node1);
		NodePair part2 = convert(root.node2);

		if (part1 != null) {
			concat(part1.tail, root);
		}

		if (part2 != null) {
			concat(root, part2.head);
		}

		return new NodePair(part1 == null ? root : part1.head,
				part2 == null ? root : part2.tail);
	}
	
	public static void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}
}
