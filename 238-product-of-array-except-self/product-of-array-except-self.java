class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int [nums.length];
        int[] right=new int [nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        int ans=1;
        for(int i=1;i<nums.length;i++){
            ans*=nums[i-1];
            left[i]=ans;
        }
        ans=1;
        for(int i=nums.length-2;i>=0;i--){
            ans*=nums[i+1];
            right[i]=ans;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}