class Solution {
    public int pivotIndex(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            arr[i]=nums[i-1]+arr[i-1];
        }
        int sum=arr[arr.length-1]+nums[nums.length-1];
        for(int i=0;i<arr.length;i++){
            int left=arr[i];
            int right=sum-left-nums[i];
            if(left==right)return i;
        }
        return -1;
    }
}