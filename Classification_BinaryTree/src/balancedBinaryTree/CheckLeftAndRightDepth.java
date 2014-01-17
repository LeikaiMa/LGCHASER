package balancedBinaryTree;
//VII
//这题想了比较长的时间，因为开始想错了，这里的balanced 意思指的是左右两个sub tree的depth 不超过1，这样可以直接从基本定义开始入手
//首先如果是null 肯定就是balanced 然后得到左右两个depth的长度，如果长度差大于1，那么就返回false
//然后看左右是不是都是balanced 如果是都是balanced 就返回true 如果不是，就返回false
//这里用了递归。
//然后算左边和右边的depth 的时候也是用的递归，如果是null 就返回0 ，如果不是就是left child 和 right child 的depth 的大值 +1
//要注意的是求左右的subtree 的depth 的差的时候，要注意求绝对值。因为不知道左边还是右边短。
//如果定义的是所有的leaf 的深度差不超过1.可以参考cracking code 4.1 或者我下面自己写的，我写的是判断child 是不是parent 的2倍，如果不是，就说明这个child 应该是最后一层
//如果child 来了之后还有child 就说明是false
//如果正常出来就是true

//这里要注意的是max 是两个变量输入。自己这个错了几次了。
public class CheckLeftAndRightDepth {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
