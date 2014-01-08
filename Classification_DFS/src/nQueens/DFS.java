package nQueens;
//I - 10
//因为Queen 的attack 的方法是直线和斜线
//所以每一行只有一个，而且这一列也只能有一个
//采取的方法可以是先将n数全排列，这样可以避免有直线情况下有两个
//然后是在里面去除斜线上有相同的。
//方法是里面存的值的差和他们的index 的差是否相等。因为值代表的是纵坐标，index 代表的是横坐标。
import java.util.ArrayList;
import java.util.Arrays;
// 这里用DFS的方法来进行而不是直接先将所有的可能排列得到，这里面要注意的是当里面是-1的时候，将里面值换成想要的值，然后判断斜着的是不是有在一条直线上的
// 如果有直接不进行后面的，将其还原，在填下一个类似于做一个permutation。
public class DFS {
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> results = new ArrayList<String[]>();
        if (n <= 0) {
            return results;
        }
        
        int[] columns = new int[n];
        
        for (int i = 0; i < n; i++) {
            columns[i] = -1;
        }
        
        solveNQueensHelper(results, columns, 0);
        
        return results;
    }
    
    public static void solveNQueensHelper(ArrayList<String[]> results, int[] columns, int line) {
        if (line == columns.length) {
            String[] board = new String[line];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < line; i++) {
                sb.append('.');
            }
            
            for (int i = 0; i < line; i++) {
                sb.setCharAt(columns[i], 'Q');
                board[i] = sb.toString();
                sb.setCharAt(columns[i], '.');
            }
            
            results.add(board);
        } else {
            for (int i = 0; i < columns.length; i++) {
                if (columns[i] == -1) {
                    columns[i] = line;
                    if (check(columns, i)) {
                        solveNQueensHelper(results, columns, line + 1);
                    }
                    columns[i] = -1;
                }
            }
        }
    }
    
    private static boolean check(int[] columns, int i) {
        for (int j = 0; j < columns.length; j++) {
            if (columns[j] != -1 && i != j && Math.abs(i - j) == Math.abs(columns[i] - columns[j])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		int n = 1;
		ArrayList<String[]> results = solveNQueens(n);
//		System.out.println(count);
		System.out.println(results.size());
		System.out.println(Arrays.toString(results.get(0)));
//		System.out.println(Arrays.toString(results.get(1)));

	}
}
