package placeQueens;
// 在棋盘上放棋子，思路是一行一行放，然后check 这个放在这里是不是valid， 如果不行就直接跳过，如果可以检查在这个基础上下一行应该放的棋子。
// 因为是一行一行check 所以可以用递归。base case 是当行数到达最后一行，因为是从0开始，所以只要考虑是否是row 到 size 就可以了。
// 把答案加到list 里面需要用clone 新建一个，不然其他的步骤就要改变里面的内容。
// 在check 的时候因为肯定不在一行，所以check 只需check 是否是一列，然后是否在对角线上。
// 要判断的棋子是以前已经放上去的，可以一个一个check 用一个for 循环。 check 对角线是看 列差和行差是不是相同，列差可能是有负数，所以要加绝对值。
// 行差肯定是大小确定，所以不需要加绝对值。
// 然后这个check 的本质是只有前面的条件满足才会返回true。 前面类似流水线上的把关口，如果不行就直接返回false。 全部过了才会返回true。
import java.util.ArrayList;

public class Queens {
	int GRID_SIZE = 8;
	public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}
	
	public boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) {
				return false;
			}
			
			int columnDistance = Math.abs(column2 - column1);
			
			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		
		return true;
	}
}
