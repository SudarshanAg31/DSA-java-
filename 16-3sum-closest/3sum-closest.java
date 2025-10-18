class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int diff=100000;
        int ans=0;
        for(int i=0;i<arr.length-2;i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==target){
                    return sum;
                }
                else if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
                int maxdiff=Math.abs(sum-target);
                if(maxdiff<diff){
                    ans=sum;
                    diff=maxdiff;
                }
            }
        }
        return ans;
    }
}