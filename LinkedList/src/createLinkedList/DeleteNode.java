package createLinkedList;
// delete node 需要将prev.next 指向 n.next 
// 但要注意首先是不是null 还要注意更新head 和 tail 
// 比如删除 head 等等
// 如果需要跨格，不一定要两个指针，可以让一个指针用next 来一直比较，但是要得到所要的之后，才能改变自己。
public class DeleteNode {
	public Node deleteNode(Node head, int d) {
		Node n = head;

		if (n.data == d) {
			return head.next;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
}
