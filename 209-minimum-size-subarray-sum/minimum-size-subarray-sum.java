class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        if(arr.length==0)return 0;
        int s=0;
        int e=0;
        int min=1000000;
        int sum=arr[0];
        while(e<arr.length){
            if(sum<target){
                e++;
                if(e<arr.length)
                sum+=arr[e];
            }
            else{ 
                min=Math.min(e-s+1,min);
                sum-=arr[s];
                s++;
            }
        }
        if(min==1000000)return 0;
        return min;
    }
}