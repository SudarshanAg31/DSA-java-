class Solution {
    public int removeDuplicates(int[] arr) {
        int j=2;
        for(int i=2;i<arr.length;i++){
            if(arr[j-2]<arr[i]){
                arr[j]=arr[i];
                j++;
            }
        }
        return j;
    }
}