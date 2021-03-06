package testArrayList;

import java.util.ArrayList;
import java.util.Arrays;
// 要将arraylist 变成array 要用collection 的那种，而不是用primitive 的那种类型。
// 不能将Integer[] 直接变成int【】
public class ArrayListToArray {
	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<>();
		arraylist.add(1);
		arraylist.add(2);
		
		Integer[] array = (Integer[]) arraylist.toArray();
		Integer[] array2 = arraylist.toArray(new Integer[0]);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
	}

}
