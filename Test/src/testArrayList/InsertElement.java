package testArrayList;

import java.util.ArrayList;
//arraylist 可以直接在开头加数据，后面的数据进行平移
public class InsertElement {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		System.out.println(arrayList);
		arrayList.add(0, 0);
		System.out.println(arrayList);
	}
}
