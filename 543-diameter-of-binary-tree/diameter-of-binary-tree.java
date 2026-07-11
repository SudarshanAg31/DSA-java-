class Solution {
    static int max = 0;

    public int temp(TreeNode root) {
        if (root == null)
            return 0;
        int left = temp(root.left);
        int right = temp(root.right);
        int height = left + right;
        max = Math.max(height, max);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        temp(root);
        return max;
    }
}