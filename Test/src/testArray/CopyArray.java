package testArray;

import java.util.Arrays;
// arrays 如果是primitive 进行copy 是deep copy 而且是开闭后开
public class CopyArray {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = Arrays.copyOfRange(a, 1, 3);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		a[1] = 6;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
