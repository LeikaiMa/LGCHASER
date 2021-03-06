package maxPointsOnALine;

import java.util.HashMap;
import java.util.Map;
// 求在同一条线上最多的点数，就是看斜率是相同，所有的个数，但是有些情况就是斜率相同，但是没有同一个相同的点，这两条线只能是平行线。
// 所以可以先一个点将所有的其他点的斜率先算出来，如果相同，因为公有现在这个点，所以肯定是在同一条直线上。用一个hashmap 存储斜率。如果斜率存在就拿出来加1
// 如果不存在的话，就要将这条新的直线放进去，初始的时候有两个点，所以初始值为2.
// 不过要注意的是可能会有重复的点，就是在相同的位置。如果有相同的点，就在所有的直线上，这个时候每条直线都要加上这些重复的点。
// 计算斜率的时候，要考虑的几点，一个是重复的点，那么用double 的最小值来表示斜率。 如果是垂直的线，那么斜率应该是无穷大，用MAX_VALUE来进行表示，如果是水平的，那么同样要注意，因为double 的O 是分正负的
// 其他的情况就是求正常的斜率。
// 在比较个数的时候，初始条件是全部都是重复的点，应该是dup + 1 这个很容易出错。
// 然后是将map 里面所有的值取出来加上重复的点的 个数，（这里dup 不包括点的本身）
// 得到的最大的，和最外面的最大值比较储存。
// 然后遍历的时候，第二个点是只是往后面进行比较，不和前面，防止重复。
// 感觉应该有更好的，复杂还是有些高
public class UseHashMap {
	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		if (points.length == 1 || points.length == 2) {
			return points.length;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < points.length - 1; i++) {
			HashMap<Double, Integer> slides = new HashMap<Double, Integer>();
			int dup = 0;
			for (int j = i + 1; j < points.length; j++) {
				double slide = getSlide(points[i], points[j]);
				if (slide == Double.MIN_VALUE) {
					dup++;
					continue;
				}
				if (slides.containsKey(slide)) {
					slides.put(slide, slides.get(slide) + 1);
				} else {
					slides.put(slide, 2);
				}
			}

			int curMax = dup + 1;
			if (slides.size() > 0) {
				for (Map.Entry<Double, Integer> entry : slides.entrySet()) {
					curMax = Math.max(curMax, entry.getValue() + dup);
				}
			}
			max = Math.max(curMax, max);
		}
		return max;
	}

	private static double getSlide(Point p1, Point p2) {
		if (p1.x == p2.x && p1.y == p2.y) {
			return Double.MIN_VALUE;
		} else if (p1.x == p2.x) {
			return Double.MAX_VALUE;
		} else if (p1.y == p2.y) {
			return 0;
		} else {
			return (p1.y - p2.y) * 1.0 / (p1.x - p2.x);
		}

	}

	public static void main(String[] args) {
//		Point p1 = new Point(2, 3);
//		Point p2 = new Point(3, 3);
//		Point p3 = new Point(-5, 3);
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, 1);
		Point[] points = { p1, p2, p3 };
		System.out.println(maxPoints(points));
	}
}
