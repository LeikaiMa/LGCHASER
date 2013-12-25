package jumpGame;
// 因为要追求速度，不需要记录有多少次能够到达这个点
// 因为是在这个里面任意步数都是可以到达，只需要记录最大的cover 的位置就可以。每次比较maxcover 有没有包括最后一个的位置。如果包括就可以直接返回。
// 另外一个虽然用了DP 但是多了没有必要的写的过程，所以速度慢。
public class DPNoArray {
	public boolean canJump(int[] A) {
		if (A == null) {
			return false;
		}
		int len = A.length;
		if (len == 0) {
			return false;
		}
		if (len == 1) {
			return true;
		}

		int maxCover = A[0];
		for (int i = 1; i <= maxCover; i++) {
			maxCover = Math.max(A[i] + i, maxCover);
			if (maxCover >= len - 1) {
				return true;
			}
		}
		
		return false;
	}
}
