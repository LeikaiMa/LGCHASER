package copyListWithRandomPointer;
// III
//要进行deep copy 必须要重新建一个相同的node 复制里面的val 以及指针等等参数。
//这里面和普通的不同的是，除了next，还有一个random 的指针，这个就没有办法一次性遍历成功。
//需要在开始的时候把所有的node 全部复制进去，然后标上index， 再在自己先建的node 里面用上同样的index
//这样原始的list 连接什么样的index 只要进行依葫芦画瓢就可以了。
//这里采用的策略是一个使用hashmap 记录这个node 所在的标号
//另一个是用的arraylist，对应的标号有相对应的node 这样就完成了查找的功能。
//可以直接两个randomlistnode 直接用hashmap 对应 参考 clonegraph
import java.util.HashMap;
// 这里直接用hashmap 将两个对应起来，hashmap 有一点好处是如果没有就直接返回null

public class UseHashMap {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        RandomListNode p = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            map.put(p, copy);
            p = p.next;
            prev.next = copy;
            prev = prev.next;
        }
        
        p = head;
        prev = dummy.next;
        
        while (p != null) {
           // if (p.random != null) {
                prev.random = map.get(p.random);
            //}
            p = p.next;
            prev = prev.next;
        }
        
        return dummy.next;
    }
}
