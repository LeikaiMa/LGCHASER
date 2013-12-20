package addition;

import removeDuplicate.LinkedListNode;
// 首先考虑的是是否需要进行，这里的base case 是加数和被加数都是空，而且没有进位。
// 然后针对现在的node 先建出来
// 因为不确定两个list 谁长谁短，所以每次都要确定是否是null 可以将两个node 和carry 如果有值就相加起来。
// 里面的data 就是%10 剩下的。
// 然后确定下一个node 用的是递归，同样的情况是是要判断是否是否是null 如果不是就可以调用next 如果是就需要null
// 这里面可以用三元判断条件
// 得到返回的值之后要将其设为next 无论是不是null
public class Reverse {
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode(carry, null, null);

		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}

		result.data = value % 10;

		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.setNext(more);
		}

		return result;
	}
}
