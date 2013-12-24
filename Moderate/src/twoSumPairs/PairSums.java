package twoSumPairs;

import java.util.Arrays;
// 排序， 两头向中间收缩，如果相等就输出，如果太小，移动左边，如果太大移动右边。相等的时候左右两边都移动
public class PairSums {
	void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				first++;
				last--;
			} else {
				if (s < sum) {
					first++;
				} else {
					last--;
				}
			}
 		}
	}
}
