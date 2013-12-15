package setZero;
// 有时候不需要每次找到一个就去完成，如果很多事情做同样的事情，可以先暂时存在统一位置，然后按照这些统一位置一起执行。
// 如果是两者true 只要一个成立就执行，就用|| 来执行。
public class SetZero {
	public void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
