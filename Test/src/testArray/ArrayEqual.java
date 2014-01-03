package testArray;

import java.util.Arrays;
// 二维数组可以用Arrays.equal 来进行比较
public class ArrayEqual {
	public static void main(String[] args) {
		int[][] array = {{1,2}, {1,2}};
		System.out.println(Arrays.equals(array[0], array[1]));
	}
}
