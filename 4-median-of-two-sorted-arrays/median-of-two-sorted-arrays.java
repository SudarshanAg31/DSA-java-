import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[n+m];
        for(int i=0;i<n;i++){
            arr[i]=nums1[i];
        }
        for(int i=0;i<m;i++){
            arr[n+i]=nums2[i];
        }
        Arrays.sort(arr);
        int temp=(n+m)/2;
        if((n+m)%2==0){
            return (arr[temp]+arr[temp-1])/2.0;
        }
        else{
            return arr[temp];
        }
    }
}