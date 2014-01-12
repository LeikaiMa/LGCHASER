package uniquePathsII;
//III
//由于有相应的障碍所以和之前没有障碍的要多处理一些步骤，如果只有一行或者一列，不能直接判断是否是可行，要看里面有没有障碍
//如果起点和终点就有障碍，就直接返回0
//因为障碍是1 和次数有关系，所以改成不可能存在的-1作为区别。
//然后将第一行第一列都换成1，但是要注意的是如果里面有-1存在可以直接跳出不用变成1
//然后还是依次逐行遍历，如果本身是-1 就要直接避开，如果左下是-1 就不要加到方法里面去。
//最后返回的是最后一行一列的里面的内容

//这里优化减少的是开始将第一行扫一遍，如果是0 就填1 如果是1从这个开始都填0 所以用一个值记录
//然后看第一列的，这个时候因为第一个值被覆盖了，所以直接看第一个是1 的话就说明可以走，那么记录的就是从1 开始，否则是从0 开始，如果后面有1 的话就将这个置为0 
//和第一行一样填，
//然后是其他行和列，如果是1 有障碍就是填0 其他的都是看左边和上面的个数的和。
//最后看最后一个格子统计的。
public class TopAndLeftDeleteObstacle {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;

		int way = 1;

		for (int j = 0; j < column; j++) {
			if (obstacleGrid[0][j] == 1) {
				way = 0;
			}
			obstacleGrid[0][j] = way;
		}

		way = obstacleGrid[0][0];
		for (int i = 1; i < row; i++) {
			if (obstacleGrid[i][0] == 1) {
				way = 0;
			}
			obstacleGrid[i][0] = way;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j]
							+ obstacleGrid[i][j - 1];
				}
			}
		}

		return obstacleGrid[row - 1][column - 1];
	}
}
