class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],1);
            }
            else{
            return nums[i];
            }
        }
        return -1;
    }
}