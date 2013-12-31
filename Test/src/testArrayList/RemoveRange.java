package testArrayList;

import java.util.ArrayList;
// 消除一个range的数，用sublist 然后clear掉
public class RemoveRange {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		System.out.println(arrayList);
		arrayList.subList(0, 2).clear();
		System.out.println(arrayList);
	}
}
