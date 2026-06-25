/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        return isValid(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, int low, int high) {
        if (root==null) return true;
        boolean isVal = root.val > low && root.val < high;
        if (root.right!=null&&root.left!=null) return isVal && isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
        else if (root.right==null) return isVal && isValid(root.left, low, root.val);
        else return isVal && isValid(root.right, root.val, high);
    }
}
