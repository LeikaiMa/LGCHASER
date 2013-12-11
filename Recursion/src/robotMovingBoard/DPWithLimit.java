package robotMovingBoard;

import java.util.ArrayList;
import java.util.Hashtable;

public class DPWithLimit {
	private static boolean isFree(int x, int y) {
		return true;
	}
//	DP 问题比较好的一点在于可以将时间转换为空间
//	如果在函数里面要考虑到DP的问题，就需要随函数将其中的要缓存的东西放进去。
//	如果是两个参考的对象，一个还不能规划为array 的index 的时候，就可以用hashtable 这种存储两个值的数据结构。
//	而这种区别与普通的递归在于最开始如果能够直接得到值就可以直接返回。
//	并且每当最后得到一个结果的时候，就需要将其存进去一个cache里面以备其他使用。

	public boolean getPath(int x, int y, ArrayList<Point> path,
			Hashtable<Point, Boolean> cache) {
		Point p = new Point(x, y);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		if (x == 0 && y == 0) {
			return true;
		}

		boolean success = false;
		if (x >= 1 && isFree(x - 1, y)) {
			success = getPath(x - 1, y, path, cache);
		}

		if (!success && isFree(x, y - 1)) {
			success = getPath(x, y - 1, path, cache);
		}

		if (success) {
			path.add(p);
		}

		cache.put(p, success);
		return success;
	}
}
