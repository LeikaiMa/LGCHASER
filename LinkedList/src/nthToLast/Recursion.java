package nthToLast;
// 因为看到是有kth 这类的东西，就应该考虑可以用递归的方法。
// base case 是到了最后一个。返回0
// 后面就是每次+1, 说明这个是倒数第几个，然后根据这个进行判断和返回。
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
		return i;
	}
}
