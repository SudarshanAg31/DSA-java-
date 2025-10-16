class Solution {
    public static int ans(int s,int n,int[]arr){
        int max=0;
        while(s<=n){
            int temp=Math.min(arr[s],arr[n])*((n)-s);
            if (max<temp){
                max=temp;
            }
            if(arr[s]<arr[n]){
                s++;
            }
            else{
                n--;
            }
        }
        return max;
    }
    public int maxArea(int[] arr) {
       int n=arr.length;
       return ans(0,n-1,arr);
    }
}