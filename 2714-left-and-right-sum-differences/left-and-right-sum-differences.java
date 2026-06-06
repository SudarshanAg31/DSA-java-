class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left_sum=new int[nums.length];
        int[] right_sum=new int[nums.length];
        int sum=0;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i-1];
            left_sum[i]=sum;
        }
        sum=0;
        for(int i=nums.length-2;i>=0;i--){
            sum+=nums[i+1];
            right_sum[i]=sum;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(left_sum[i]-right_sum[i]);
        }
        return nums;
    }
}