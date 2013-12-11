package nthToLast;

import removeDuplicate.LinkedListNode;
// 之前递归有一个问题，在于不像python 可以传一个tuple，java 只能传一个。
// 如果只传是倒数第几个这个index， 就没法传里面的具体的node
// 这时候可以利用传一个wrapper class ，将里面的值进行赋值，这样就可以传一个reference，他改动，在任何层的method都可以实时看到。返回值就可以变成node。

public class WrapperClass {
	public class IntWrapper {
		public int value = 0;
	}
	
	LinkedListNode nthToLastR2(LinkedListNode head, int k, IntWrapper i) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = nthToLastR2(head.next, k, i);
		i.value = i.value + 1;
		
		if (i.value == k) {
			return head;
		}
		
		return node;
	}
}
