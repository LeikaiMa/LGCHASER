package setZeros;

public class MatrixZeros {
	public void setZeroes(int[][] matrix) {
		int nr = matrix.length;
		int nc = matrix[0].length;
		boolean[] rows = new boolean[nr];
		boolean[] columns = new boolean[nc];

		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (rows[i] || columns[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
