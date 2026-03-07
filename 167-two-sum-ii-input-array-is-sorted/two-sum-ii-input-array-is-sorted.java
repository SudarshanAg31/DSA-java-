class Solution {
    public int[] twoSum(int[] arr, int target) {
        int ans[]=new int[2];
        int a=0;
        int b=arr.length-1;
        while(a<b){
            if(target-arr[a]==arr[b]){
                ans[0]=a+1;
                ans[1]=b+1;
                return ans;
            }
            else if(target-arr[a]<arr[b]){
                b--;
            }
            else{
                a++;
            }
        }
        return ans;
    }
}