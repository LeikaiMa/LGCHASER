package bstToDoubleLinkedList;
// 如果不考虑增加额外的数据结构，可以直接返回已经形成的链的头部。这时候如果要将左边和右边进行相连接就需要有个函数将左边的遍历到右边的尾巴上。
// 然后将右边进行相连。
// 但是这样虽然省掉了额外的数据结构，但是很多node 遍历了很多次。
public class RetrievingTheTail {
	public static BiNode convert(BiNode root) {
		if (root == null) {
			return null;
		}

		BiNode part1 = convert(root.node1);
		BiNode part2 = convert(root.node2);

		if (part1 != null) {
			concat(getTail(part1), root);
		}

		if (part2 != null) {
			concat(root, part2);
		}

		return part1 == null ? root : part1;
	}

	public static BiNode getTail(BiNode node) {
		if (node == null) {
			return null;
		}

		while (node.node2 != null) {
			node = node.node2;
		}

		return node;
	}

	public static void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}
}
