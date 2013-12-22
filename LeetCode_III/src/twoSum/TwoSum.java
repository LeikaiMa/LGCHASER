package twoSum;

import java.util.Arrays;
// 这个方法是用了排好序的从两边向内进行夹击。如果值太小，就左+1 如果太大就右-1，因为需要原始的index 所以自己建了一个wrapper class
// 这个class implement comparable 使得他可以进行比较。
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		withIndex[] inputs = new withIndex[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			inputs[i] = new withIndex(numbers[i], i+1);
		}
		Arrays.sort(inputs);
		int[] result = new int[2];
		for (int i = 0, j = numbers.length - 1; i < j;) {
			int sum = inputs[i].data + inputs[j].data;
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				result[0] = inputs[i].index;
				result[1] = inputs[j].index;
				break;
			}
		}
		Arrays.sort(result);
		return result;
	}

	public class withIndex implements Comparable<withIndex> {
		Integer data;
		Integer index;

		public withIndex(int d, int i) {
			data = d;
			index = i;
		}


		@Override
		public int compareTo(withIndex o) {
			return this.data.compareTo(o.data);
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 0, 4, 3, 0 };
		int target = 0;
		System.out.println(Arrays.toString(new TwoSum().twoSum(numbers, target)));
	}
}
