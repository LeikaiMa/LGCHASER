package power;
// pow 看起来简单但是实际上要要加快计算速度需要考虑很多方面。
// 首先是要考虑到底数和指数的符号。先将两个都变为正数，这样处理会比较好。
// 如果底数是负数，需要看指数是不是偶数，如果是偶数，结果也就正数，如果是奇数，结果是负数。
// 如果指数是负数，需要在最后的时候取倒数。
// 开始的时候判断指数是不是 0 如果是0 可以直接返回1
// 底数也可以判断是否是 0 1 -1，但本题没有考虑到
// 接下来是如果指数比较大的情况，需要加快速度。指数的乘法是可以换算成底数的幂指数。
// 可以让底数自己乘以自己，这样每次幂指数可以以2的系数减少。
// 但是除以2太多之后余数可能会很大，这个时候不用for循环依次相乘，而是可以再用本身进行递归。再把结果相乘。速度会以指数上升
// 要注意里面的除以2的时机，写的不是很清楚，是尝试出来的。
public class Power {
	public static double pow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		boolean isPositive = n > 0;
		boolean isNegative = x < 0;
		n = Math.abs(n);
		x = Math.abs(x);
		double result = x;
		int i = 2;
		while (n / i > 0) {
			result = result * result;
			i *= 2;
		}
		result = result * pow(x, n % (i / 2));
		if (!isPositive) {
			result = 1.0 / result;
		}
		if (isNegative) {
			if (n % 2 == 1) {
				result = -result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(pow(0, 0) == Math.pow(0, 0));
		System.out.println(pow(2, 5) == Math.pow(2, 5));
		System.out.println(pow(2, -5) == Math.pow(2, -5));
		System.out.println(pow(2, 6) == Math.pow(2, 6));
		System.out.println(pow(2, 1000) == Math.pow(2, 1000));
		System.out.println(pow(0.00001, 2147483647) == Math.pow(0.00001,
				2147483647));
		System.out.println(pow(-1.00000, -2147483648) == Math.pow(-1.00000, -2147483648));
	}
}
