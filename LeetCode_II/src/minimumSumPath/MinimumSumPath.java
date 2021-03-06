package minimumSumPath;
// 求左上角到右下角的最短路径，原本可以用shortest path 来进行求解，但是设计比较复杂。
// 分析这个的数组的实际规律，可以看出每个spot 实际的路线只有两种，一种是左边，一种是下边，只要得到从左边或者下边距离最开始的点最近的点就可以知道这个到底最短的从哪里开始
// 但是要求要从最近的那一点出发，可以看出每一条斜线是类似于同一级的，只有这一级全部算完，后面一级才计算准确。
// 所以利用这个性质，最后一个角上的肯定是行和列加起来最大的，所以利用这个性质做为第一个循环的边界条件，
// 第二层循环就是要遍历这一层的所有的spot，可以通过行数或者列数来判断，但是要注意的是，肯能斜线没有完全穿过整个列或者是已经超出这个列，所以在循环的判断条件上要加这个条件
// 还有就是也有可能超过这一行了，这时候也要进行注意，这个是为什么这边用一个continue 的原因。
// 然后最后只需要范hi最角上的那个spot 里面计算好的数就可以了
// 这个应该算shortest 一个简化版
public class MinimumSumPath {
	public static int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int row = grid.length;
		int column = grid[0].length;
		for (int i = 1; i <= row + column - 2; i++) {
			for (int j = 0; j <= Math.min(row-1, i); j++) {
				if (i - j > column - 1) {
					continue;
				}
				if (i - j - 1 >= 0 && j - 1 >= 0) {
					grid[j][i - j] += Math.min(grid[j][i - j - 1],
							grid[j - 1][i - j]);
				} else if (i - j - 1 >= 0) {
					grid[j][i - j] += grid[j][i - j - 1];
				} else {
					grid[j][i - j] += grid[j - 1][i - j];
				}
			}
		}
		return grid[row - 1][column - 1];
	}

	public static void main(String[] args) {
		 int[][] grid = new int[2][2];
		 grid[0][0] = 1;
		 grid[0][1] = 2;
		 grid[1][0] = 3;
		 grid[1][1] = 4;
//		int[][] grid = new int[3][3];
//		grid[0][0] = 1;
//		grid[0][1] = 3;
//		grid[0][2] = 1;
//		grid[1][0] = 1;
//		grid[1][1] = 5;
//		grid[1][2] = 1;
//		grid[2][0] = 4;
//		grid[2][1] = 2;
//		grid[2][2] = 1;
		int shortest;
		shortest = minPathSum(grid);
		System.out.println(shortest);
	}
}
