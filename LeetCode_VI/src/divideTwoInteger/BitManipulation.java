package divideTwoInteger;
// 限制了不能使用* / % 就意味着用其他符号来代替除号。
// 首先想到的是用减号，但是一直减的情况会特别的费时。想到了一种类似于乘法和除法的符号，那个就是左移和右移，这样的情况是* 2 和除 * 2的情况
// 首先找到他可以的最大2的倍数除数，用一个while 循环，将除数不断的扩大，直到他比他大，结束，这个肯定是最大的2的倍数的除数的2倍。
// 因为要记录到底是乘了多大的2的倍数的系数。所以要用另一个变量来同时记录扩大的倍数。一起左移。
// 这时候会出现的问题就是最大integer的话，我要检测肯定要超过integer，所以先将所有的都变成了long 型，
// 而且最好不要考虑符号，所以开始的时候有个boolean 来记录是不是负数，开始的时候是false 如果一个是负数，就反转一次。
// 得到最大的2 的倍数的除数，这时候就要开始减了，
// 直到现在这个除数比原来最开始定义的除数还要小的时候就不执行了，因为剩下的是余数。
// 然后被除数在现在这个除数下进行减，一直减到比这个除数小的时候，这个除数的作用就消失了。结果的是一直累加这个除数是原来的多少倍。
// 然后这个除数缩小2倍，再继续同样的操作。直到这个除数缩小到比给定的除数还要小。
// 最后要记得将结果一个是看要不要取相反数，方法是取反+1
// 最后将long 型再转回int

public class BitManipulation {
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean minus = false;
		if (dividend <0) {
			minus = !minus;
		}
		if (divisor < 0) {
			minus = !minus;
		}
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		long c = 1;
		while (b <= a) {
			b = b << 1;
			c = c << 1;
		}

		long ob = Math.abs((long) divisor);
		long result = 0;
		b >>= 1;
		c >>= 1;
		while (b >= ob) {
			while (a >= b) {
				a = a - b;
				result = result + c;
			}
			b >>= 1;
			c >>= 1;
		}
		if (minus) {
			result = ~result + 1;
		}
		return (int) result;
	}

	public static void main(String[] args) {
		int dividend = -2147483647;
		int divisor = 1;
		dividend = -8;
		divisor = 2;
		System.out.println(divide(dividend, divisor));
		
	}
}
