package maximum;
// 因为overflow 只会出现在两个符号是相反的，相同的符号不会出现所以可以直接用原来那个方法。
// 比较两个符号是否相反，就要用两个数的符号进行直接比较，就出现sa sb 这种类型的数字。
// 如果两个符号相同也可以同样用着来表现出来。然后1 和 0 相乘也是一种很好的if else 的方法。
// 然后相加就可以。
// 如果符号相反就可以直接看符号到底是哪个正的就最大。
// 这题巧妙之处就将几种不同情况直接放在一起。不需要分开得出最后结果。
public class ConsiderOverflow {
	public static int flip(int bit) {
		return 1 ^ bit;
	}

	public static int sign(int a) {
		return flip((a >> 31) & 0x1);
	}

	public static int getMax(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);

		int use_sign_of_a = sa ^ sb;
		int use_sign_of_c = flip(sa ^ sb);

		int k = use_sign_of_a * sa + use_sign_of_c * sc;
		int q = flip(k);

		return a * k + b * q;
	}
}
