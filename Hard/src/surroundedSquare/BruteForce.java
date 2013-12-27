package surroundedSquare;
// 要检查最大的被黑色包围的正方形。
// 用穷举法来做的可以从最外层最大的开始检查是不是最外围的一层都是黑色。
// 然后逐渐减小，直到1，这些都是这个square 的size
// 然后具体到这个square size 里面，会在整个大的square 里面有几种不同的形式。 可以通过固定一个点，然后看他加上这个size 会不会超过总共的length
// 总共的个数可以用的是length - size + 1
// 然后进行遍历， 遍历的时候检查每一个square 的四条边是不是都是黑色，如果是就返回， 检查完全部如果能够出来就返回null
// 检查每一条边的时候，可以根据起点来进行判断， 总共开始的一条边，还有最后一条边应该是row +  size -1 ， 为了避免重复，可以让row 上面的两条 全部遍历，
// 让column 省掉两个检查两边的两个。
// 这里面值得学习的是row 用的是i 但是 column 用的是j
// 固定好一个然后另一个随着变量的值变化而变化。
public class BruteForce {
	Subsquare findSquare(int[][] matrix) {
		for (int i = matrix.length; i >= 1; i--) {
			Subsquare square = findSquareWithSize(matrix, i);
			if (square != null) {
				return square;
			}
		}
		return null;
	}

	Subsquare findSquareWithSize(int[][] matrix, int squareSize) {
		int count = matrix.length - squareSize + 1;

		for (int row = 0; row < count; row++) {
			for (int col = 0; col < count; col++) {
				if (isSquare(matrix, row, col, squareSize)) {
					return new Subsquare(row, col, squareSize);
				}
			}
		}

		return null;
	}

	boolean isSquare(int[][] matrix, int row, int col, int size) {
		for (int j = 0; j < size; j++) {
			if (matrix[row][col + j] == 1) {
				return false;
			}
			if (matrix[row + size - 1][col + j] == 1) {
				return false;
			}
		}

		for (int i = 1; i < size - 1; i++) {
			if (matrix[row + i][col] == 1) {
				return false;
			}
			if (matrix[row + i][col + size - 1] == 1) {
				return false;
			}
		}
		
		return true;
	}
}
