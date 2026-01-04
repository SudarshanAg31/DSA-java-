class Solution {
    public int check(int x){
        int sum=0;
        int count=0;
        for(int i=1;i*i<=x;i++){
            if(x%i==0){
                sum+=i;
                int othr=x/i;
                count++;
                if(othr!=i){
                    sum+=othr;
                    count++;
                }
            }
        }
        if(count==4){
            return sum;
        }
        else return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int x=0;
        for(int i=0;i<nums.length;i++){
            x+=check(nums[i]);
        }
        return x;
    }
}