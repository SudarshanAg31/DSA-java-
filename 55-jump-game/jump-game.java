class Solution {
    public boolean canJump(int[] arr) {
        int last=arr.length-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]+i>=last){
                last=i;
            }
        }
        return last==0;
    }
}