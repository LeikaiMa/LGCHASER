package fourSum;
// I - 6
//可以参考threeSum， 关键点是由4维转换为3维。 hashset 去重。
//由于target 没有确定，所以没有three Sum 更多的优化条件
import java.util.ArrayList;
import java.util.Arrays;
// 去重的话除了放进hashset 里面去重，因为排好了序，所以也是可以通过前面和后面比是不是相同，如果是相同就直接略过，只算第一次。
// 在中间的两边相夹的情况是遇到小的k++这时候比较新的和旧的是不是相同的，如果相同就++，因为这个是先加上k++ 所以是和前面一个进行比较
// 如果是太大的话就l -- 这个也是因为先-- 了，所以是得到的和后面一个进行比较。
// 是每个操作自己执行，所以是每个自己都有
// 而在外层的情况就是因为只有一个变量是写在for 循环里面的，所以是自己和后面一个相比，如果== 就++ 因为外面有一个++，所以肯定是
// 还有最后要return 最后的results 不要忘记写return
public class RemoveDuplication {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 4) {
			return results;
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				for (int k = j + 1, l = num.length - 1; k < l;) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if (sum < target) {
						k++;
						while (k < num.length - 1 && num[k] == num[k - 1]) {
							k++;
						}
					} else if (sum > target) {
						l--;
						while (l > 0 && num[l] == num[l + 1]) {
							l--;
						}
					} else {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[k]);
						result.add(num[l]);
						results.add(result);
						k++;
						l--;
						while (k < num.length - 1 && num[k] == num[k - 1]) {
							k++;
						}

						while (l > 0 && num[l] == num[l + 1]) {
							l--;
						}
					}

				}

				while (j < num.length - 1 && num[j] == num[j + 1]) {
					j++;
				}
			}

			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}

		return results;
	}
}
