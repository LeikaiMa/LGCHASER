package sudokuSolver;
// I
//求解数独是可以这样利用，先检查哪一个是“.”，是的话就检查这个里面有多少个candidate， 每个candidate 覆盖掉里面board 中的“.”
//然后再递归到里面，如果可行就返回true 不可行就返回false。然后让上一层重新替换掉值来进行进一步的递归。
//要注意的是如果不行要记得将这个空赋值为"."
import java.util.HashSet;
// 去掉有效的可能值的一个方法就是用hashset 来进行remove 
// return false 之前要记得将值变回'.'不然其他值会出问题。以为这个被占住了。
public class TryCandidates {
	public void solveSudoku(char[][] board) {
		solveSudokuHelper(board);
	}

	public boolean solveSudokuHelper(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					HashSet<Character> candidates = getCandidates(board, i, j);
					for (Character c : candidates) {
						board[i][j] = c;
						if (solveSudokuHelper(board)) {
							return true;
						}
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

	private HashSet<Character> getCandidates(char[][] board, int row, int column) {
		HashSet<Character> candidates = new HashSet<Character>();

		for (char c = '1'; c <= '9'; c++) {
			candidates.add(c);
		}

		for (int i = 0; i < board.length; i++) {
			if (candidates.contains(board[i][column])) {
				candidates.remove(board[i][column]);
			}
		}

		for (int j = 0; j < board[0].length; j++) {
			if (candidates.contains(board[row][j])) {
				candidates.remove(board[row][j]);
			}
		}

		int rc = row / 3 * 3;
		int cc = column / 3 * 3;

		for (int i = rc; i < rc + 3; i++) {
			for (int j = cc; j < cc + 3; j++) {
				if (candidates.contains(board[i][j])) {
					candidates.remove(board[i][j]);
				}
			}
		}

		return candidates;
	}
}
