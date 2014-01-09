package binaryTreeInorderTraversal;
//对于要iteration而不用recursion的方法，一种很常见的就是用STACK 或者是QUEUE 来预先存储。类似于BFS之类的，然后用while 进行循环处理。
//无论是怎么样的排序按照排序的规则往里面存，然后取出来的规则就可以区分到底用的是stack 还是用的是Queue。
//然后用标记到底如何的方法，目前有两种，一种是建一个wrapper 的class ，然后存除了本身之外的第二个参量。
//或者用的是本题采用的方法，两个统一步骤的数据结构，这样也可以达到同样的效果。
import java.util.ArrayList;
import java.util.Stack;
// 这里要注意的stack 后面写的时候要加();
public class TwoStacks {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<Boolean> visited = new Stack<Boolean>();
        
        nodes.push(root);
        visited.push(false);
        
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            boolean hasVisited = visited.pop();
            if (hasVisited) {
                results.add(node.val);
            } else {
                if (node.right != null) {
                    nodes.push(node.right);
                    visited.push(false);
                }
                nodes.push(node);
                visited.push(true);
                if (node.left != null) {
                    nodes.push(node.left);
                    visited.push(false);
                }
            }
        }
        
        return results;
     }
}
