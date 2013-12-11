package nthToLast;

import removeDuplicate.LinkedListNode;
// 因为递归的方法占空间，O（N）， 而iteration 的方法只占O（1），但是思考要更加复杂。
// 要考虑到里面的容错，是否存在倒数k 个或者是是k 传进来的值是否就存在。
// 因为倒数第一个就是最后一个，里面要用k 个，要先考虑k - 1。两个指针一个先走k-1个，然后两个指针同时向前一起走。
// 最后快的走到尾说明慢的是倒数第k 个
public class Iterative {
	LinkedListNode nthToLast(LinkedListNode head, int k) {
		if (k <= 0) {
			return null;
		}
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		
		if (p2 == null) {
			return null;
		}
		
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
}
