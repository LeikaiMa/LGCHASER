package largestSumMatrix;
// 因为可以联想到一行可以用O(n)的效率，因为默认不能低于0，所以相加后如果还小于0 就没有意义，所以一旦遇到这个情况就可以reset 为0.这样横着就可以得到最大。
// 利用这个性质可以将O（n^4）降到O (n^3) 
// 建一个rowStart 和 row End 这样是遍历所有的row 的 集合。 然后每一列都直接进行相加，相当于多行合成一行。然后直接进入辅助函数，看这样row start 到 row end最大的值是多少
// 因为两个n 是依次执行所以没有增加复杂度。
public class EvolveFromLine {
	public static void clearArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}

	public static int maxSubMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		int[] partialSum = new int[colCount];
		int maxSum = 0;

		for (int rowStart = 0; rowStart < rowCount; rowStart++) {
			clearArray(partialSum);
			
			for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
				for (int i = 0; i < colCount; i++) {
					partialSum[i] += matrix[rowEnd][i];
				}
				
				int tempMaxSum = maxSubArray(partialSum, colCount);
				
				maxSum = Math.max(maxSum, tempMaxSum);
			}
		}
		return maxSum;
	}
	
	public static int maxSubArray(int array[], int N) {
		int maxSum = 0;
		int runningSum = 0;
		
		for (int i = 0; i < N; i++) {
			runningSum += array[i];
			maxSum = Math.max(maxSum, runningSum);
			
			if (runningSum < 0) {
				runningSum = 0;
			}
		}
		return maxSum;
	}
}
