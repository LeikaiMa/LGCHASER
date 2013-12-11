package insertInterval;

import java.util.ArrayList;
// 做一个数轴，数轴上各个点为arraylist 上面的数字。
// 题目的要求也就是让插入的数字能够与里面的merge
// 通过分析可以得出，有三种情况
// 1. 如果这个range 的最大值比里面的最小值还要小，说明两个没有重合的范围，可以讲这个值先存，然后再把另外一个值再存
// 一旦这个插入值存进去了，就说明没有必要继续比较下去，就可以将其他剩下的range一次放到arraylist 里面
// 这时候也就需要一个flag 标志是否将插入进来的range 已经处理完
// 2. 如果是两个有交集，说明merge 的这个值的start 比要比较的最大值还要小， 这个是后两个就可以merge 起来用作以后比较用。
// 3. 如果要比较的比merge 的还要靠前，而且没有交集，说明这一直接存进去，不需要改变merge 的东西
// 最后要注意检查merge 的这个range 有没有存进去。没有则需要存进去。

public class InsertInterval {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
		boolean isMerged = false;
		Interval mergedInterval = newInterval;
		for (int i = 0; i < intervals.size(); i++) {
			if (isMerged) {
				mergedIntervals.add(intervals.get(i));
				continue;
			}
			Interval oldInterval = intervals.get(i);
			if (mergedInterval.end < oldInterval.start) {
				mergedIntervals.add(mergedInterval);
				mergedIntervals.add(oldInterval);
				isMerged = true;
			} else if (mergedInterval.start <= oldInterval.end) {
				Interval tmp = new Interval(Math.min(mergedInterval.start,
						oldInterval.start), Math.max(mergedInterval.end,
						oldInterval.end));
				mergedInterval = tmp;
			} else {
				mergedIntervals.add(oldInterval);
			}

		}

		if (!isMerged) {
			mergedIntervals.add(mergedInterval);
		}
		return mergedIntervals;
	}

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);
		ArrayList<Interval> a1 = new ArrayList<>();
		a1.add(i1);
		a1.add(i2);
		a1.add(i3);
		a1.add(i4);
		a1.add(i5);

		printArrayList(a1);
		Interval i = new Interval(4, 9);

		a1 = insert(a1, i);

		printArrayList(a1);

	}

	public static void printArrayList(ArrayList<Interval> a) {
		for (Interval i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
