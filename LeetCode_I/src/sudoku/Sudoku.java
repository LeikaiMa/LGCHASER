package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Sudoku {
	public static boolean isValidSudoku(char[][] board) {
		Stack<Coordinate> stack = new Stack<Coordinate>();
		findNext(board, stack, true);
		if (stack.isEmpty()) {
			return false;
		}
		while (true) {
			Coordinate cur = stack.pop();
			board[cur.getRow()][cur.getColumn()] = cur.getCandidate();
			while (cur.getCandidate() == '.') {
				if (stack.isEmpty()) {
					return false;
				}
				cur = stack.pop();
				board[cur.getRow()][cur.getColumn()] = cur.getCandidate();
			}
			System.out.println("ROW: " + cur.row + " Column: " + cur.column );
			if ((cur.getRow() == board.length - 1)
					&& (cur.getColumn() == board[0].length - 1)) {
				break;
			} else {
				findNext(board, stack, false);
			}
		}
		return true;
	}

	public static void findNext(char[][] board, Stack<Coordinate> stack,
			boolean isFirst) {
		ArrayList<Coordinate> candidates = new ArrayList<Coordinate>();
		int i = 0;
		int j = 0;
		for (i = 0; i < board.length; i++) {
			for (j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					candidates = getCandidates(board, i, j);
					break;
				}
			}
			if (i < board.length && j < board[0].length && board[i][j] == '.') {
				break;
			}
		}
		if (candidates.size() > 0) {
			if (!isFirst) {
				Coordinate c = new Coordinate(i, j, '.');
				stack.add(c);
			}
			for (Coordinate coordinate : candidates) {
				stack.add(coordinate);
			}
		}

	}


	public static ArrayList<Coordinate> getCandidates(char[][] board, int row,
			int column) {
		HashSet<Character> candidates = new HashSet<Character>();
		ArrayList<Coordinate> slots = new ArrayList<Coordinate>();
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
		for (Character content : candidates) {
			Coordinate coordinate = new Coordinate(row, column, content);
			slots.add(coordinate);
		}
		return slots;

	}

	private static class Coordinate {
		int row;
		int column;
		char candidate;

		public Coordinate(int r, int c, char can) {
			row = r;
			column = c;
			candidate = can;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

		public char getCandidate() {
			return candidate;
		}

		public String toString() {
			String s = "Row:" + row + " Column: " + column + " Candidate: "
					+ candidate;
			return s;
		}
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
		// lines[0] = "53..7....";
		// lines[1] = "6..195...";
		// lines[2] = ".98....6.";
		// lines[3] = "8...6...3";
		// lines[4] = "4..8.3..1";
		// lines[5] = "7...2...6";
		// lines[6] = ".6....28.";
		// lines[7] = "...419..5";
		// lines[8] = "....8..79";
//		lines[0] = "...26.7.1";
//		lines[1] = "68..7..9.";
//		lines[2] = "19...45..";
//		lines[3] = "82.1...4.";
//		lines[4] = "..46.29..";
//		lines[5] = ".5...3.28";
//		lines[6] = "..93...74";
//		lines[7] = ".4..5..36";
//		lines[8] = "7.3.18...";
//		lines[0] = ".87654321";
//		lines[1] = "2........";
//		lines[2] = "3........";
//		lines[3] = "4........";
//		lines[4] = "5........";
//		lines[5] = "6........";
//		lines[6] = "7........";
//		lines[7] = "8........";
//		lines[8] = "9........";
		lines[0] = "..5.....6";
		lines[1] = "....14...";
		lines[2] = ".........";
		lines[3] = ".....92..";
		lines[4] = "5....2...";
		lines[5] = ".......3.";
		lines[6] = "...54....";
		lines[7] = "3.....42.";
		lines[8] = "...27.6..";
		
		for (int i = 0; i < 9; i++) {
			board[i] = lines[i].toCharArray();
		}
		printBoard(board);
		if (isValidSudoku(board)) {
			printBoard(board);
		}

	}
}
