class Solution {
    public void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int minimumSwaps(int[] nums) {
        int count=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            while(i<j&&nums[i]!=0){
                i++;
            }
            while(i<j&&nums[j]==0){
                j--;
            }
            if(i<j){
            swap(nums,i,j);
            i++;
            j--;
            count++;
            }
        }
        return count;
    }
}