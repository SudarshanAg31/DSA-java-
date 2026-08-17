class Solution {
    public int singleNonDuplicate(int[] arr) {
        if(arr.length==1)return arr[0];
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            // for last index
            if(mid==arr.length-1&&arr[mid]!=arr[mid-1]){
                return arr[mid];
            }
            // for first index
            if(mid==0&&arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            // for middle index
            if(arr[mid]!=arr[mid-1]&&arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]==arr[mid-1]){
                if((s+mid+1)%2==1){
                    e=mid-2;// we skip pair 
                }
                else{
                 s=mid+1;   
                }
            }
            else{
                if((e+mid+1)%2==1){
                    s=mid+2;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }
}