class Solution {
    public int searchInsert(int[] arr, int target) {
              if(arr[0]>target)return 0;
        if(arr[arr.length-1]<target)return arr.length;
        int s=0;
        int e=arr.length-1;
        // int mid=s+e/2;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;  
    }
}