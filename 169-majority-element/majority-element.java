class Solution {
    public int majorityElement(int[] arr) {
        if(arr.length==1)return arr[0];
        int p=arr[0];
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(p==arr[i]){
                count++;
            }
            else if(count==0){
                p=arr[i];
                count++;
            }
            else{
                count--;
            }
        }
        return p;
    }
}