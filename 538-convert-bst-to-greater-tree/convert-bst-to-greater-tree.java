class Solution {
    static int sum = 0;

    public void fun(TreeNode root) {
        if (root == null)
            return;
        fun(root.right);
        root.val += sum;
        sum = root.val;
        fun(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        fun(root);
        return root;
    }
}