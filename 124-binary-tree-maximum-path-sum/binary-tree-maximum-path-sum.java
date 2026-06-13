class Solution {
    static int max = Integer.MIN_VALUE;

    public int fun(TreeNode root) {
        if (root == null)
            return 0;
        int left = fun(root.left);
        int right = fun(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        max = Math.max(max, (left + right + root.val));
        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        fun(root);
        return max;
    }
}