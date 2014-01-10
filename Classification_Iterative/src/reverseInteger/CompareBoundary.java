package reverseInteger;
// II
//reverse integer 总体流程是原来数据取出最后一位，然后新的integer在最后一位上插入，开始可以将一些特殊情况直接处理。
//比如最大值和最小值还有一位数的都可以直接返回
//在过程中判断的时候看是否overflow 可以放一个比他慢的参数，如果参数比快的还要大说明overflow了
//这样的话开始就应该先判断是否是正负数，否则就应该另外考虑。
//出循环后看是否正常出循环，如果不是就直接返回最大或者最小值。如果是正常返回，就应该返回output 里面的值加上符号。

// 关键点是和max 以及min 进行比较，这里用四个判断语句来进行，看和最大最小的时候/10是不是相等来进行比较。如果大肯定就不行，如果想等看最后一个数字是不是>=7 还是>=8
public class CompareBoundary {
	public int reverse(int x) {
		if (x < 10 && x > -10) {
			return x;
		}

		boolean positive = x >= 0 ? true : false;

		x = Math.abs(x);

		int result = 0;

		while (x > 0) {
			int a = x % 10;

			if (positive && result > Integer.MAX_VALUE / 10) {
				return Integer.MAX_VALUE;
			}

			if (positive && result == Integer.MAX_VALUE / 10 && a >= 7) {
				return Integer.MAX_VALUE;
			}

			if (!positive && -result < Integer.MIN_VALUE / 10) {
				return Integer.MIN_VALUE;
			}

			if (!positive && -result == Integer.MIN_VALUE / 10 && a >= 8) {
				return Integer.MIN_VALUE;
			}

			result = result * 10 + a;
			x /= 10;
		}

		return positive ? result : -result;
	}
}
