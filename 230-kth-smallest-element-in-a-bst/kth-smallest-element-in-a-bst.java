class Solution {
    static int ans = 0;
    static int a = 0;

    public void inorder(TreeNode root, int k) {
        if (root == null)
            return;
        inorder(root.left, k);
        if (a == k)
            ans = root.val;
        a++;
        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        a = 1;
        inorder(root, k);
        return ans;
    }
}