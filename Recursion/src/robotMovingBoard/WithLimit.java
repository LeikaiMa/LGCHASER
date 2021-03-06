package robotMovingBoard;

import java.util.ArrayList;

public class WithLimit {
//	如果是中间有限制，不能任意执行，一个很好的方法就是一步一步执行。因为此时的一些数学方法不一定可行。
//	同样可以用递归的方法，一步一步倒退到最开始的情况，即base case
//	如果可以的情况下，可以传递一个arraylist 的指针进去，这样可以在做的过程中进行修改。
//	判断结果可以设置一个flag 这样可以进行实施记录，然后返回的值也就可以变成一个。
//	但是递归一个很大的问题，会做重复的计算。 这时候DP可以以空间换时间。将其cache 住
	
	
	private static boolean isFree(int x, int y) {
		return true;
	}
	
	public boolean getPath(int x, int y, ArrayList<Point> path) {
		Point p = new Point(x, y);
		if (x == 0 && y == 0) {
			return true;
		}
		
		boolean success = false;
		if (x >=1 && isFree(x - 1, y)) {
			success = getPath(x-1, y, path);
		}
		
		if (!success && y>=1 && isFree(x, y -1)) {
			success = getPath(x, y, path);
		}
		
		if (success) {
			path.add(p);
		}
		return success;
	}
}
