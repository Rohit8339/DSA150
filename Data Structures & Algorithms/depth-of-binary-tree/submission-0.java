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
    int f(TreeNode root) {
       if(root == null) return 0;
       

        return Math.max(f(root.left), f(root.right)) + 1;
    }
    public int maxDepth(TreeNode root) {

        return f(root);
        
    }
}