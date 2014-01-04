package nextPermutation;
// 找下一个permutation 的方法，因为在这个permutation 最大的就是后面已经是倒序好了。
// 我要找的就是第一个前一个比后面小的，那么这个头就要换了。但是换什么就是要找比他大的最小的，在后面倒序的里面从后面向前找，这个顺序无所谓，
// 然后进行交换，再把新的后面的sort 成由小到大的情况，这个就是这种条件下第一个。
// 如果没有找到这种情况就说明这个已经是最大的那个，要变成第一个，就直接sort 一下就好了。
import java.util.Arrays;

public class InPlace {
	public static void nextPermutation(int[] num) {
		if (num == null || num.length == 0 || num.length == 1) {
			return;
		}

		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				for (int j = num.length - 1; j>=i; j --) {
					if (num[i-1] < num[j]) {
						int tmp = num[i-1];
						num[i-1] = num[j];
						num[j] = tmp;
						Arrays.sort(num, i, num.length);
						return;
					}
				}
				
			}
		}

		Arrays.sort(num);
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
