package countNumberTwos;
// 遍历每一个数，然后计算每个数里面的2的个数
public class BruteForce {
	public int numberOf2sInRange(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			count += numberOf2s(i);
		}
		return count;
	}

	public int numberOf2s(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 2) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
}
