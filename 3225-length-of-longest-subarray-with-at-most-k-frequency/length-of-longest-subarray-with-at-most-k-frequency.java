class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < nums.length) {
            if (!mp.containsKey(nums[j])) {
                mp.put(nums[j], 1);
            } else {
                mp.put(nums[j], mp.get(nums[j]) + 1);
            }
            while (mp.get(nums[j]) > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }
            max = Math.max(j - i + 1, max);
            j++;
        }
        return max;
    }
}