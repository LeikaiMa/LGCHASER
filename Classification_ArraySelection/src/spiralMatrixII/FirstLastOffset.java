package spiralMatrixII;
// II
//matrix 的旋转，实际上简单来讲是和rotate 那个差不多，
//由外向内， 一层一层推进，每层表示0  到 n/2 前闭后闭，然后在每一层分成四个边，每个边因为连续所以有固定的间隔
//主要的是要看first 和 last 这样又意义的参量便于后面的计算。
//first 就是layer
//last 就是最后一个 n-1-layer
//然后每条边每一隔依次进行遍历，但不包括last 这样就四条边同时进行，
//为了便于计算加上一个offset 为了便于last 也可以移动 意义代表的是i 和first 的距离，也就是移动了多少
//下是 first i （固定row）右 是 i last （固定column）上是 last last-offset 因为是倒着进行，固定row 左 是 last -offset first 也是因为是倒着进行，固定column
//这里要考虑到如果是奇数，最中间单个的是不会被执行，因为first 和 last 相等，但是遍历的时候又是 first 到last -1
//需要单独处理
//最开始的时候如果是0 需要新建之后要直接返回。
//在里面loop 的时候count 要随时+1 然后在loop 之外要直接+ 3 *（last- first）
public class FirstLastOffset {
	public int[][] generateMatrix(int n) {
		int num = 1;
		int[][] matrix = new int[n][n];

		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; i++) {
				int offset = i - first;
				matrix[first][i] = num;
				matrix[i][last] = num + (last - first);
				matrix[last][last - offset] = num + 2 * (last - first);
				matrix[last - offset][first] = num + 3 * (last - first);
				num++;
			}

			num = num + 3 * (last - first);
		}

		if (n % 2 == 1) {
			matrix[n / 2][n / 2] = num;
		}

		return matrix;
	}
}
