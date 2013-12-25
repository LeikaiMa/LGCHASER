package jumpGameII;
// 因为要看总共的步数，所以每次更新的时候要等在maxCover 这个范围内全部算完之后再更新，这个时候就要用一个变量进行临时存储。
// 这里用的是newMaxCover 然后整体放到一个while true 中，如果是相等的情况，就说明已经不能前进了，这时候就是不能到达最后。
// 其他情况只需要cover 超过最后一个就可以返回jump 的次数。
public class DP {
	public int jump(int[] A) {
		if (A == null || A.length == 0 || A.length == 1) {
			return 0;
		}
		int len = A.length;
		int maxCover = 0;
		int i = 0;
		int jump = 0;
		while (true) {
			jump++;
			int newMaxCover = maxCover;
			for (; i <= maxCover; i++) {
				newMaxCover = Math.max(newMaxCover, i + A[i]);
				if (newMaxCover >= len - 1) {
					return jump;
				}
			}
			if (newMaxCover > maxCover) {
				maxCover = newMaxCover;
			} else {
				return -1;
			}
		}

	}
}
