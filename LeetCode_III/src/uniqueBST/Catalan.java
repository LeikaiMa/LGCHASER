package uniqueBST;

// 分析这道题，是将里面的里面取任意位的数字，左边的数字再放在left child 再建一个一个BST 再在右边用右边的东西建一个BST
// 整理下来可以看出来是 f(n) = f(i-1)f(n-i)   也就f(0)f(n-1) + f(1)f(n-2) + ....
// 可以用递归来进行，f(0) = 1 f(1) = 1...
// 但是通过分析可以看出这种类型其实是catalan number 
// Cn+1 = CiCn-i 求和    或者可以更加简便用Cn+1 = 2(2n+1)Cn / (n+2) 注意这里面要先乘再除，避免因为int 之间除法算作整除。
// 其他应用：
// 矩阵链乘 P = a1*a2*a3*a4... 用括号根据结合律来进行成对的乘积。
// 可以分为(a1) * (a2*a3*a4)... (a1*a2) * (a3*a4..) 等等 f(n)= f(1)f(n-1) + f(2)f(n-2) + f(n-1)f(1) = h(n-1)
// 入栈问题 一个栈(无穷大)的进栈序列为1，2，3，…，n，有多少个不同的出栈序列?
// 个与加括号的很相似，进栈操作相当于是左括号，而出栈操作相当于右括号。n个数的进栈次序和出栈次序构成了一个含2n个数字的序列。第0个数字肯定是进栈的数，这个数相应的出栈的数一定是第2i+1个数。
// 因为如果是2i，那么中间包含了奇数个数，这奇数个肯定无法构成进栈出栈序列。
// 设问题的解为f(2n)， 那么f(2n) = f(0)*f(2n-2) + f(2)*f(2n-4) + f(2n-2)*f(0)。f(0) * f(2n-2)表示第0个数字进栈后立即出栈，此时这个数字的进栈与出栈间包含的数字个数为0，剩余为2n-2个数。
// f(2)*f(2n-4)表示第0个数字进栈与出栈间包含了2个数字，相当于1 2 2 1，剩余为2n-4个数字。依次类推。
// 假设f(0) = 1，计算一下开始几项，f(2) = 1, f(4) = 2, f(6) = 5。结合递归式，不难发现f(2n) 等于h(n)。
// 其他问题参考
// http://buptdtt.blog.51cto.com/2369962/832586
// http://blog.csdn.net/hackbuteer1/article/details/7450250
public class Catalan {
	public int numTrees(int n) {
		int Cn = 1;
		for (int i = 0; i < n; i++) {
			Cn = (4 * i + 2) * Cn / (i + 2);
		}
		return Cn;
	}

	public static void main(String[] args) {
		System.out.println(new Catalan().numTrees(1));
		System.out.println(new Catalan().numTrees(2));
		System.out.println(new Catalan().numTrees(3));
		System.out.println(new Catalan().numTrees(4));
	}

}
