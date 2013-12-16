package addition;
// 如果不用+等算术运算符，就需要用其他的逻辑运算符。
// 看加法的本质，就是把sum 和 carry 相加，sum 的是 XOR carry 是 & << 1
// 之后仍然是加法就需要用recursion
// base case 是 carry 为 0 ，这样就不需要进行相加。
public class Add {
	public static int add(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}
}
