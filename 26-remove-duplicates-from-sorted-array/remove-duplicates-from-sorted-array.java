class Solution {
    public int removeDuplicates(int[] arr) {
        int s=0;
        for(int e=1;e<arr.length;e++){
            if(arr[s]!=arr[e]){
                s++;
                arr[s]=arr[e];
            }
        }
        return s+1;
    }
}