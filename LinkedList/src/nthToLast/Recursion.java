package nthToLast;

import removeDuplicate.LinkedListNode;

public class Recursion {
	public static int nthToLast(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		return 1;
	}
}
