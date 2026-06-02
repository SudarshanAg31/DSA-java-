class Solution {
    static int sum = 0;

    public void fun(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += root.val;
            root.val = sum;
            return;
        }
        fun(root.right);
        sum += root.val;
        root.val = sum;
        fun(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        fun(root);
        return root;
    }
}