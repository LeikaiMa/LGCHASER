package swap;
// 交换顺序，一种方法可以用diff 的方法，就是求两个数的差，然后在这个过程之中可以得到通过两边的差距来进行转换。
// XOR 同样是求两边的差异程度，但是他比diff 的优势， 就是形式简单，容易操作。
public class Swap {
	public static void swap(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}

	public static void swap_opt(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}
