class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i<nums.length ; i++){
            set.add(nums[i]);
        }
        int sum = nums[0];
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i-1]==nums[i]-1){
                sum+=nums[i];
            }else{
                break;
            }
        }
        while(true){
            if(!set.contains(sum)){
                return sum;
            }else{
                sum++;
            }
        }        
    }
}