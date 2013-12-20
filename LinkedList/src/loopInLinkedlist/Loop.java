package loopInLinkedlist;
// 看是否有loop 要看跑的快的嫩不能和慢的最后相遇。如果没有loop 肯定快的先到终点。
// 所以有两个pointer 分别进行跑。
// 当慢的如果刚进去loop 假设start 的地方要比入口有k 步，此时，快的领先慢的也有k 步，等于 快的落后慢的总共有 N-K 步，
// 要将剩下的n-k 步追上，应该是在距离入口的地方是k 步的时候追上，此时可以得出假设两个一个在起点，一个在现在这个点，一起以相同的速度进行跑，相遇的地点就是入口。
// 要注意的地方就是快的要跑两步，所以先要判断自己是不是null 判断成功之后才能判断next 是不是null 避免进入空指针
import removeDuplicate.LinkedListNode;

public class Loop {
	LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}

		slow = head;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}
}
