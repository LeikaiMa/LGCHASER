package treeSearch;

import java.util.LinkedList;
import java.util.Queue;
// BFS 是用先看所有的ancestor之后再看child，这个时候不用递归，用queue，先看到之后存进去
// 然后用while 循环 判断queue 里面有没有装进去的值。
public class BFS {
	public void search(Node root) {
		Queue<Node> queue = new LinkedList<>();
		root.visited = true;
		visit(root);
		
		queue.add(root);
		while (!queue.isEmpty()) {
			Node r = queue.poll();
			for(Node n : r.adjacent) {
				if (n.visited == false) {
					visit(n);
					n.visited = true;
					queue.add(n);
				}
			}
		}
	}

	private void visit(Node root) {
		// TODO Auto-generated method stub
		
	}
}
