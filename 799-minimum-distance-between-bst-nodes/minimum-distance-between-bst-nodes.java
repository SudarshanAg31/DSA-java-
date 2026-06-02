class Solution {
    static int def = Integer.MAX_VALUE;
    static TreeNode temp = null;

    public void fun(TreeNode root) {
        if (root == null)
            return;
        fun(root.left);
        if (temp == null)
            temp = root;
        else {
            if (def > Math.abs(root.val - temp.val)) {
                def = Math.abs(root.val - temp.val);
            }
            temp = root;
        }
        fun(root.right);

    }

    public int minDiffInBST(TreeNode root) {
        def = Integer.MAX_VALUE;
        temp = null;
        fun(root);
        return def;
    }
}