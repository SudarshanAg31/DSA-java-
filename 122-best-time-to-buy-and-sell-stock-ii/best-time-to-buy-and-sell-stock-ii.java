class Solution {
    public int maxProfit(int[] arr) {
        if(arr.length==1)return 0;
        int max=arr[0];
        int min=arr[0];
        int diff=0;
        int sum=0;
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
                max=arr[i];
            }
            else if(max<arr[i]);
            max=arr[i];
            diff=max-min;
            if(diff!=0){
                sum+=diff; 
                min=arr[i];
                max=arr[i];                    
                }
        }
        return sum;
    }
}