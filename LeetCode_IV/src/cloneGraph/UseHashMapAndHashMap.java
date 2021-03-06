package cloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
// 复制同一个graph 主要是完全同步，用一个hashmap 将对应的两个node 进行对应。
// 然后BFS来进行，主要每拿出一个时候要注意将他的neighbor 都遍历出来。
// 边遍历边进行检查，如果有这个值就直接add 进要复制的node 的neighbor里面。如果没有就新建一个然后建立对应关系，加入node的neighbor，然后再存进两个的queue 里面
public class UseHashMapAndHashMap {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		UndirectedGraphNode root = new UndirectedGraphNode(node.label);
		map.put(node, root);

		Queue<UndirectedGraphNode> sq = new LinkedList<UndirectedGraphNode>();
		sq.add(node);
		Queue<UndirectedGraphNode> dq = new LinkedList<UndirectedGraphNode>();
		dq.add(root);

		while (!sq.isEmpty()) {
			UndirectedGraphNode sn = sq.poll();
			UndirectedGraphNode dn = dq.poll();
			for (UndirectedGraphNode n : sn.neighbors) {
				if (map.containsKey(n)) {
					dn.neighbors.add(map.get(n));
				} else {
					UndirectedGraphNode tmp = new UndirectedGraphNode(n.label);
					map.put(n, tmp);
					dn.neighbors.add(tmp);
					sq.add(n);
					dq.add(tmp);
				}
			}
		}
		
		return root;

	}
}
