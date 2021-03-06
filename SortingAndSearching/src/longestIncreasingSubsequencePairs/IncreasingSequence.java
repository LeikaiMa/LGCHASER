package longestIncreasingSubsequencePairs;

import java.util.ArrayList;
import java.util.Collections;
// 这个问题抽象出来是pair 最长的完全递增的子排序
// 首先按照一种排序拍出来，这里如果是arraylist 要进行排序就可以用Collections 来进行排序，但是要保障里面的元素是implement 了comparable。
// 意思也就是说里面的元素自己能够排序。
// 根据里面的元素从小到大，每个都有一个slot， 一次进行排序，第一个排好，第二个在第一个的基础之上进行排序，如果能够排好，就把这个排好的序放进自己的slot 当中。
// 如果没有就是“”再加上自己。
// 加入前面有很多个已经排好的slot，可以用一个中间变量进行过渡，比较完了之后放进去。
// 在arraylist 里面可以用 addAll 来把所有的元素都存进去。
// 因为在不同的位上用的是相同的方法，所以可以用的是递归。
// 一些自定义结构里面可以添加一些方法，方便比较。
public class IncreasingSequence {
	public ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items) {
		Collections.sort(items);
		return longestIncreasingSubsequence(items);
	}

	public ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array) {
		@SuppressWarnings("unchecked")
		ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
		longestIncreasingSubsequence(array, solutions, 0);

		ArrayList<HtWt> best_sequence = null;
		for (int i = 0; i < array.size(); i++) {
			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
		}

		return best_sequence;
	}

	public static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1,
			ArrayList<HtWt> seq2) {
		if (seq1 == null) {
			return seq2;
		}
		if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	public void longestIncreasingSubsequence(ArrayList<HtWt> array,
			ArrayList<HtWt>[] solutions, int current_index) {
		if (current_index >= array.size() || current_index < 0) {
			return;
		}
		HtWt current_element = array.get(current_index);

		ArrayList<HtWt> best_sequence = null;
		for (int i = 0; i < current_index; i++) {
			if (array.get(i).isBefore(current_element)) {
				best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
			}
		}

		ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
		if (best_sequence != null) {
			new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);

		solutions[current_index] = new_solution;
		longestIncreasingSubsequence(array, solutions, current_index + 1);

	}
}
