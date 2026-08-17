class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr.length == 1) {
            if (arr[0] > k) return k;
            else return k + 1;
        } 
       int s=0; 
       int e=arr.length-1;
       while(s<=e){
        int mid=s+(e-s)/2;
        if((arr[mid]-mid-1)<k) s=mid+1;
        else e=mid-1;
       }
       if(e==-1) return k;
        int x=arr[e]-e-1;
        k-=x;
        return arr[e]+k; 
    }
}