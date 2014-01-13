package pathSumII;
//IV
//这个同样是用的DFS 来进行解决，不过因为要写路径，所以要返回具体的路径，每次都插在最前面。
//最后的node 的时候，如果是就加进去，如果不是就返回一个空的
//在上一层如果不是空的就将自己加进去这个arraylist，因为从后向前就只有一个，不会有重复，所以就不需要deep copy 出来。
//最后返回helper 函数里面返回的结果。
import java.util.ArrayList;
//这里面没有用返回的情况，而是直接用的是DFS然后回来之前把自己最后一个给删掉。
public class CheckLeftAndRightSeparately {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        helper(root, 0, sum, results, result);
        return results;
    }
    
    public void helper(TreeNode root, int s, int sum, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result) {
        if (root == null) {
            return; 
        }
        
        s += root.val;
        result.add(root.val);
        if (root.left == null && root.right == null) {
            if (s == sum) {
                results.add(new ArrayList<Integer>(result));
            }
        } 
        
        if (root.left != null) {
            helper(root.left, s, sum, results, result);
        }
        
        if (root.right != null) {
            helper(root.right, s, sum, results, result);
        }
        
        result.remove(result.size() - 1);
        
    }
}
