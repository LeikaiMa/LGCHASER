package mergeIntervals;
//III
//将一个range的arraylist 进行merge 主要先进行排序。然后根据下一个是否和前一个有交叉判断是否将现在一个merge 成新的，还是把那个放进list 里面。
//因为是要对一个新的数据结构进行排序，所以用treenode 增加一个排序的参考量。
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
// 原先是用的是treenode 作为sort 的工具，现在可以用的是collections 作为一个sort 的工具。
// 这里就要新建一个Comparator 放在里面，而new 新的Comparator 有固定的格式，要制定类型，然后里面还要重写 compare的 函数，
// compare的函数也就是比较你要比较的内容返回1 0 -1，但是也要注意类型，参数是两个这个类型的数
// 最后进行比较，开始拿出一个看后面和现在这个有没有交集，因为已经排好序就只有两种情况，前面和后面一个完全没有交集，直接把前面那个塞进去，
// 后面那个变成比较的这一个，前面后面有交集，就新建一个，start 肯定是原来的那个start end 取两个大值、
// 最后还要把最后的那一个放进去。
public class SortByComparator {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> newIntervals = new ArrayList<Interval>();
		if (intervals.isEmpty()) {
			return newIntervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start > b.start ? 1 : (a.start == b.start ? 0 : -1);
			}
		});

		Interval oldInterval = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			Interval tmp = intervals.get(i);

			if (tmp.start > oldInterval.end) {
				newIntervals.add(oldInterval);
				oldInterval = tmp;
			} else {
				oldInterval = new Interval(oldInterval.start, Math.max(
						oldInterval.end, tmp.end));
			}
		}

		newIntervals.add(oldInterval);

		return newIntervals;
	}
}
