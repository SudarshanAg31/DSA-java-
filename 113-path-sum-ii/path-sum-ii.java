class Solution {
    public void fun(TreeNode root, int target, List<List<Integer>> ans, List<Integer> li) {
        if (root == null)
            return;
        li.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            ArrayList<Integer> temp = new ArrayList<>(li);
            ans.add(temp);
            li.remove(li.size() - 1);
            return;
        }
        fun(root.left, target - root.val, ans, li);
        fun(root.right, target - root.val, ans, li);
        li.remove(li.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        fun(root, targetSum, ans, li);
        return ans;
    }
}