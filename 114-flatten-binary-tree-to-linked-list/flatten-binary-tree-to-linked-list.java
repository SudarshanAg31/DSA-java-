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
    public void fun(TreeNode root) {
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            TreeNode temp = root.left;
            TreeNode prv = temp;
            while (prv.right != null) {
                prv = prv.right;
            }
            root.left = null;
            TreeNode temp_right = root.right;
            root.right = temp;
            prv.right = temp_right;
        }
        fun(root.right);
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        fun(root);
    }
}