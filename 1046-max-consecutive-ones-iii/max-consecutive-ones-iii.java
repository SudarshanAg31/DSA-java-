class Solution {
    public int longestOnes(int[] arr, int k) {
        int count=0;
        int s=0;
        int max=0;
        for(int e=0;e<arr.length;e++){
            if(arr[e]!=1){
                count++;
            }
            while(count>k){
                if(arr[s]!=1)count--;
                s++;
            }
            max=Math.max(max,e-s+1);
        }
        return max;
    }
}