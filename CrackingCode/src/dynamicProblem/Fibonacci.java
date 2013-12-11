package dynamicProblem;
// 最简单的DP 问题，和递归问题的区别在于存的东西会更加多一些
// 同样有一些base， 这时候要对其进行递归。
// fibonacci 这个方法最简单的是用了递归，但是要O（2^n）
// 如果用的是DP 的方法就是要将里面的值进行cache
// 这样时间复杂度就可以降到O（N）
public class Fibonacci {
	static int max = 20;
	static int[] fib = new int[max];
	public static int fibonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
//	这个的好处在于，你先把已经计算过的值存起来， 如果有的话就可以直接从存好的当中取出来
//	这样可以减少不必要的计算。
	public static int DPfibonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		if (fib[i] != 0) {
			return fib[i];
		}
		fib[i] = DPfibonacci(i -1) + DPfibonacci(i - 2);
		return fib[i];
	}
	
	public static void main(String[] args) {
		System.out.print(fibonacci(0) + " ");
		System.out.print(fibonacci(1) + " ");
		System.out.print(fibonacci(2) + " ");
		System.out.print(fibonacci(3) + " ");
		System.out.print(fibonacci(4) + " ");
		System.out.print(fibonacci(5) + " ");
		System.out.print(fibonacci(6) + " ");
		System.out.print(fibonacci(7) + " ");
		System.out.println();
		
		System.out.print(DPfibonacci(0) + " ");
		System.out.print(DPfibonacci(1) + " ");
		System.out.print(DPfibonacci(2) + " ");
		System.out.print(DPfibonacci(3) + " ");
		System.out.print(DPfibonacci(4) + " ");
		System.out.print(DPfibonacci(5) + " ");
		System.out.print(DPfibonacci(6) + " ");
		System.out.print(DPfibonacci(7) + " ");
		System.out.println();
		
		
		
	}
}
