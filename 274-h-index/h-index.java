class Solution {
    public int hIndex(int[] arr) {
        int[] ans=new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr.length){
                ans[arr.length]++;
            }
            else{
                ans[arr[i]]++;
            }
        }
        int count=0;
        int x=0;
        for(int i=ans.length-1;i>=0;i--){
            if((count+ans[i])>=i){
                x=i;
                break;
            }
            else{
                count+=ans[i];
            }
        }
        return x;
    }
}