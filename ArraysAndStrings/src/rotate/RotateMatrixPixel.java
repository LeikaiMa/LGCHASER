package rotate;
// 将整个90度旋转，可以按照由外到内一层一层进行旋转。
// layer 可以分成n/2层
// 里面针对上下左右不同的方向，不同的遍历，一次可以通过坐标之间的关系通过一个中间的变量移动4个。
// 里面用到两个坐标，一个是first一个是last 这些坐标是为了控制要转换的位置的坐标。

public class RotateMatrixPixel {
	public void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
}
