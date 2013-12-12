package route;

import java.util.LinkedList;

import treeSearch.Node;
// 要查两个node 在directed graph 里面是否有route
// 可以用DFS BFS两种方法，各有优劣，但是BFS可以顺便求出最短的路径。
// 在图里面重要的是要标记这个node 是否走过。有三种状态，一种是unvisited，一种是visiting 还有一种是visited
// 这时候要用linkedlist 作为一个queue 来进行，如果看到一个node 放入queue作为visiting 然后将adjacent的值都存到queue里面，这个时候就可以标记为visited
// 要注意的一点是最好判断是否为null
// 还有就是要在期中判断是否这个点已经是end，如果是就可以返回true
// 在整个queue 都走完，还没有发现就应该返回false
public class RouteBetweenTwoNodes {
	
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v == end) {
						return true;
					} else {
						v.state = State.Visiting;
						q.add(v);
					}
				}
			}
			u.state = State.Visited;
		}
		return false;
	}

}
