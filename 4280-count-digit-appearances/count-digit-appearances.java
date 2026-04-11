class Solution {
    public int countDigitOccurrences(int[] arr, int digit) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            while(arr[i]!=0){
                int y=arr[i]%10;
                if(digit==y)count++;
                arr[i]/=10;
            }
        }
        return count;
    }
}