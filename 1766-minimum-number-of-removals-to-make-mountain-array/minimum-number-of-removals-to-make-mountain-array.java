class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dpr = new int[nums.length];
        int[] dpl = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dpl[j]);
                }
            }
            dpl[i] = max + 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dpr[j]);
                }
            }
            dpr[i] = max + 1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dpl[i] > 1 && dpr[i] > 1) {
                max = Math.max(max, dpl[i] + dpr[i] - 1);
            }
        }
        return nums.length - max;
    }
}