package trailingOfZeros;
// 更优的方法在于可以不进行遍历，因为都是连续的，可以通过最后一个值推断出前面的值。
// 因为是求5的个数，所以也就是求 5 25 125等等的个数。
// 可以直接用最后一个值来进行推断。 这样就可以节省次数
public class CountZeroDirectly {
	public int countFactZeros(int num) {
		int count = 0;
		if (num < 0) {
			return -1;
		}

		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}

		return count;
	}
}
