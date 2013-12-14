package sudoku;

import java.util.HashSet;
// 求解数独是可以这样利用，先检查哪一个是“.”，是的话就检查这个里面有多少个candidate， 每个candidate 覆盖掉里面board 中的“.”
// 然后再递归到里面，如果可行就返回true 不可行就返回false。然后让上一层重新替换掉值来进行进一步的递归。
// 要注意的是如果不行要记得将这个空赋值为"."

public class SolveSudoku {
	public void solveSudoku(char[][] board) {
		SudokuSolver(board);
    }
	
	public static boolean SudokuSolver(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					HashSet<Character> candidates = getCandidates(board, i, j);
					for (Character c : candidates) {
						board[i][j] = c;
						if (SudokuSolver(board)) {
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
    
    public static HashSet<Character> getCandidates(char[][] board, int row,
			int column) {
		HashSet<Character> candidates = new HashSet<Character>();
		for (char c = '1'; c <= '9'; c++) {
			candidates.add(c);
		}
		for (int i = 0; i < board[0].length; i++) {
			if (candidates.contains(board[row][i])) {
				candidates.remove(board[row][i]);
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (candidates.contains(board[i][column])) {
				candidates.remove(board[i][column]);
			}
		}
		int r = row / 3;
		int c = column / 3;
		for (int i = 3 * r; i < 3 * r + 3; i++) {
			for (int j = 3 * c; j < 3 * c + 3; j++) {
				if (candidates.contains(board[i][j])) {
					candidates.remove(board[i][j]);
				}
			}
		}
		return candidates;
    }
}
