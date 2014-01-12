package cloneGraph;
//IV
//复制同一个graph 主要是完全同步，用一个hashmap 将对应的两个node 进行对应。
//然后BFS来进行，主要每拿出一个时候要注意将他的neighbor 都遍历出来。
//边遍历边进行检查，如果有这个值就直接add 进要复制的node 的neighbor里面。如果没有就新建一个然后建立对应关系，加入node的neighbor，然后再存进两个的queue 里面
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
//这个只要一个对应就可以了，新建一个将这个存进map 的对照表里面，如果是刚存就还有把neighbor 补上去。就需要放进queue 里面的进去补全neighbor
//其他就是和BFS 一样，每poll 出来一个就应该将里面的neighbor补全，看到没有新建，将其塞进queue 里面，看见有的就将map 里面对应的存在对应的node 里面的
public class HashMapGetRelationship {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        queue.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode n : cur.neighbors) {
                if (map.containsKey(n)) {
                    map.get(cur).neighbors.add(map.get(n));
                } else {
                    UndirectedGraphNode ncopy = new UndirectedGraphNode(n.label);
                    map.put(n, ncopy);
                    queue.add(n);
                    map.get(cur).neighbors.add(ncopy);
                }
            }
        }
        
        return copy;
    }
}
