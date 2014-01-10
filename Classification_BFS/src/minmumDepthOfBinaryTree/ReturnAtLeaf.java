package minmumDepthOfBinaryTree;
// 这个是和max 差不多，但是只要有一个到了leaf 就可以返回了。
// leaf 的条件是左右两个child 都是null
import java.util.ArrayList;

public class ReturnAtLeaf {
    public int minDepth(TreeNode root) {
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
                
                if (node.left == null && node.right == null) {
                    return depth;
                }
                
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
