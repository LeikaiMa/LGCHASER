package stairs;

public class Stairs {
	// stairs 是一个简单的递归问题，因为要走不同的步数，所以要不通的看待
	// 从后往前走，这样递归到最开始的时候，如果正好走到0 就说明这种走法可行
	// 如果走到最开始为负数，说明这种方法走不通。
	// 但是这个需要的是O（3^N)
	public static int stairs(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		} else {
			return stairs(n - 1) + stairs(n - 2) + stairs(n - 3);
		}
	}
//	如果用DP来解决问题， 可以节省时间，因为将已经求过的值存在了数组当中
//	要注意的问题是需要随函数传入数组来保存相应的数组
//	而且如果要取其中保存的数据，用n 则要把其中的空间+1，而且初始值要保存为-1.
	public static int DPstairs(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = DPstairs(n - 1, map) + DPstairs(n - 2, map)
					+ DPstairs(n - 3, map);
			return map[n];
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[] map = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			map[i] = -1;
		}
		System.out.println(stairs(n));
		System.out.println(DPstairs(n, map));
	}

}
