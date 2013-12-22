package twoSum;

import java.util.Arrays;
import java.util.HashMap;
// 求两个数的和等于指定的值。可以边遍历边看是否有对应的值已经存了。
// 这个时候用hashmap 来进行存储，可以使取值的复杂度降低。如果没有存过，可以将自己的补数和index 存进hashmap 中
// 这样能够只进行一遍遍历就能得到答案。
public class UseHashMap {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> inputs = new HashMap<Integer, Integer>();
		int[] results = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (inputs.containsKey(numbers[i])) {
				results[0] = inputs.get(numbers[i]) + 1;
				results[1] = i + 1;
				break;
			} else {
				inputs.put(target - numbers[i], i);
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		int[] numbers = { 0, 4, 3, 0 };
		int target = 0;
		System.out.println(Arrays.toString(new TwoSum().twoSum(numbers, target)));
	}
}
