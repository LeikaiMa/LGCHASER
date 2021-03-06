package sudoku;
// 检查是否是valid 的数独，要做的是满足三个条件。
// 这时候可以做的是遍历所有的格子，检查每个格子是否满足条件，横竖和一个九宫格里面都是不重复数字。
// 九宫格是直接/3 然后看+1 +2 +3 这样遍历。
import java.util.Arrays;

public class CheckValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					if (!checkBoard(board, i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean checkBoard(char[][] board, int row, int column) {
		for (int i = 0; i < board[0].length; i++) {
			if (i == column) {
				continue;
			}
			if (board[row][i] == board[row][column]) {
//				System.out.println("same row");
				return false;
			}
		}
		for (int i = 0; i < board.length; i++) {
			if (i == row) {
				continue;
			}
			if (board[i][column] == board[row][column]) {
//				System.out.println("same column");
				return false;
			}
		}

		int r = row / 3;
		int c = column / 3;
		for (int i = 3 * r; i < 3 * r + 3; i++) {
			for (int j = 3 * c; j < 3 * c + 3; j++) {
				if (i == row && j == column) {
					continue;
				}
				if (board[i][j] == board[row][column]) {
//					System.out.println("same block");
					return false;
				}
			}
		}

		return true;

	}


	public static void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("-------------");
	}

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		String[] lines = new String[9];

		// lines[0] = "..4...63.";
		// lines[1] = ".........";
		// lines[2] = "5......9.";
		// lines[3] = "...56....";
		// lines[4] = "4.3.....1";
		// lines[5] = "...7.....";
		// lines[6] = "...5.....";
		// lines[7] = ".........";
		// lines[8] = ".........";

		// lines[0] = "53..7....";
		// lines[1] = "6..195...";
		// lines[2] = ".98....6.";
		// lines[3] = "8...6...3";
		// lines[4] = "4..8.3..1";
		// lines[5] = "7...2...6";
		// lines[6] = ".6....28.";
		// lines[7] = "...419..5";
		// lines[8] = "....8..79";
		// lines[0] = "...26.7.1";
		// lines[1] = "68..7..9.";
		// lines[2] = "19...45..";
		// lines[3] = "82.1...4.";
		// lines[4] = "..46.29..";
		// lines[5] = ".5...3.28";
		// lines[6] = "..93...74";
		// lines[7] = ".4..5..36";
		// lines[8] = "7.3.18...";
		lines[0] = ".87654321";
		lines[1] = "2........";
		lines[2] = "3........";
		lines[3] = "4........";
		lines[4] = "5........";
		lines[5] = "6........";
		lines[6] = "7........";
		lines[7] = "8........";
		lines[8] = "9........";
		// lines[0] = "..5.....6";
		// lines[1] = "....14...";
		// lines[2] = ".........";
		// lines[3] = ".....92..";
		// lines[4] = "5....2...";
		// lines[5] = ".......3.";
		// lines[6] = "...54....";
		// lines[7] = "3.....42.";
		// lines[8] = "...27.6..";

		for (int i = 0; i < 9; i++) {
			board[i] = lines[i].toCharArray();
		}
		printBoard(board);
		CheckValidSudoku bf = new CheckValidSudoku();
		if (bf.isValidSudoku(board)) {
			printBoard(board);
		}

	}
}
