package pascalTriangleII;
// 除了这个两边加0 的方法,还有一个只用常数空间的方法。
import java.util.ArrayList;

public class AddZeroToTwoEnd {
	public  static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		if (rowIndex == -1) {
			return row;
		}
		row.add(1);
		for (int i = 1; i < rowIndex + 1; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			row.add(0);
			row.add(0, 0);
			for (int j = 1; j < row.size(); j++) {
				tmp.add(row.get(j) + row.get(j - 1));
			}
			row = tmp;
		}
		
		return row;
	}
	
	public static void main(String[] args) {
		System.out.println(getRow(1));
	}
}
