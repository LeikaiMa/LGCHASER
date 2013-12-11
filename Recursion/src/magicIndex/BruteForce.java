package magicIndex;
// 这个最容易想到的一个方法，但是根据这题的要求
// 需要全部遍历，不过可以想到如果是排好序就可以用二分法来进行优化计算。

public class BruteForce {
	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return 1;
			}
		}
		return -1;
	}
}
