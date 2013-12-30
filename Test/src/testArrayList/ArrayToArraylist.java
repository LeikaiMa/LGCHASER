package testArrayList;

import java.util.Arrays;
import java.util.List;
// array直接变成arraylist 没有更好的方法，还是自己遍历添加。
public class ArrayToArraylist {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		List<int[]> list = Arrays.asList(a);
		System.out.println(list);
	}
}
