package testArrayList;

import java.util.ArrayList;
import java.util.HashMap;
// 存在hashmap 里面的值取出来和放在arraylist 是一样的，这样可以用index 来进行互相找。
public class StoreInHashMap {
	public static void main(String[] args) {
		HashMap<ListNode, Integer> map = new HashMap<>();
		ArrayList<ListNode> arrayList =  new ArrayList<>();
		ListNode l1 = new ListNode();
		map.put(l1, 0);
		arrayList.add(l1);
		ListNode l2 = new ListNode();
		map.put(l2, 1);
		arrayList.add(l2);
		System.out.println(arrayList.get(map.get(l1)) == l1);
	}
}
