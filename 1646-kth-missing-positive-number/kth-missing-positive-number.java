class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count=0;
        int i=0;
        int check=1;
        while(k!=count){
            if(i<arr.length&&arr[i]==check){
                i++;
            }
            else{
                count++;
            }
            check++;
        }
        return check-1;
    }
}