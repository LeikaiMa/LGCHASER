package spiralMatrix;

import java.util.ArrayList;
// 按照螺旋式输出值，可以不像旋转一样，可以按照螺旋式的一层一层的遍历。
// 设置4个参量，左右上下，作为边界。
// 首先是底部横着，然后是右边竖着，但是要将第一个去掉。
// 然后是顶部倒着横着，也要去掉第一个，最后是左边的竖着倒着，要去掉第一个和最后一个。
// 但是要注意的是，首先要判断matrix 是不是存在。
// 其次要判断的是如果是top 和 bottom 相等 right 和left 相等就只能输出一个。所以在第三个和第四个的循环当中就多了一个判断条件。
// while 循环的时候要记得计数器等等每次循环时候要+1 或者-1
public class NotEqualRowColumn {
	public static ArrayList<Character> spiralOrder(char[][] matrix) {
		ArrayList<Character> result = new ArrayList<Character>();
		if (matrix == null) {
			return result;
		}
		int row = matrix.length;
		if (row == 0) {
		    return result;
		}
		int column = matrix[0].length;
		int left = 0;
		int right = column - 1;
		int bottom = 0;
		int top = row - 1;
		while (true) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[bottom][i]);
			}

			for (int i = bottom + 1; i <= top; i++) {
				result.add(matrix[i][right]);
			}

			for (int i = right - 1; top > bottom && i >= left; i--) {
				result.add(matrix[top][i]);
			}

			for (int i = top - 1; right > left && i > bottom; i--) {
				result.add(matrix[i][left]);
			}
			left++;
			right--;
			bottom++;
			top--;

			if (result.size() == row * column) {
				System.out.println(result);
				return result;
			}
		}
	}

	public static void main(String[] args) {
		// char[][] matrix = new char[2][3];
		// String[] lines = new String[2];
		// lines[0] = "123";
		// lines[1] = "456";
		// for (int i = 0; i < 2; i++) {
		// matrix[i] = lines[i].toCharArray();
		// }
		// spiralOrder(matrix);

		char[][] matrix = new char[2][1];
		String[] lines = new String[2];
		lines[0] = "2";
		 lines[1] = "5";
		// lines[2] = "9012";
		// lines[3] = "3456";
		for (int i = 0; i < 2; i++) {
			matrix[i] = lines[i].toCharArray();
		}
		spiralOrder(matrix);
	}
}
