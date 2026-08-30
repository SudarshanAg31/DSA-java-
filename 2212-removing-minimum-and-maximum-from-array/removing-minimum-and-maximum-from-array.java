class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find min and max indices
        for (int i = 0; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Make left smaller and right bigger
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // 3 possibilities
        int fromFront = right + 1;

        int fromBack = n - left;

        int fromBoth = (left + 1) + (n - right);

        return Math.min(fromFront,
                Math.min(fromBack, fromBoth));
    }
}