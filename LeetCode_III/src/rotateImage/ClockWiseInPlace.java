package rotateImage;
// 和rotate 的方法是一样的，总共要考虑 first last 还有offset 三个变量
public class ClockWiseInPlace {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int  i = first; i < last; i ++) {
				int offset = i- first;
				int tmp = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = tmp;
			}
		}
	}
}
