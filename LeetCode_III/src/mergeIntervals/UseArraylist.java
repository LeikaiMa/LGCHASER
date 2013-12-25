package mergeIntervals;
// 将一个range的arraylist 进行merge 主要先进行排序。然后根据下一个是否和前一个有交叉判断是否将现在一个merge 成新的，还是把那个放进list 里面。
// 因为是要对一个新的数据结构进行排序，所以用treenode 增加一个排序的参考量。
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UseArraylist {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		if (intervals.size() == 1) {
			result.add(intervals.get(0));
			return result;
		}

		TreeMap<Integer, Interval> map = new TreeMap<Integer, Interval>();
		for (Interval interval : intervals) {
			if (map.containsKey(interval.start)) {
				Interval tmp = map.get(interval.start);
				map.put(interval.start,
						new Interval(interval.start, Math.max(interval.end,
								tmp.end)));
			} else {
				map.put(interval.start, interval);
			}
		}
		
		Interval cur = map.firstEntry().getValue();
		
		for (Map.Entry<Integer, Interval> entry: map.entrySet()) {
			Interval tmp = entry.getValue();
			if (tmp.end <= cur.end) {
				continue;
			} else if (tmp.start <= cur.end) {
				cur = new Interval(cur.start, tmp.end);
			} else {
				result.add(cur);
				cur = tmp;
			}
		}
		
		result.add(cur);
		return result;

	}
}
