package rotateList;
//因为是要旋转，所以先让他直接收尾相连，这样旋转就不需要考虑是不是会到尾巴，
//在第一遍走的时候可以顺便把所有的个数算出来，这样可以为后面来使用。
//右旋转多少个实际上是从开头往后数到哪个截开作为尾巴，
//因为之前便利的时候已经到了尾巴，所以可以顺便用一下
//可以进行优化的地方在于如果只有一个可以直接返回
//如果转了很多圈，可以用% 把他放到一圈当中。
//还有在截出尾巴的前，跳到下一个上去作为头返回。这样比较方便

//这里要注意的是开始统计的时候是1，记录到next为null，这样就能保证是到最后一个node 而不是到null
//然后再将这个和头相连
public class ConcatHeadTail {
	public ListNode rotateRight(ListNode head, int n) {
		if (n == 0 || head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;

		int total = 1;

		while (cur.next != null) {
			total++;
			cur = cur.next;
		}

		n = n % total;

		cur.next = head;

		cur = head;
		for (int i = 1; i < total - n; i++) {
			cur = cur.next;
		}
		head = cur.next;
		cur.next = null;
		return head;
	}
}
