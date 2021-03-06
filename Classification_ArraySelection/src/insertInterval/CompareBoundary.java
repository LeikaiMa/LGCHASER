package insertInterval;
// I - 8
//做一个数轴，数轴上各个点为arraylist 上面的数字。
//题目的要求也就是让插入的数字能够与里面的merge
//通过分析可以得出，有三种情况
//1. 如果这个range 的最大值比里面的最小值还要小，说明两个没有重合的范围，可以讲这个值先存，然后再把另外一个值再存
//一旦这个插入值存进去了，就说明没有必要继续比较下去，就可以将其他剩下的range一次放到arraylist 里面
//这时候也就需要一个flag 标志是否将插入进来的range 已经处理完
//2. 如果是两个有交集，说明merge 的这个值的start 比要比较的最大值还要小， 这个是后两个就可以merge 起来用作以后比较用。
//3. 如果要比较的比merge 的还要靠前，而且没有交集，说明这一直接存进去，不需要改变merge 的东西
//最后要注意检查merge 的这个range 有没有存进去。没有则需要存进去。
import java.util.ArrayList;
// 这里省掉了merge 的flag 因为是按照顺序，开始肯定是没有交集，之后是有交集的，再之后是没有交集的后面有交集的时候直接赋值到newInterval
// 这里要注意的是start end 不是自己想的a b
public class CompareBoundary {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> results = new ArrayList<Interval>();

		int i = 0;
		int len = intervals.size();

		while (i < len && intervals.get(i).end < newInterval.start) {
			results.add(intervals.get(i++));
		}

		while (i < len && intervals.get(i).start <= newInterval.end) {
			Interval oldInterval = intervals.get(i++);
			newInterval.start = Math.min(newInterval.start, oldInterval.start);
			newInterval.end = Math.max(newInterval.end, oldInterval.end);
		}

		results.add(newInterval);

		while (i < len) {
			results.add(intervals.get(i++));
		}

		return results;
	}
}
