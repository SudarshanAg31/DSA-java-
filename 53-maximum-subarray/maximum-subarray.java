class Solution {
    public int maxSubArray(int[] nums) {
        int best=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int val=best+nums[i];
            best=Math.max(nums[i],val);
            ans=Math.max(ans,best);
        }
        return ans;
    }
}