package spiralMatrix;

import java.util.ArrayList;

public class SpiralOrder {
	public static ArrayList<Character> spiralOrder(char[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		
		char[] r = new char[row * column];

		int n = row;
		int count = 0;
		for (int layer = 0; layer <= n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
//				System.out.println("offset:" + offset);
//				System.out
//						.println("index:" + count + " content: "
//								+ matrix[first][i] + " row: " + first
//								+ " column: " + i);
//				System.out.println("index:" + (count + n - 1) + " content: "
//						+ matrix[i][last] + " row: " + i + " column: " + last);
//				System.out.println("index:" + (count + 2 * (n - 1))
//						+ " content: " + matrix[last][last - offset] + " row: "
//						+ last + " column: " + (last - offset));
//				System.out.println("index:" + (count + 3 * (n - 1))
//						+ " content: " + matrix[last - offset][i-offset] + " row: "
//						+ (last - offset) + " column: " + (i-offset));
				r[count] = matrix[first][i];
				r[count + last - first] = matrix[i][last];
				r[count + 2 * (last - first)] = matrix[last][last - offset];
				r[count + 3 * (last - first)] = matrix[last - offset][first];
				
				count++;
			}
			count = count + 3 * (n - 1);
		}
		if (n%2 == 1) {
			r[count] = matrix[n/2][n/2];
		}
//		System.out.println(Arrays.toString(r));
		ArrayList<Character> result = new ArrayList<Character>();
		for (char c : r) {
			result.add(c);
		}
		
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		char[][] matrix = new char[4][4];
		String[] lines = new String[4];
		lines[0] = "1234";
		lines[1] = "5678";
		lines[2] = "9012";
		lines[3] = "3456";
		for (int i = 0; i < 4; i++) {
			matrix[i] = lines[i].toCharArray();
		}
		spiralOrder(matrix);
	}
}
