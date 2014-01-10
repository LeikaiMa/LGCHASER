package maximumDepthOfBinaryTree;
//III
//找最深的depth 就是要用类似于BFS的方法，用一个QUEUE 来统一存一层的node
//然后存下一层的，进行交换，直到空。
//返回的循环次数就是depth
import java.util.ArrayList;

public class ReturnAtFinal {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        int depth = 0;
        level.add(root);
        
        while (!level.isEmpty()) {
            depth++;
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            
            level = tmp;
        }
        
        return depth;
        
    }
}
