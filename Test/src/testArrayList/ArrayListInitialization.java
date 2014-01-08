package testArrayList;

import java.util.ArrayList;
// 说明arraylist 开始的时候是不能够直接initialize 出来，后面只是标明capacity.

public class ArrayListInitialization {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(1);
		System.out.println(arrayList.size());
	}
}
