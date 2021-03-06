package copyListWithRandomPointer;
// 要进行deep copy 必须要重新建一个相同的node 复制里面的val 以及指针等等参数。
// 这里面和普通的不同的是，除了next，还有一个random 的指针，这个就没有办法一次性遍历成功。
// 需要在开始的时候把所有的node 全部复制进去，然后标上index， 再在自己先建的node 里面用上同样的index
// 这样原始的list 连接什么样的index 只要进行依葫芦画瓢就可以了。
// 这里采用的策略是一个使用hashmap 记录这个node 所在的标号
// 另一个是用的arraylist，对应的标号有相对应的node 这样就完成了查找的功能。
// 可以直接两个randomlistnode 直接用hashmap 对应 参考 clonegraph
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapArrayList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			RandomListNode nh = new RandomListNode(head.label);
			if (head.random != null) {
				nh.random = nh;
			}
			return nh;
		}

		HashMap<RandomListNode, Integer> map = new HashMap<RandomListNode, Integer>();
		ArrayList<RandomListNode> arrayList = new ArrayList<RandomListNode>();

		RandomListNode nh = new RandomListNode(head.label);
		map.put(head, 0);
		arrayList.add(nh);
		int index = 1;
		RandomListNode node = head;
		RandomListNode newNode = nh;
		while (node.next != null) {
			node = node.next;
			map.put(node, index);
			RandomListNode tmp = new RandomListNode(node.label);
			arrayList.add(tmp);
			newNode.next = tmp;
			index++;
			newNode = tmp;
		}
		node = head;
		newNode = nh;
		while (node != null) {
			if (node.random != null) {
				newNode.random = arrayList.get(map.get(node.random));
			}
			node = node.next;
			newNode = newNode.next;
		}
		return nh;
	}
}
