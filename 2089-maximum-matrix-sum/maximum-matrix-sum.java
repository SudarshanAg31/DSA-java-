class Solution {
    public long maxMatrixSum(int[][] arr) {
        long sum=0;
        int count=0;
        int min=Math.abs(arr[0][0]);
       for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            if(arr[i][j]<0){
                count++;
                sum+=-1*arr[i][j];
            }
            else{
                sum+=arr[i][j];
            }
            if(Math.abs(arr[i][j])<min){
                min=Math.abs(arr[i][j]);
            }
        }
       } 
       if(count%2!=0){
        if(min==0)return sum;
        else return sum-(2*min);
       }
       else return sum;
    }
}