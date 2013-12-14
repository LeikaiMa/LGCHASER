package findElementInMatrix;
// 用到了排除法来解决问题。依次过滤掉不符合的行列的元素。
// 考虑到数组的结构形式，从行来看依次增大，从列来看依次增大。
// 要充分利用判断条件，因为只有== 的时候才是返回，
// 所以有> < 两种不同的条件，所以可以到移到第一行的最后一列。
// 如果太大左移，如果太小上移。这样的话，可以遍历到整个matrix 从而判断是否有值得到。
// 看列数用matrix[0].length
public class Elimination {
	public static boolean findElement(int[][] matrix, int elem) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length &&  col >= 0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
