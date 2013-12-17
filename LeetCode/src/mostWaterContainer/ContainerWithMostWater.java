package mostWaterContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
// 求能够盛的最多水的桶的时候，开始因为看错题，以为是必须两边相平，所以想到用hashtable 来进行存，因为也不需要考虑高的大小比较。
// key 是 height value 是所有对应的横坐标组成的arraylist 因为之后要进行排序，可以得到最大和最小的在两头。
// height 和 横坐标的最大范围可以得到最大的大小。
// 但是实际上是允许两边的变框不一样长，这样就表示，height 小的可以包括height 大的
// 一种方法是在小的height 里把所有的都存了。
// 还有一种是我用的将height 也排序从大到小，这样后面的越来越大。
// 这时候就考虑到了tree map 这个。
// 然后max 和min 是在之前基础上得到的最大和最小值。
// 所以可以用math 里面的最大最小来进行计算。
public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		if (height == null) {
			return 0;
		}
		TreeMap<Integer, ArrayList<Integer>> containers = new TreeMap<Integer, ArrayList<Integer>>(
				Collections.reverseOrder());
		int maxArea = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < height.length; i++) {
			if (!containers.containsKey(height[i])) {
				ArrayList<Integer> heights = new ArrayList<Integer>();
				heights.add(i);
				containers.put(height[i], heights);
			} else {
				ArrayList<Integer> heights = containers.get(height[i]);
				heights.add(i);
			}
		}

		Set<Integer> keys = containers.keySet();
		for (Integer key : keys) {
			ArrayList<Integer> heights = containers.get(key);
			Collections.sort(heights);
			max = Math.max(heights.get(heights.size() - 1), max);
			min = Math.min(heights.get(0), min);

			int area = key * (max - min);
			if (maxArea < area) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] height = {1,2};
		System.out.println(maxArea(height));
	}
}
