package pascalTriangleI;
// 这个的方法就是注意在开始和末尾加上0，这样可以直接在一个循环里做完，不需要额外的处理
// 要细心，不同循环的i 和 j 的递增量是不同的。这个不要出错。
// 开始的要插入的是1 不是0
import java.util.ArrayList;

public class AddZeroToTwoEnd {
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return lines;
		}

		ArrayList<Integer> line = new ArrayList<Integer>();
		line.add(1);
		lines.add(new ArrayList<Integer>(line));
		for (int i = 1; i < numRows; i++) {
			line.add(0);
			line.add(0, 0);
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int j = 1; j < line.size(); j++) {
				tmp.add(line.get(j) + line.get(j - 1));
			}

			lines.add(new ArrayList<Integer>(tmp));
			line = tmp;
		}
		return lines;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
		lines =  generate(3);
		for (ArrayList<Integer> line : lines) {
			System.out.println(line);
		}
	}
}
