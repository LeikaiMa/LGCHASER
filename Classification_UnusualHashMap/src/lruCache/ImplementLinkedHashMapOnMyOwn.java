package lruCache;
// 建一个linkedHashMap 需要一个hashmap 一个双向链表。然后这个里面有一个capacity 和一个len 
// 生成的时候要输入capacity，然后将len 置为0 
// get 时候，首先看这个这个table 里面有没有，如果有的话，就将这个remove 掉，然后放在head 的位置。最后返回结果。
// 如果找不到就返回-1
// 如果是set 就应该先将这个node 取出来，然后将这个node 的val 给换掉，然后将原来的node 从里面删掉，然后将这个node 放在head 的位置上。
// 如果是没有的，就应该新建一个node 然后如果是len 还是小于 capacity， 那么就将新生成的node 插到head 那边，然后len++，如果是已经到了上限，就要将最后一个给先删掉。
// 然后将新生成的放在开头。但是remove 了之后因为要有个end，所以要进行移动前面一位。如果end 没有变成null， 就应该将post 指向null因为这个是最后一个。
// 如果是remove一个node 就应该将将前面一个和后面一个node 拿出来。然后将两个的post 和prev 的连接起来。不过要注意的是要看现在是不是null，不是的话就要将前面一个指向后面一个，后面一个指向前面一个。
// 然后是将node set 到head 那边。首先就是要将head post 变成head 然后自己的prev 变成null 然后head 如果之前不是null 就要将head 的prev 要变成现在这个node
// 最后将head 变成 现在这个node 
// 然后要看end 是不是null 如果是null 就要将end 变成现在这个node
import java.util.HashMap;

public class ImplementLinkedHashMapOnMyOwn {

	public HashMap<Integer, DoubleLinkedListNode> table = new HashMap<>();
	public DoubleLinkedListNode head;
	public DoubleLinkedListNode end;
	public int capacity;
	public int len;

	public ImplementLinkedHashMapOnMyOwn(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (table.containsKey(key)) {
			removeNode(table.get(key));
			setHead(table.get(key));
			return table.get(key).val;
		} else {
			return -1;
		}
	}

	public void setHead(DoubleLinkedListNode node) {
		node.post = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}

		head = node;
		if (end == null) {
			end = node;
		}
	}

	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.post;

		if (pre != null) {
			pre.post = post;
		} else {
			head = post;
		}

		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}

	public void set(int key, int value) {
		if (table.containsKey(key)) {
			DoubleLinkedListNode cur = table.get(key);
			cur.val = value;
			removeNode(cur);
			setHead(cur);
		} else {
			DoubleLinkedListNode cur = new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(cur);
				table.put(key, cur);
				len++;
			} else {
				table.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.post = null;
				}

				setHead(cur);
				table.put(key, cur);
			}
		}
	}

	public class DoubleLinkedListNode {
		public int val;
		public int key;
		public DoubleLinkedListNode pre;
		public DoubleLinkedListNode post;

		public DoubleLinkedListNode(int key, int value) {
			val = value;
			this.key = key;
		}
	}
}
