class Solution {
    public int minimumPrefixLength(int[] arr) {
        int i=arr.length-1;
        while(i>0&&arr[i-1]<arr[i]){
            i--;
        }
        return i;
    }
}