package subSet;

// 求全部的子集，通过观察每增加一个元素，等于在原来的自己上添加一个增加的元素
// base case 是当自己的size 和 index 相同的时候，添加一个空集。 
// 可以看做是空集的子集是空集，也可以看做是index 正好的等于size 的时候，因为size get 不出值，最大是size - 1
// 可以归结为要返回什么值先定义出来，然后if else 判断是否为base case
// 如果不是的话就要进行递归，得到返回的值，正好将此时的index取出的值塞进去。
// 这里面用到了arraylist 嵌套 arraylist。 同时用到了arraylist addall两种不同的方法。
// 而且定义moresubset 单独处理是个好习惯。

import java.util.ArrayList;

public class Recursion {
	public ArrayList<ArrayList<Integer>> getSubSet(ArrayList<Integer> set,
			int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			allsubsets = getSubSet(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
