package maximum;
// 不用if else 的方法就是看他到底是相减之后的正负。
// 而正负是在前面的符号位。
// 将一位进行取反，用的是XOR 和1.
// 因为前面的首位正数是0 而负数是1 所以取完首位之后要进行取反。
// 但是这个方法的问题在于相减之后会overflow
public class Naive {
	public static int flip(int bit) {
		return 1 ^ bit;
	}

	public static int sign(int a) {
		return flip((a >> 31) & 0x1);
	}

	public static int getMaxNaive(int a, int b) {
		int k = sign(a - b);
		int q = flip(k);
		return a * k + b * q;
	}
}
