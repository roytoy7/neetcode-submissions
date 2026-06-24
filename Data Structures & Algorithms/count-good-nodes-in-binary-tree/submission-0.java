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
    public int goodNodes(TreeNode root) {
        return countGood(root, root.val);
    } public int countGood(TreeNode root, int max) {
        if (root==null) return 0;
        int add = max<=root.val ? 1 : 0;
        max = Math.max(root.val, max);
        return add + countGood(root.right, max) + countGood(root.left, max);
    }
}
