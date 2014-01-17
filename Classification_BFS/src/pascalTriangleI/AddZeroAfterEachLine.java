package pascalTriangleI;
//VI
//这个的方法就是注意在开始和末尾加上0，这样可以直接在一个循环里做完，不需要额外的处理
//要细心，不同循环的i 和 j 的递增量是不同的。这个不要出错。
//开始的要插入的是1 不是0
import java.util.ArrayList;
//这个只要在后面加，然后是从后面往前走就可以了。不需要加两边。
public class AddZeroAfterEachLine {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        if (numRows == 0) {
            return results;
        }
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        level.add(1);
        
        results.add(new ArrayList<Integer>(level));
        
        for (int i = 1; i < numRows; i++) {
            level.add(0);
            for (int j = level.size() - 1; j > 0; j--) {
                level.set(j, level.get(j) + level.get(j - 1));
            }
            results.add(new ArrayList<Integer>(level));
        }
        
        return results;
    }
}
