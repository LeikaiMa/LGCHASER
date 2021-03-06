package sudoku;

import java.util.Arrays;
import java.util.HashSet;

public class Example {
	  public boolean isValidSudoku(char[][] board) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (board.length == 0) return false;
	        if (board.length % 3 != 0) return false;
	        if (board[0].length != board.length) return false;
	        // check length of each row
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 1; j < board[0].length; j++) {
	                if (board[j].length != board[0].length) return false;
	            }
	        }
	         
	        int len = board.length;
	        for (int i = 0; i < len; i++) {
	            HashSet<Character> set1 = new HashSet<Character>();
	            HashSet<Character> set2 = new HashSet<Character>();
	            for (int j = 0; j < len; j++) {
	                char c1 = board[i][j];
	                if (c1 == '.') {}
	                else if (c1 >= '1' && c1 <= '9') {
	                    if (set1.contains(c1)) {
	                        return false;
	                    }
	                    set1.add(c1);
	                }
	                else { return false; }
	                char c2 = board[j][i];
	                if (c2 == '.') {}
	                else if (c2 >= '1' && c2 <= '9') {
	                    if (set2.contains(c2)) {
	                        return false;
	                    }
	                    set2.add(c2);
	                }
	                else { return false; }
	            }
	        }
	         
	        int len_3 = len / 3;
	         
	        for (int i = 0; i < len_3; i++) {
	            for (int j = 0; j < len_3; j++) {
	                HashSet<Character> set = new HashSet<Character>();
	                for (int x = 0; x < 3; x++) {
	                    for (int y = 0; y < 3; y++) {
	                         
	                        char c = board[i*3+x][j*3+y];
	                        if (c == '.') {}
	                        else if (c >= '1' && c <= '9') {
	                            if (set.contains(c)) {
	                                return false;
	                            }
	                            set.add(c);
	                        }
	                        else { return false; }
	                    }
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

		lines[0] = "..4...63.";
		lines[1] = ".........";
		lines[2] = "5......9.";
		lines[3] = "...56....";
		lines[4] = "4.3.....1";
		lines[5] = "...7.....";
		lines[6] = "...5.....";
		lines[7] = ".........";
		lines[8] = ".........";

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
		// lines[0] = ".87654321";
		// lines[1] = "2........";
		// lines[2] = "3........";
		// lines[3] = "4........";
		// lines[4] = "5........";
		// lines[5] = "6........";
		// lines[6] = "7........";
		// lines[7] = "8........";
		// lines[8] = "9........";
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
