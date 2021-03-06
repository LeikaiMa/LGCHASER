package nQueensII;
// 这里用的是之前的方法，采用了permutation的方法，先生成所有的排列方法，看看哪些不行就直接剔除，行的话就+1
// 生成排列的方法，用的不是insert 的方法，而是用了交换的 思想，从第一个开始然后后面的值一直和自己进行交换，
// 第一位分别和自己，和第二位一直到最后一位进行交换，然后递归到后一位同样是和后面包括自己进行交换，如果不包括自己会少很多的次序。
// 直到开始和最后的相同时候说明到了最后，这时候check 情况。因为已经保证了横竖肯定不会在一行或者一列，只要看斜着的是否是相同。这时候用的就是看两个index 的差和值的差的绝对值是不是相同。
// 但是效率比较低。可以进行优化
public class Permutation {
	public static int totalNQueens(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

		int[] res = new int[1];
		res[0] = 0;
		permutation(p, 0, n - 1, res);
		return res[0];
	}

	private static void permutation(int[] p, int start, int end, int[] res) {
		if (start == end) {
			if (check(p)) {
				res[0]++;
			}
		} else {
			for (int i = start; i < p.length; i++) {
				swap(p, i, start);
				permutation(p, start + 1, end, res);
				swap(p, i, start);
			}
		}
	}

	private static boolean check(int[] p) {
		for (int i = 0; i < p.length - 1; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (Math.abs(p[i] - p[j]) == Math.abs(i - j)) {
					return false;
				}
			}
		}
		return true;
	}

	private static void swap(int[] p, int i, int j) {
//		System.out.println("i: "+ i + " " + p[i]);
//		System.out.println("j: "+ j + " " + p[j]);
//		p[i] = p[i] ^ p[j];
//		p[j] = p[i] ^ p[j];
//		p[i] = p[i] ^ p[j];
//		System.out.println("i: "+ i + " " + p[i]);
//		System.out.println("j: "+ j + " " + p[j]);
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
	
	public static void main(String[] args) {
		System.out.println(totalNQueens(12));
	}

}
