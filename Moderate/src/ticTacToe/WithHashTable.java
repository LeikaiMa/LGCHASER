package ticTacToe;
// 如果整个棋盘比较小，情况比较小，而且知道总的个数，这样可以直接将这些都先存到一个array 里面，如果遇到什么情况，可以先将这个board 转换为一个int
// 这样就类似于一个hashtable 有很高的效率
// 在求一个棋盘的hashcode 的时候可以先将这个棋盘变成一个三进制的数，然后遍历这个棋盘，里面有个个factor 每次乘以3
// sum 也可以相加，每次里面的值代表什么数字的时候可以与factor 相乘，然后进行相加。
public class WithHashTable {
	int[] winnerHashtable;

	public int hasWon(int board) {
		return winnerHashtable[board];
	}

	public static int convertBoardToInt(char[][] board) {
		int factor = 1;
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int v = 0;
				if (board[i][j] == 'x') {
					v = 1;
				} else if (board[i][j] == 'o') {
					v = 2;
				}
				
				sum += v *factor;
				factor *= 3;
			}
		}
		return sum;
	}
}
