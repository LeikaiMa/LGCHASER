package testArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// 说明int array 要换序要先变成Integer 然后用Collection 的reverse 来换序。
public class ReverseSortInt {
	public static void main(String[] args) {
		int[] S = new int[3];
		S[0] = 1;
		S[1] = 2;
		S[2] = 3;
		System.out.println(Arrays.toString(S));
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i : S) {
			arrayList.add(i);
		}
		Collections.reverse(arrayList);
		System.out.println(arrayList);
	}
}
