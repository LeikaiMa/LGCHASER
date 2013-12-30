package subSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// 这里要求是不能有重复的subset ，如果是全部的出来然后去重，时间复杂度太高，应该在过程当中就避免这些情况的发生。
// 首先是基本问题，是求所有的子集，因为要最后输出的要排好顺序，是升序，所以要记住先将array 进行sort 然后放进arraylist 里面，用collection reverse 这个只是 将里面的list 反序，而不是直接反序，所以前面先要在array 的情况下就排序好
// 因为是back track 而且每次都是直接add 而不是add 0 所以是要之前的排序工作。
// 下面进行的时候要防止重复，我采用的策略是每次记录这个数字重复的次数，如果是最后一个或者这个数字和后面一个数字不同，重置1，如果不是最后一个而且和后面一个相同那么自加1，这里送进去是一个长度为1的数组，是reference 所以可以实时的更新。
// 下面进行的时候，看如果是1，就不需要担心，还是按照原来的方法处理。如果不是1说明要处理，我采用的方法就是看前面是不是有 计数器 -1 个已经填好了，如果是这样的，就加上自己，否则就和其他重了。这里要防止超过前边界。所以要先进行判断，两者成立一个就将这个过滤。
// 其他和普通的subset 是一样的。
public class Recursive {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return results;
		}
		Arrays.sort(num);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i : num) {
			numbers.add(i);
		}
		Collections.reverse(numbers);
		int[] total = new int[1];
		results = subSetsWithDupHelper(numbers, 0, total);
		return results;
	}

	private static ArrayList<ArrayList<Integer>> subSetsWithDupHelper(
			ArrayList<Integer> numbers, int depth, int[] total) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (depth == numbers.size()) {
			ArrayList<Integer> r = new ArrayList<Integer>();
			results.add(r);
			return results;
		} else {
			ArrayList<ArrayList<Integer>> tmp = subSetsWithDupHelper(numbers,
					depth + 1, total);
			if (depth < numbers.size() - 1
					&& numbers.get(depth) == numbers.get(depth + 1)) {
				total[0]++;
			} else {
				total[0] = 1;
			}
			results.addAll(tmp);
			if (total[0] == 1) {
				for (ArrayList<Integer> t : tmp) {
					ArrayList<Integer> r = new ArrayList<Integer>(t);
					r.add(numbers.get(depth));
					results.add(r);
				}
			} else {
				for (ArrayList<Integer> t : tmp) {
					if (t.size() < total[0] - 1
							|| t.get(t.size() - total[0] + 1) != numbers
									.get(depth)) {
						continue;
					}
					ArrayList<Integer> r = new ArrayList<Integer>(t);
					r.add(numbers.get(depth));
					results.add(r);
				}
			}
			return results;
		}

	}

	public static void main(String[] args) {
		int[] num = { 4, 1, 0 };
		// int[] num = { 5,5,5,5,5 };
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		results = subsetsWithDup(num);
		for (ArrayList<Integer> r : results) {
			System.out.println(r);
		}
	}
}
