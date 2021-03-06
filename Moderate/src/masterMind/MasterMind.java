package masterMind;
// 猜颜色主要的是在pseudo 要把 hits 的去除， 而且猜的必须是里面有的，如果里面猜的比真实的还多也不能算。
// 首先为了保持代码整洁，将result 包装起来，然后每个颜色代表一个数字，可以用的是枚举，但是如果用switch 来处理，多一个default 可以把乱猜的也包括进去。
// 首先还是老规矩在开始检查是否直接不符合，避免下面的麻烦。
// 然后遍历整个guess 看guess 有没有猜对。可以直接变成hits 如果没有猜对，可以直接把答案里面的存到一个数组，当做频率。
// 这样可以把hits 直接从pseudo 里面剔除，而且也可以做下面真正求pseudo 时候的基数。 而且如果猜多了也可以避免多猜。
// 用code 这个函数可以直接对应到int 里面去。
public class MasterMind {
	public class Result {
		public int hits = 0;
		public int pseudoHits = 0;

		public String toString() {
			return "(" + hits + ", " + pseudoHits + ")";
		}
	}

	public int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}

	public static int MAX_COLORS = 4;

	public Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()) {
			return null;
		}

		Result res = new Result();
		int[] frequencies = new int[MAX_COLORS];

		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				res.hits++;
			} else {
				int code = code(solution.charAt(i));
				frequencies[code]++;
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && frequencies[code] > 0
					&& guess.charAt(i) != solution.charAt(i)) {
				res.pseudoHits++;
				frequencies[code]--;
			}
		}
		return res;
	}
}
