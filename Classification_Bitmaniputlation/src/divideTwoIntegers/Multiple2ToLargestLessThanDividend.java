package divideTwoIntegers;
//VI
//限制了不能使用* / % 就意味着用其他符号来代替除号。
//首先想到的是用减号，但是一直减的情况会特别的费时。想到了一种类似于乘法和除法的符号，那个就是左移和右移，这样的情况是* 2 和除 * 2的情况
//首先找到他可以的最大2的倍数除数，用一个while 循环，将除数不断的扩大，直到他比他大，结束，这个肯定是最大的2的倍数的除数的2倍。
//因为要记录到底是乘了多大的2的倍数的系数。所以要用另一个变量来同时记录扩大的倍数。一起左移。
//这时候会出现的问题就是最大integer的话，我要检测肯定要超过integer，所以先将所有的都变成了long 型，
//而且最好不要考虑符号，所以开始的时候有个boolean 来记录是不是负数，开始的时候是false 如果一个是负数，就反转一次。
//得到最大的2 的倍数的除数，这时候就要开始减了，
//直到现在这个除数比原来最开始定义的除数还要小的时候就不执行了，因为剩下的是余数。
//然后被除数在现在这个除数下进行减，一直减到比这个除数小的时候，这个除数的作用就消失了。结果的是一直累加这个除数是原来的多少倍。
//然后这个除数缩小2倍，再继续同样的操作。直到这个除数缩小到比给定的除数还要小。
//最后要记得将结果一个是看要不要取相反数，方法是取反+1
//最后将long 型再转回int

//这里要注意的是因为不考虑符号，就要取绝对值，这时候有可能会超过，所以要强制转换成long 型。然后取反可以直接用- 而不用~ +1 这种形式。
public class Multiple2ToLargestLessThanDividend {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (divisor == 1 || divisor == -1) {
			return divisor > 0 ? dividend : -dividend;
		}

		if (dividend == 0) {
			return 0;
		}

		boolean positive = true;

		if (dividend < 0) {
			positive = !positive;
		}

		if (divisor < 0) {
			positive = !positive;
		}

		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		long c = b;
		long len = 1;

		while (c <= a) {
			c <<= 1;
			len <<= 1;
		}

		long result = 0;
		c >>= 1;
		len >>= 1;

		while (c >= b) {
			while (a >= c) {
				a -= c;
				result += len;
			}

			c >>= 1;
			len >>= 1;
		}

		result = positive ? result : -result;
		return (int) result;
	}
}
