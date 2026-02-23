class Solution {
    public boolean check_prime(int x){
        if(x<=1)return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0)return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int ans=0;
     for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums[0].length;j++){
            if(i==j||i+j==nums.length-1){
                if(check_prime(nums[i][j])){
                    ans=Math.max(ans,nums[i][j]);
                }
            }
        }
     }
     return ans;  
    }
}