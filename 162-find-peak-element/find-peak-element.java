class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (0 == mid) {
                if (nums[0] < nums[1])
                    return 1;
                else
                    return 0;
            }
            if (nums.length - 1 == mid) {
                if (nums[mid] > nums[mid - 1])
                    return nums.length - 1;
                else
                    return mid - 1;
            }
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
                return mid;
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}