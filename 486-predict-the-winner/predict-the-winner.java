class Solution {
    public int fun(int[] nums, int i, int j, boolean check, int a, int b) {
        if (i > j)
            return a-b;
        if (check) {
            int left = fun(nums, i + 1, j, false, a + nums[i], b);
            int right = fun(nums, i, j - 1, false, a + nums[j], b);
            return Math.max(left, right);
        } else {
            int left = fun(nums, i + 1, j, true, a, b + nums[i]);
            int right = fun(nums, i, j - 1, true, a, b + nums[j]);
            return Math.min(left, right);
        }
    }

    public boolean predictTheWinner(int[] nums) {
        return fun(nums, 0, nums.length - 1, true, 0, 0)>=0;
    }
}