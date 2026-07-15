class Solution {
    public int missingNumber(int[] nums) {
        // PriorityQueue<Integer>q=new PriorityQueue<>();
        // for(int i=0;i<nums.length;i++){
        //     q.add(nums[i]);
        // } 
        // int count=0;
        // while(!q.isEmpty()){
        //     if(q.remove()!=count)return count;
        //     count++;
        // }
        // return nums.length;
        
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int total=(n*(n+1))/2;
        return total-sum;
    }
}