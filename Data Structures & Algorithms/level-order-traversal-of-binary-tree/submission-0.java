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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root!=null) qu.add(root);
        
        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size;i++) {
                TreeNode curr = qu.poll();
                l.add(curr.val);
                if (curr.left!=null) qu.add(curr.left);
                if (curr.right!=null) qu.add(curr.right);
            }
            list.add(l);
        }
        return list;
    }
    
}
