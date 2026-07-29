class Solution {
    public int[] singleNumber(int[] nums) {
        int n = 0;
        //xor all
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        //mask n
        n = ((n & (n - 1)) ^ n);
        int a = 0;
        int b = 0;
        //if zero a else b
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & n) != 0) {
                b ^= nums[i];
            } else {
                a ^= nums[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}