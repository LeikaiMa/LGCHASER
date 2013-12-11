package deleteMiddle;

import removeDuplicate.LinkedListNode;
// 删除里面一个中间值，方法不是在删除本身，而是删除后面一个node， 而把那个node的值存在自己本身。
// 但是这个无法解决删除最后一个，这个时候可以用特殊的方法特别处理。而且也可以和面试官提到这个问题。
public class DeleteMiddle {
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}
