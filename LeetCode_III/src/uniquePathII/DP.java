package uniquePathII;
// 由于有相应的障碍所以和之前没有障碍的要多处理一些步骤，如果只有一行或者一列，不能直接判断是否是可行，要看里面有没有障碍
// 如果起点和终点就有障碍，就直接返回0
// 因为障碍是1 和次数有关系，所以改成不可能存在的-1作为区别。
// 然后将第一行第一列都换成1，但是要注意的是如果里面有-1存在可以直接跳出不用变成1
// 然后还是依次逐行遍历，如果本身是-1 就要直接避开，如果左下是-1 就不要加到方法里面去。
// 最后返回的是最后一行一列的里面的内容
public class DP {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0) {
			return 0;
		}
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][column - 1] == 1) {
			return 0;
		}
		if (row == 1) {
			for (int c = 0; c < column; c++) {
				if (obstacleGrid[row - 1][c] == 1) {
					return 0;
				}
			}
			return 1;
		}

		if (column == 1) {
			for (int r = 0; r < row; r++) {
				if (obstacleGrid[r][column - 1] == 1) {
					return 0;
				}
			}
			return 1;
		}

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				if (obstacleGrid[r][c] == 1) {
					obstacleGrid[r][c] = -1;
				}
			}
		}
		int n = 1;
		for (int r = 0; r < row; r++) {

			if (obstacleGrid[r][0] == -1) {
//				n = 0;
				break;
			} 
//			else {
				obstacleGrid[r][0] = n;
//			}
		}
//		n = 1;
		for (int c = 0; c < column; c++) {
			if (obstacleGrid[0][c] == -1) {
//				n = 0;
				break;
			} 
//			else {
				obstacleGrid[0][c] = n;
//			}
		}

		for (int r = 1; r < row; r++) {
			for (int c = 1; c < column; c++) {
				if (obstacleGrid[r][c] == -1) {
					continue;
				}
				if (obstacleGrid[r - 1][c] != -1) {
					obstacleGrid[r][c] += obstacleGrid[r - 1][c];
				}
				if (obstacleGrid[r][c - 1] != -1) {
					obstacleGrid[r][c] += obstacleGrid[r][c - 1];
				}
			}
		}

		return obstacleGrid[row - 1][column - 1];
	}
}
