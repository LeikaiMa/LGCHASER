package threeSum;
// I - 19
//3 个数和为0， 可以先将数组进行sort 之后从小到大排列。
//由于是3个数，本来是n^3 但是三个必须是依次大小排列的不同的数字，所以第三个可以是在第二个基础之上。
//for 循环中间可以用动态的边界条件，而不一定是静态的条件。可以让一个为左边界条件，一个为右边界条件，然后进行比大小，不同情况调整两边的边界条件，直到左右两个边界条件交叉。
//因为是要保证没有重复，所以要随时附带一个hashset 去重。
//因为确定是0 进行比较，可以减少比较次数，如果第一个值大于1则说明比较完了，后面没有更多的选择
//如果第三个小于0， 说明这个二三已经没有更好的情况提供。
import java.util.ArrayList;
import java.util.Arrays;
// 这里去重就不用hashset 进行去重，而是用的是直接和前后进行比较，因为里面是先加，所以是和前面进行比较，
// i 是后加所以是和后面比较，但是i 要注意的是，因为i+1 的原因所以 i 应该是小于 length - 1 这个要注意之前自己写的时候写错了
public class RemoveDuplication {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		if (num == null || num.length < 3) {
			return results;
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				if (num[k] < 0) {
					break;
				}

				int sum = num[i] + num[j] + num[k];
				if (sum < 0) {
					j++;
					while (j < k && num[j] == num[j - 1]) {
						j++;
					}
				} else if (sum > 0) {
					k--;
					while (j < k && num[k] == num[k + 1]) {
						k--;
					}
				} else {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[i]);
					result.add(num[j]);
					result.add(num[k]);
					results.add(result);

					j++;
					k--;

					while (j < k && num[j] == num[j - 1]) {
						j++;
					}

					while (j < k && num[k] == num[k + 1]) {
						k--;
					}
				}

			}

			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}

		return results;
	}
}
