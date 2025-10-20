class Solution {
    public int[] sortedSquares(int[] arr) {
    int[]ans=new int[arr.length];
    int s=0;
    int e=arr.length-1;
    int i=ans.length-1;
    while(i>=0){
        if(Math.abs(arr[s])<Math.abs(arr[e])){
            ans[i]=arr[e]*arr[e];
            e--;
            i--;
        }
        else{
            ans[i]=arr[s]*arr[s];
            s++;
            i--;
        }
    }
    return ans;
}
}