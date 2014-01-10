package convertSortedArrayToBinarySearchTree;
//III
//中间的作为root 其他的放在两边依次进行递归。返回的值是root 然后就形成一个BST

public class Recursive {
	public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        
        return helper(num, 0, num.length - 1);
    }
    
    private TreeNode helper(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, start, mid - 1);
        root.right = helper(num, mid + 1, end);
        
        return root;
    }
}
