package removeDuplicate;
// 如果不用buffer 就需要以时间作为牺牲。 需要两个指针进行，一个在前遍历一个在后作为标准。
// 这时候就相当于两个循环，前面一个是作为去重，如果和现在是想他那个的，他就用next 这个指向下下一个，而且比较的也是next.data
// 同样的情况也是用next 来进行判断，保留自己的prev的位置。
public class WithoutBuffer {
	public static void deleteDups(LinkedListNode head) {
		if (head == null) {
			return;
		}

		LinkedListNode current = head;

		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

}
