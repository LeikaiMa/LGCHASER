package jumpGame;

public class DP {
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

		int[] ways = new int[len];
		for (int i = A[0]; i >= 1; i--) {
			if (i >= len - 1) {
				return true;
			} else {
				ways[i] += 1;
			}
		}

		for (int i = 1; i < len - 1; i++) {
			if (ways[i] > 0) {
				for (int j = A[i]; j >= 1; j--) {
					if (i + j >= len - 1) {
						return true;
					} else {
						ways[i + j] += 1;
					}
				}
			}
		}

		return false;
	}
}
