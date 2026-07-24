class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int ans = 1;

        for (int num : nums) {
            if (num == ans)
                ans++;
            else if (num > ans)
                break;
        }

        return ans;
    }
}