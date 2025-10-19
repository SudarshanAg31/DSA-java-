class Solution {
    public int removeElement(int[] arr, int val) {
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            if(arr[s]!=val){
                s++;
            }
            else{
                while(e>=s&&arr[e]==val){
                    e--;
                }
                if(s<e){
                arr[s]=arr[e];
                e--;
                }
                else{
                    break;
                }
            }
        }
        return s;
    }
}