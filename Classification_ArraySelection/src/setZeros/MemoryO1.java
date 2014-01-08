package setZeros;
// 这个是用memory O1的方法进行存储，如果是memory 是要O1的情况一种是利用有限个变量，还有一个就是用本身的空间。
// 这个时候就用的自己的第一行和第一列的空间，先将这一行这一列扫一遍，看看有没有0，如果有就标记。
// 然后看里面有没有0如果有就将对应的行或者是列 在第一行标记为0，然后再进行一遍，如果看到对应的行或者是列上面是0 就将这个格子置为0
// 最后如果第一行或者是第一列的flag 是有就将这一行或者是这一列标记为0
// 要注意的是开始的时候boolean 最好也要进行初始化。
public class MemoryO1 {
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		boolean hasZeroFR = false, hasZeroFC = false;

		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				hasZeroFC = true;
				break;
			}
		}

		for (int j = 0; j < column; j++) {
			if (matrix[0][j] == 0) {
				hasZeroFR = true;
				break;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (hasZeroFC) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}

		if (hasZeroFR) {
			for (int j = 0; j < column; j++) {
				matrix[0][j] = 0;
			}
		}
	}
}
