package removeDuplicate;

import java.util.Hashtable;
// 去重一个很好的方法，就是将已经有的值存进一个hashtable 或者hashset 中，因为他们本身自带去重功能。
// 然后每次都进去比较是否存在，如果存在，就直接将这个node 过滤，如果有的话就放进新的list，并且将其放进hashtable 或者hashset
// 这里面也会用到一个方法就是，将一个跑的慢的在后面做删除重复的功能，这个功能本质上将next 的链接略过这个元素，至后面一个元素，还有个正常跑的元素是做遍历来用

public class WithBuffer {
	public static void deleteDup(LinkedListNode n) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
}
