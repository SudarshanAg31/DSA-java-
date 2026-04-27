class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return fun(root, min, max);
    }

    public boolean fun(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return fun(root.left, min, root.val) && fun(root.right, root.val, max);
    }
}