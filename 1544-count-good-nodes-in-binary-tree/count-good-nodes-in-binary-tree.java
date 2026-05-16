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
    public int fun(TreeNode root, int curr_max) {
        if (root == null) {
            return 0;
        }
        int rootval = 0;
        if (root.val >= curr_max) {
            rootval = 1;
            curr_max = root.val;
        }
        int left_ans = fun(root.left, curr_max);
        int right_ans = fun(root.right, curr_max);
        return left_ans + right_ans + rootval;
    }

    public int goodNodes(TreeNode root) {
        return fun(root, Integer.MIN_VALUE);
    }
}