package validSudoku;
// I - 18
//检查是否是valid 的数独，要做的是满足三个条件。
//这时候可以做的是遍历所有的格子，检查每个格子是否满足条件，横竖和一个九宫格里面都是不重复数字。
//九宫格是直接/3 然后看+1 +2 +3 这样遍历。
public class CheckThreeRestriction {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					if (!isValid(board, i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int row, int column) {
		for (int i = 0; i < board.length; i++) {
			if (i != row && board[i][column] == board[row][column]) {
				return false;
			}
		}

		for (int j = 0; j < board[0].length; j++) {
			if (j != column && board[row][j] == board[row][column]) {
				return false;
			}
		}

		int rc = row / 3 * 3;
		int cc = column / 3 * 3;

		for (int i = rc; i < rc + 3; i++) {
			for (int j = cc; j < cc + 3; j++) {
				if (i != row || j != column) {
					if (board[i][j] == board[row][column]) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
