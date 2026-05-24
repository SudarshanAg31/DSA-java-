class Solution {
    public int minOperations(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                if(i==j)continue;
                int total=0;
                for(int a=0;a<nums.length;a++){
                    int target=0;
                    if(a%2==0){
                        target=i;
                    }
                    else{
                        target=j;
                    }
                    int rem=nums[a]%k;
                    int ic=(target-rem+k)%k;
                    int dec=(rem-target+k)%k;
                    total+=Math.min(ic,dec);
                }
                ans=Math.min(ans,total);
            }
        }
        return ans;
    }
}