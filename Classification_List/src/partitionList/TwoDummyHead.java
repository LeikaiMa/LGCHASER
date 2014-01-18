package partitionList;
//VII
//这里要按照某个数值将一个list 进行分开，用两个dummy 作为两条链子的头，然后用prev 往后进行移动连接新的node
//原来的head 在里面进行遍历，如果小就连接到1 如果大于等于就连接到2
//到最后，记住要给这两个链子最后设置断，设为null
//不然可能会和其他的node 还保持着联系，会形成circle
//然后将两条链子连接到一起，要注意的是如果小的链子没有就直接返回大于等于的链子，如果存在就将小的链子的最后面连接上大于等于的链子。

//这里主要是要将后面一个链子的最后一个设置成null
public class TwoDummyHead {
	public ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(0);
		ListNode less = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode larger = dummy2;

		while (head != null) {
			if (head.val < x) {
				less.next = head;
				head = head.next;
				less = less.next;
			} else {
				larger.next = head;
				head = head.next;
				larger = larger.next;
			}
		}

		larger.next = null;
		less.next = dummy2.next;

		return dummy1.next;
	}
}
