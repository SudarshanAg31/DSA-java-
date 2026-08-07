class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target)
                return new int[] { 0, 0 };
            return new int[] { -1, -1 };
        }
        int s = 0;
        int e = nums.length - 1;
        int[] ans = new int[2];
        for (int i = 0; i < ans.length; i++)
            ans[i] = -1;
        if (nums.length == 0)
            return ans;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        if (s == 0 || nums[s - 1] != target)
            return ans;
        ans[1] = s - 1;
        s = 0;
        e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] >= target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        ans[0] = s;
        return ans;
    }
}