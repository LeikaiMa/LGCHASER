package ticTacToe;
// 如果是棋盘比较大，就需要用循环来check， 这时候同样是先看这个是否为空，如果不空可以从1开始测，这样可以将它和前一个进行比较。这样都比较完毕。
// 中间如果不行就直接break
// break 出来之后就要进行比较，如果比较完之后是N 就说明是正确的，如果不是就说明是中间break 出来的。
public class ComplicatedBoard {
	Piece hasWon(Piece[][] board) {
		int N = board.length;
		int row = 0;
		int col = 0;

		for (row = 0; row < N; row++) {
			if (board[row][0] != Piece.Empty) {
				for (col = 1; col < N; col++) {
					if (board[row][col] != board[row][col - 1]) {
						break;
					}
				}

				if (col == N) {
					return board[row][0];
				}
			}
		}

		for (col = 0; col < N; col++) {
			if (board[0][col] != Piece.Empty) {
				for (row = 1; row < N; row++) {
					if (board[row][col] != board[row - 1][col]) {
						break;
					}
				}

				if (row == N) {
					return board[0][col];
				}
			}
		}

		if (board[0][0] != Piece.Empty) {
			for (row = 1; row < N; row++) {
				if (board[row][row] != board[row - 1][row - 1]) {
					break;
				}
			}
			if (row == N) {
				return board[0][0];
			}
		}

		if (board[N - 1][0] != Piece.Empty) {
			for (row = 1; row < N; row++) {
				if (board[N - row - 1][row] != board[N - row][row - 1]) {
					break;
				}
			}

			if (row == N) {
				return board[N - 1][0];
			}
		}

		return Piece.Empty;
	}

}
