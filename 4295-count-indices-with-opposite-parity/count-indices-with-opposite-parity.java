class Solution {
    public boolean check(int n){
        if(n%2==0)return true;
        else return false;
    }
    public int[] countOppositeParity(int[] nums) {
        int[]result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            boolean x=true;
            int count=0;
            if(check(nums[i])!=true){
                x=false;
            }
            for(int j=i+1;j<nums.length;j++){
                if(check(nums[j])!=(x)){
                    count++;
                }
            }
            result[i]=count;
        }  
        return result;
    }
}