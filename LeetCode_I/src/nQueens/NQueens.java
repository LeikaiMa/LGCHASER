package nQueens;

import java.util.ArrayList;
import java.util.Arrays;

//因为Queen 的attack 的方法是直线和斜线
//所以每一行只有一个，而且这一列也只能有一个
//采取的方法可以是先将n数全排列，这样可以避免有直线情况下有两个
//然后是在里面去除斜线上有相同的。
//方法是里面存的值的差和他们的index 的差是否相等。因为值代表的是纵坐标，index 代表的是横坐标。

public class NQueens {
	public static int count = 0;

	public static ArrayList<String[]> solveNQueens(int n) {
		count = 0;
		int[] intArray = new int[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = i;
		}
		ArrayList<String[]> results = new ArrayList<String[]>();
		results = permuation(intArray, 0, n - 1, results);
		return results;
	}

	public static void main(String[] args) {
		int n = 8;
		ArrayList<String[]> results = solveNQueens(n);
		System.out.println(count);
		System.out.println(results.size());
		System.out.println(Arrays.toString(results.get(0)));
		System.out.println(Arrays.toString(results.get(1)));

	}

	public static ArrayList<String[]> permuation(int[] intArray, int first,
			int end, ArrayList<String[]> results) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			if (checkQueen(intArray)) {
				// for (int j = 0; j <= end; j++) {
				// System.out.print(str[j]);
				// }
				// System.out.println();
				count++;
				String[] board = loadPiece(intArray);
				results.add(board);
			}
		}

		for (int i = first; i <= end; i++) {
			swap(intArray, i, first);
			results = permuation(intArray, first + 1, end, results); // 固定好当前一位，继续排列后面的
			swap(intArray, i, first);
		}
		return results;
	}

	private static String[] loadPiece(int[] intArray) {
		int n = intArray.length;
		String[] board = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder s = new StringBuilder();
			// s.append("\"");
			for (int j = 0; j < n; j++) {
				if (j == (intArray[i])) {
					s.append("Q");
				} else {
					s.append(".");
				}
			}
			// s.append("\"");
			board[i] = s.toString();
		}
		return board;
	}

	private static boolean checkQueen(int[] str) {
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (((str[j] - str[i]) == (j - i))
						|| ((str[j] - str[i]) == (i - j))) {
					return false;
				}
			}
		}
		return true;
	}

	private static void swap(int[] str, int i, int first) {
		int tmp;
		tmp = str[first];
		str[first] = str[i];
		str[i] = tmp;
	}

	// public static void main(String args[]) throws Exception {
	// // int[] str = {1,2,3};
	// int n = 1;
	// int[] intArray = new int[n];
	// for (int i = 0; i < n; i++) {
	// intArray[i] = i;
	// }
	// // 输出str[0..2]的所有排列方式
	// ArrayList<String[]> results = new ArrayList<>();
	// results = permuation(intArray, 0, n - 1, results);
	// System.out.println(Arrays.toString(results.get(0)));
	// // System.out.println(Arrays.toString(results.get(1)));
	// }

}
