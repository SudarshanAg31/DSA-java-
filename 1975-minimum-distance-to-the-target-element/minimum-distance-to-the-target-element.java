class Solution {
    public int getMinDistance(int[] arr, int target, int start) {
      int ans=Integer.MAX_VALUE;
      int i=start;
      int n=arr.length;
      for(int j=0;j<arr.length;j++){
        if(arr[start]==target){
            ans=Math.min(ans,Math.abs(start-i));
        }
        start++;
        if(start>n-1){
            start=0; 
        }
      }  
      return ans;
    }
}