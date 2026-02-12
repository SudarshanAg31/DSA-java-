class Solution {
    public int jump(int[] arr) {
        int max=0;
        int jump=0;
        int curr=0;
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,i+arr[i]);
            if(i==curr){
                jump++;
                curr=max;
            }
        }
        return jump;
    }
}