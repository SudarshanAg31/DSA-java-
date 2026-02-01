class Solution {
    public int minimumCost(int[] nums) {
        int ans=nums[0];
        int min1=51;
        int min2=51;
        for(int i=1;i<nums.length;i++){
            if(min1>nums[i]){
                min2=min1;
                min1=nums[i];
            }
            else if(min2>nums[i]){
                min2=nums[i];
            }
        }
        return ans+min1+min2;
    }
}