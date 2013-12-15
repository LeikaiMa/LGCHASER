package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
// 3 个数和为0， 可以先将数组进行sort 之后从小到大排列。
// 由于是3个数，本来是n^3 但是三个必须是依次大小排列的不同的数字，所以第三个可以是在第二个基础之上。
// for 循环中间可以用动态的边界条件，而不一定是静态的条件。可以让一个为左边界条件，一个为右边界条件，然后进行比大小，不同情况调整两边的边界条件，直到左右两个边界条件交叉。
// 因为是要保证没有重复，所以要随时附带一个hashset 去重。
// 因为确定是0 进行比较，可以减少比较次数，如果第一个值大于1则说明比较完了，后面没有更多的选择
// 如果第三个小于0， 说明这个二三已经没有更好的情况提供。
public class ThreeSum {
	public static  ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] > 0) {
				return result;
			}
			for (int j = i + 1, k = num.length - 1; j < k; ) {
				if (num[k] < 0) {
					break;
				}
				int sum = num[i] + num[j] + num[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					ArrayList<Integer> arrayList = new ArrayList<Integer>();
					arrayList.add(num[i]);
					arrayList.add(num[j]);
					arrayList.add(num[k]);
					if (!hashSet.contains(arrayList)) {
						hashSet.add(arrayList);
						result.add(arrayList);
					}
					j++;
					k = num.length - 1;
				}

			}
		}
		return result;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> resultArrayList= new ArrayList<>();
		int[] S ={-2,0,1,1,2};
		resultArrayList = threeSum(S);
		for (ArrayList<Integer> r: resultArrayList) {
			System.out.println(r);
		}
	}
}
