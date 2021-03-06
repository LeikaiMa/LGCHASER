package jumpGame;
//IV
//因为要追求速度，不需要记录有多少次能够到达这个点
//因为是在这个里面任意步数都是可以到达，只需要记录最大的cover 的位置就可以。每次比较maxcover 有没有包括最后一个的位置。如果包括就可以直接返回。
//另外一个虽然用了DP 但是多了没有必要的写的过程，所以速度慢。

//可以从0 开始。然后看最远的距离。
public class MaxCover {
	public boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i <= max; i++) {
			max = Math.max(max, A[i] + i);
			if (max >= A.length - 1) {
				return true;
			}
		}
		return false;
	}
}
