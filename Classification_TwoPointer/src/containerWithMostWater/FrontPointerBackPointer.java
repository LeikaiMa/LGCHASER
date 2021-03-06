package containerWithMostWater;
// I - 9
//求能够盛的最多水的桶的时候，开始因为看错题，以为是必须两边相平，所以想到用hashtable 来进行存，因为也不需要考虑高的大小比较。
//key 是 height value 是所有对应的横坐标组成的arraylist 因为之后要进行排序，可以得到最大和最小的在两头。
//height 和 横坐标的最大范围可以得到最大的大小。
//但是实际上是允许两边的变框不一样长，这样就表示，height 小的可以包括height 大的
//一种方法是在小的height 里把所有的都存了。
//还有一种是我用的将height 也排序从大到小，这样后面的越来越大。
//这时候就考虑到了tree map 这个。
//然后max 和min 是在之前基础上得到的最大和最小值。
//所以可以用math 里面的最大最小来进行计算。


// 因为要求容积，就是两边取短值，然后底是两个index 之差。这样可以想到由最两边开始，往里面进行缩进
// 和外面存的最大值进行比较，如果大就更新，然后小的那一边往里面所以，只有找到更大的值才能打败之前的。
// 中间有些优化，就是往里缩的时候如果比自己小的或者相等还是进行忽略。然后往前或者往后移动一位。
// 但是要记得边界条件，这个容易忘记。
public class FrontPointerBackPointer {
	public int maxArea(int[] height) {
		int max = 0;
		int i = 0;
		int j = height.length - 1;

		while (i < j) {
			int hi = height[i];
			int hj = height[j];

			max = Math.max(max, Math.min(hi, hj) * (j - i));

			if (hi < hj) {
				i++;
				while (i < height.length && height[i] <= height[i - 1]) {
					i++;
				}
			} else {
				j--;
				while (j >= 0 && height[j] <= height[j + 1]) {
					j--;
				}
			}
		}

		return max;
	}
}
