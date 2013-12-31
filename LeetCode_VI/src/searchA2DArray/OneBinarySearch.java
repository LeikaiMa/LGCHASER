package searchA2DArray;
// 这个利用的是将整个二维数组变成一维数组，然后将index 转换为所对应的 row 和column 然后进行同样的比较
public class OneBinarySearch {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int row = matrix.length;
		int column = matrix[0].length;
		if (column == 0) {
			return false;
		}

		int low = 0;
		int high = row * column - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid / column][mid % column] == target) {
				return true;
			} else if (matrix[mid / column][mid % column] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
