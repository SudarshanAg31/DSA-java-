class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode root_left = root.left;
        TreeNode root_right = root.right;
        if (root.left != null) {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            root.right = root_left;
            temp.right = root_right;
            root.left = null;
        }
        if (root.right != null)
            flatten(root.right);
    }
}