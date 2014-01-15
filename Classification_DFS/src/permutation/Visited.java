package permutation;
//V
//这个是用DFS 进行排序，从前开始遍历，每个情况进行DFS，因为是DFS，所以是执行完了才做后面的，而且用了visited 进行标记，这样就不会有将之前已经遍历过的元素再重新遍历一遍。
//通过step 来看有没有遍历完。
//进去之前标记好，出来之后visited 取消标记，arraylist 也取消塞入。
//这里用到了remove 和生成的时候直接用constructor 的方法，省掉用addAll 使得代码更加简洁。
import java.util.ArrayList;
import java.util.Arrays;
//自己做的时候忘记了将result里面值remove 掉。这个以后要避免。
public class Visited {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return results;
        }
        Arrays.sort(num);
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        helper(results, result, num, visited);
        
        return results;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int[] num, boolean[] visited) {
        if (result.size() == num.length) {
            results.add(new ArrayList<Integer>(result));
        } else {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result.add(num[i]);
                    helper(results, result, num, visited);
                    result.remove(result.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
