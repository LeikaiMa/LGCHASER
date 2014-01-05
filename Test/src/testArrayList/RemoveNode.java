package testArrayList;

import java.util.ArrayList;
// arraylist 如果是remove element如果element 是reference 就直接比较reference 而不是比较里面的值。
public class RemoveNode {
	public static void main(String[] args) {
		ArrayList<ListNode> arrayList = new ArrayList<>();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		arrayList.add(l1);
		arrayList.add(l2);
		arrayList.add(l3);
		System.out.println(arrayList);
		
		arrayList.remove(l3);
		System.out.println(arrayList);
	}
}
