package searchA2DArray;
// 这题虽然最后的做法复杂度比较少，只有logm + logn 但是思路比较复杂，
// 当时考虑的情况是看最后一列的情况，找>= 最小值，然后在这个列里面去找，因为上一行的最后一个是比他要小的，这行最后一个是>= 的，那么自己肯定是在这一行里
// 如果这一行没有的话，那么就不会存在。
// 找>= 的情况，如果是是 < 说明在右边，那么low 就是mid +1如果是>= 就让high 变成mid 出来low 就是 >= 的最小值。
// 在这里面再进行二分法查值。
public class BinarySearch {
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
		int high = row - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid][column - 1] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		int r = low;

		low = 0;
		high = column - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (matrix[r][mid] == target) {
				return true;
			} else if (matrix[r][mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 3;
		System.out.println(searchMatrix(matrix, target) == true);
		target = 16;
		System.out.println(searchMatrix(matrix, target) == true);
		target = 51;
		System.out.println(searchMatrix(matrix, target) == false);
		int [][] mat = {{1}};
		target = 1;
		System.out.println(searchMatrix(mat, target) == true);
	}
	
}
