package largestSumMatrix;
// 算整个matrix 里面sum 最大的submatrix， 因为存在正数和负数，所以应该是遍历所有的matrix，然后将里面所有的元素加起来和最大的进行比较。
// 因为有正有负，所有最大的开始定义为integer 最小的。
// 如果没有进行预处理，也就是先定位4个角，然后将这个矩形进行遍历需要N^6.
// 可以先进行预处理，将这个cell 里面存的是左上角到本身的和。 因为是DP 所以从最基础的开始进行计算，也就是左上角开始。
// 然后求sum 的时候可以判断如果是左上角本身，如果是第一列的，就是只加这一列上一格加上自己，如果是第一行，也就是前一格加上本身。 其他的就是上一格和前一格再加上本身减去左上的重复计算的。
// 然后在进行遍历，可以求出所有的四个角所有的情况，然后返回最大值。
// 要注意的是求矩形的求和，下标是最左-1 和最上 - 1
public class DPSum {
	int[][] precomputeMatrix(int[][] matrix) {
		int[][] sumMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					sumMatrix[i][j] = matrix[i][j];
				} else if (j == 0) {
					sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j];
				} else if (i == 0) {
					sumMatrix[i][j] = sumMatrix[i][j - 1] + sumMatrix[i][j];
				} else {
					sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1]
							- sumMatrix[i - 1][j - 1] + sumMatrix[i][j];
				}
			}
		}
		return sumMatrix;
	}

	int getMaxMatrix(int[][] original) {
		int maxArea = Integer.MIN_VALUE;
		int rowCount = original.length;
		int columnCount = original[0].length;
		int[][] matrix = precomputeMatrix(original);
		for (int row1 = 0; row1 < rowCount; row1++) {
			for (int row2 = row1; row2 < rowCount; row2++) {
				for (int col1 = 0; col1 < columnCount; col1++) {
					for (int col2 = 0; col2 < columnCount; col2++) {
						maxArea = Math.max(maxArea,
								computeSum(matrix, row1, row2, col1, col2));
					}
				}
			}
		}
		return maxArea;
	}

	private int computeSum(int[][] sumMatrix, int i1, int i2, int j1, int j2) {
		if (i1 == 0 && j1 == 0) {
			return sumMatrix[i2][j2];
		} else if (i1 == 0) {
			return sumMatrix[i2][j2] - sumMatrix[i2][j1 - 1];
		} else if (j1 == 0) {
			return sumMatrix[i2][j2] - sumMatrix[i1 - 1][j2];
		} else {
			return sumMatrix[i2][j2] - sumMatrix[i2][j1 - 1]
					- sumMatrix[i1 - 1][j2] + sumMatrix[i1 - 1][j1 - 1];
		}
	}
}
