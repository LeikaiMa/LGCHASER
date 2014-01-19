package validBinarySearchTree;
//VII
//检查一个Tree 是不是BST。开始的时候没有深刻理解，不仅仅是要比较这个值是不是左边比root 小，右边比root 大
//而是有个范围，left child's right child 要比root 也要小，这个时候就要将整个范围也要传递进去。
//开始的时候root 没有boundary 所以是最小值和最大值为两边的边界。
//如果是是null 肯定就是
//如果不是就开始判断里面的child 如果不是null ，他的值是不是再范围里面，左边要在左边界和root 之间，右边在root 和右边界之间。
//如果不是就直接返回。线比较值，不进行dfs 有效的能够剪枝
//然后将左和右的child 判断是不是有效的。
//左边的右边界就变成了root 
//右边的左边界就变成了root
//如果都过了就返回true

//不需要单独判断是不是null 只需要送到下一层就可以了。因为是null 会直接返回true
public class WithinBoundary {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, int lB, int rB) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= lB || root.val >= rB) {
            return false;
        }
        
        if (!helper(root.left, lB, root.val) || !helper(root.right, root.val, rB)) {
            return false;
        }
        
        return true;
    }
}
