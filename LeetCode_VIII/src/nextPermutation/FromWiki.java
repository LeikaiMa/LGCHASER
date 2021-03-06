package nextPermutation;
// 这个其实和我自己想的差不多，但是实现起来更加顺一些，但思路没有那么清晰
// 首先找最后一组前面比后面小的，要交换的就是前面的。
// 如果找不到说明是最后一种排列
// 然后再找最后一个比现在这个要大的，就是下一个permutation的这个位置的头，交换过来
// 然后后面变成最小的，因为之前是反序的，所以只需要倒序一下就可以了。但是java 暂时没有找到直接array 倒序的，就用sort 代替了。
import java.util.Arrays;

public class FromWiki {
	public static void nextPermutation(int[] num) {
		int k = -1;
		int l = 0;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < num[i + 1]) {
				k = i;
			}
		}

		if (k == -1) {
			Arrays.sort(num);
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (num[i] > num[k]) {
				l = i;
			}
		}
		int tmp = num[l];
		num[l] = num[k];
		num[k] = tmp;

		Arrays.sort(num, k + 1, num.length);

	}
	
	public static void main(String[] args) {
		int[] num = { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(num);
		System.out.println(Arrays.toString(num));
		int[] num1 = { 2, 3, 1 };
		nextPermutation(num1);
		System.out.println(Arrays.toString(num1));
		int[] num2 = { 1, 3, 2 };
		nextPermutation(num2);
		System.out.println(Arrays.toString(num2));
	}
}
