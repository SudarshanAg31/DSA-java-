class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;

        for (int weight : weights) {
            s = Math.max(s, weight);
            e += weight;
        }
        int ans = e;
        while(s<=e){
            int mid=s+(e-s)/2;
            int total_sum=0;
            int count=1;
            for(int i=0;i<weights.length;i++){
                if(total_sum+weights[i]<=mid){
                    total_sum+=weights[i];
                }
                else{
                    count++;
                    total_sum=weights[i];
                }
            }
            if(count<=days){
                ans=Math.min(ans,mid);
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}