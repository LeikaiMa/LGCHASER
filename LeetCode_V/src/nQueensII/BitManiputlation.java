package nQueensII;
// 这个是效率最高的求皇后的问题。 利用位操作来进行运算。
// 首先是建一个统计总共次数的变量，因为java 这里不好用静态变量，就用一个数组传进去， 还有一个是一行最后要出现的填满的情况。
// 是1向左移动n 位然后减1，那么就有n 个 1出现。
// 下面的操作就是如何将一个空的全部都是0 填满1.
// 因为是要进行递归，所以base case 是这一行已经填满了，这样的情况就是总的个数+1 ，否则要往下面一行填。
// 填一行的时候，首先要看哪些位置是可以填1的，因为传进来的是三个变量，一个row 不能填的地方，一个因为左斜着不能填的地方，一个是因为右斜不能填的地方，
// 他们与起来就是所有不能填的地方，取反之后就是变成哪些能填的地方变成1，但是有个问题就是int 是32位，其他超过n 的也变成1了。要限制在棋盘的大小，这样用前面一行全为1的进行与。
// 这样就变成在这一行的限制里面填的地方。
// 要找第一个可以填的地方，就是自己和自己的相反数与，利用负数的性质，这样就能够得到第一个为1的地方。
// 这个地方填了1 就不能要了，用pos 减去这个1的位置，这样直到0 的时候表明全部的情况都填好了。
// 下面还是利用dfs 的性质，填下一格，因为现在多填了一个，那么下面在这个基础上多了限制的地方。
// 同一列不能填了，但是下面的位置不变，左斜线也不能填，填好1 然后左移一位。 右斜线也不能填了，填好1之后右移一位。
// 这样能够全部填完毕。而且因为用了位操作所以速度很快。
public class BitManiputlation {

	public static int totalNQueens(int n) {
		int count = 0;
		int upper = (1 << n) - 1;
		int[] paras = new int[2];
		paras[0] = count;
		paras[1] = upper;
		Queen(0, 0, 0, paras);
		return paras[0];
	}

	private static void Queen(int row, int ld, int rd, int[] paras) {
		int upper = paras[1];
		int pos, p;
		if (row != upper) {
			pos = upper & (~(row | ld | rd));
			while (pos != 0) {
				p = pos & -pos;
				pos = pos - p;
				Queen(row + p, (ld + p) << 1, (rd + p) >> 1, paras);
			}
		} else {
			paras[0]++;
		}
	}

	public static void main(String[] args) {
		System.out.println(totalNQueens(12));
	}
}
