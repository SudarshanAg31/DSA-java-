class Solution {
    public TreeNode fun(int[] nums, int l, int h) {
        if (l > h)
            return null;
        int mid = (l + h) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fun(nums, l, mid - 1);
        root.right = fun(nums, mid + 1, h);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return fun(nums, 0, nums.length - 1);
    }
}