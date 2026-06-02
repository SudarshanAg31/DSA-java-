class Solution {
    public TreeNode insert(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insert(root.left, val);
        }
        if (root.val < val) {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                insert(root.right, val);
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            root = insert(root, preorder[i]);
        }
        return root;
    }
}