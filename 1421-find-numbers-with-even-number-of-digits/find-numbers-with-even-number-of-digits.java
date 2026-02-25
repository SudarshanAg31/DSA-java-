class Solution {
    public int findNumbers(int[] arr) {
       int count=0;
       for(int i=0;i<arr.length;i++){
            int x=(int)Math.log10(arr[i])+1;
            if(x%2==0)count++;
       } 
       return count;
    }
}