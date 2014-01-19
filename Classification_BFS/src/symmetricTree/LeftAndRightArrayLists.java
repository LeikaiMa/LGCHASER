package symmetricTree;

import java.util.ArrayList;

//VII
//这个还是一个典型的level travel的 题目，要注意的是null 的是算作对称，然后要考虑清楚各种情况，左右都有左右都没有
//一个有一个没有。然后将左右分别塞进arraylist 里面。
//这里面要注意扫描的顺序，开始误认为一个是正数一个是反着数，
//实际写的时候发现，因为左边是先放left 后right 而右边是先right 后left 反而最开始的时候两个都是正着数就可以了
//在里面的就是要注意五种情况，都有不同，都有相同，一个有一个没有的两种，两个都么有（这个是跳过忽略）
//其他的就是里面left 和right 要小心操作就好
public class LeftAndRightArrayLists {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            return true;
        }
        
        if (root.left == null || root.right == null || root.left.val != root.right.val) {
            return false;
        }
        
        ArrayList<TreeNode> left = new ArrayList<TreeNode>();
        ArrayList<TreeNode> right = new ArrayList<TreeNode>();
        
        left.add(root.left);
        right.add(root.right);
        
        while (!left.isEmpty() && !right.isEmpty()) {
            int len = left.size();
            
            ArrayList<TreeNode> tLeft = new ArrayList<TreeNode>();
            ArrayList<TreeNode> tRight = new ArrayList<TreeNode>();
            
            for (int i = 0; i < len; i++) {
                TreeNode l = left.get(i);
                TreeNode r = right.get(i);
                
                if (l.left != null && r.right != null && l.left.val == r.right.val) {
                    tLeft.add(l.left);
                    tRight.add(r.right);
                } else if (l.left != null && r.right != null && l.left.val != r.right.val) {
                    return false;
                } else if ((l.left != null && r.right == null) || (l.left == null && r.right != null)) {
                    return false;
                }
                
                if (l.right != null && r.left != null && l.right.val == r.left.val) {
                    tLeft.add(l.right);
                    tRight.add(r.left);
                } else if (l.right != null && r.left != null && l.right.val != r.left.val) {
                    return false;
                } else if ((l.right != null && r.left == null) || (l.right == null && r.left != null)) {
                    return false;
                }
            }
            
            left = tLeft;
            right = tRight;
        }
        
        return true;
    }
}
