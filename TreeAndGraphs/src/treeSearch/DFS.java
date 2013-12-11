package treeSearch;
// DFS 的优点在于全部遍历，但需要注意的是区别与pre-order，每次visit 之后要标记是否visit 过。
// 这样可以避免进入死循环

public class DFS {
	public void search (Node root) {
		if (root == null) {
			return;
		}
		visit(root);
		root.visited = true;
		for (Node n : root.adjacent) {
			if (n.visited == false) {
				search(n);
			}
		}
		
	}

	public static void visit(Node root) {
		
	}

}
